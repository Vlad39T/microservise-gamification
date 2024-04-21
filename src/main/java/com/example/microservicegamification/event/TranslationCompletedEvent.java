package com.example.microservicegamification.event;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class TranslationCompletedEvent implements Serializable {

    private final Long translationResultAttemptId;
    private final Long userId;
    private final boolean correct;

    public TranslationCompletedEvent(Long translationResultAttemptId, Long userId, boolean correct) {
        this.translationResultAttemptId = translationResultAttemptId;
        this.userId = userId;
        this.correct = correct;
    }

    public TranslationCompletedEvent() {
        this(0L, 0L, false);
    }


}