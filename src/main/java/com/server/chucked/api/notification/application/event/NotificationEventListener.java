package com.server.chucked.api.notification.application.event;

import com.server.chucked.api.notification.domain.NotificationProcessor;
import com.server.chucked.api.notification.domain.dto.NotificationInternalDto;
import com.server.chucked.api.product.application.event.CreateProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationEventListener {
    private final NotificationProcessor notificationProcessor;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void createProductEventListener(final CreateProductEvent event) {
        NotificationInternalDto.Create create = NotificationInternalDto.Create.builder()
                .type(event.type())
                .message(event.message())
                .build();

        notificationProcessor.create(create);

        log.info("createProductEventListener: {}", event);
    }
}
