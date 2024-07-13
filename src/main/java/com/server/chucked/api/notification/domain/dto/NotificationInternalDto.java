package com.server.chucked.api.notification.domain.dto;

import com.server.chucked.api.notification.domain.entity.Notification;
import lombok.Builder;

public record NotificationInternalDto() {
    @Builder
    public record Create(
            String type,
            String message
    ) {
        public static Notification toEntity(NotificationInternalDto.Create dto) {
            return Notification.builder()
                    .type(dto.type)
                    .message(dto.message)
                    .build();
        }

        public static NotificationInternalDto.Create of(Notification entity) {
            return Create.builder()
                    .type(entity.getType())
                    .message(entity.getMessage())
                    .build();
        }
    }
}
