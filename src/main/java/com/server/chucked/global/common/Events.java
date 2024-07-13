package com.server.chucked.global.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Events {
    private static ApplicationEventPublisher eventPublisher;

    public static void setPublisher(ApplicationEventPublisher applicationEventPublisher) {
        Events.eventPublisher = applicationEventPublisher;
    }

    public static void raise(Object event) {
        eventPublisher.publishEvent(event);
    }
}