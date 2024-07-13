package com.server.chucked.global.config;

import com.server.chucked.global.common.Events;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EventConfig {
    public final ApplicationEventPublisher publisher;

    @Bean
    public InitializingBean eventInitializer() {
        return () -> Events.setPublisher(publisher);
    }
}