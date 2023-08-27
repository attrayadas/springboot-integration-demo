package com.attraya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;

@Configuration
@EnableIntegration
public class SpringIntegrationConfig {

    @Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "1000") ) // read automatically in 1secs
    public FileReadingMessageSource fileReadingMessageSource(){
        FileReadingMessageSource reader = new FileReadingMessageSource();
        reader.setDirectory(new File("C:\\Users\\Attraya\\Desktop\\Sources"));
        return reader;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public FileWritingMessageHandler fileWritingMessageHandler(){
        FileWritingMessageHandler writer = new FileWritingMessageHandler(new File("C:\\Users\\Attraya\\Desktop\\Destination"));
        writer.setAutoCreateDirectory(true); // to create "Destination" folder automatically
        writer.setExpectReply(false);
        return writer;
    }
}
