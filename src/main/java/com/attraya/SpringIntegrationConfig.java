package com.attraya;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

import java.io.File;

@Configuration
@EnableIntegration
public class SpringIntegrationConfig {

    @Value("${source.directory}")
    private String sourceDirectory;

    @Value("${target.directory}")
    private String targetDirectory;

    @Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "1000") ) // read automatically in 10secs
    public FileReadingMessageSource fileReadingMessageSource(){
        CompositeFileListFilter<File> filter = new CompositeFileListFilter<>();
        filter.addFilter(new SimplePatternFileListFilter("*.gif"));
        FileReadingMessageSource reader = new FileReadingMessageSource();
        reader.setDirectory(new File(sourceDirectory));
        reader.setFilter(filter);
        return reader;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public FileWritingMessageHandler fileWritingMessageHandler(){
        FileWritingMessageHandler writer = new FileWritingMessageHandler(new File(targetDirectory));
        writer.setAutoCreateDirectory(true); // to create "Destination" folder automatically
        writer.setExpectReply(false);
        return writer;
    }
}
