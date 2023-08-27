package com.attraya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;

import java.io.File;

@Configuration
@EnableIntegration
public class SpringIntegrationConfig {

    @Bean
    @InboundChannelAdapter(value = "fileInputChannel")
    public FileReadingMessageSource fileReadingMessageSource(){
        FileReadingMessageSource reader = new FileReadingMessageSource();
        reader.setDirectory(new File("C:\\Users\\Attraya\\Desktop\\Sources"));
        return reader;
    }
}
