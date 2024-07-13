package com.server.chucked.api.notification.domain.entity;

import com.server.chucked.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notification")
public class Notification extends BaseEntity {
    @Comment("알림 타입")
    @Column(name = "type", nullable = false, columnDefinition = "VARCHAR(200)")
    String type;

    @Comment("알림 메시지")
    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    String message;
}
