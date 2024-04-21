package com.example.microservicegamification.event;

import com.example.microservicegamification.services.GameService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    private final GameService gameService;

    @Autowired
    EventHandler(final GameService gameService) {
        this.gameService = gameService;
    }

    @RabbitListener(queues = "${translation.queue}")
    void handleTranslationCompleted(final TranslationCompletedEvent event) {
        try {
            gameService.newAttemptForUser(event.getUserId(),
                    event.getTranslationResultAttemptId(),
                    event.isCorrect());
        } catch (final Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}