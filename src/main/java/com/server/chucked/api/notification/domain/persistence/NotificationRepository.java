package com.server.chucked.api.notification.domain.persistence;

import com.server.chucked.api.notification.domain.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
