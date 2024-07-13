package com.server.chucked.api.notification.domain;

import com.server.chucked.api.notification.domain.dto.NotificationInternalDto;
import com.server.chucked.api.notification.domain.entity.Notification;
import com.server.chucked.api.notification.domain.persistence.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationProcessorImpl implements NotificationProcessor {
    private final NotificationRepository notificationRepository;
    @Override
    public NotificationInternalDto.Create create(NotificationInternalDto.Create dto) {
        Notification notification = NotificationInternalDto.Create.toEntity(dto);

        Notification saved = notificationRepository.save(notification);

        return NotificationInternalDto.Create.of(saved);
    }
}
