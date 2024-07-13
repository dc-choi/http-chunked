package com.server.chucked.api.notification.domain;

import com.server.chucked.api.notification.domain.dto.NotificationInternalDto;

public interface NotificationProcessor {
    public NotificationInternalDto.Create create(final NotificationInternalDto.Create dto);
}
