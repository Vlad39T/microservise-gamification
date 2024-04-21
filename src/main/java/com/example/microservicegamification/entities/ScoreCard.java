
package com.example.microservicegamification.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "score_card")
public class ScoreCard {

    public static final int DEFAULT_SCORE = 15;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private final Long cardId;

    @Column(name = "USER_ID")
    private final Long userId;

    @Column(name = "ATTEMPT_ID")
    private final Long attemptId;

    @Column(name = "SCORE_TS")
    private final long scoreTimestamp;

    @Column(name = "SCORE")
    private final int score;

    public ScoreCard() {
        this(null, null, null, 0, 0);
    }

    public ScoreCard(Long cardId, Long userId, Long attemptId, long scoreTimestamp, int score) {
        this.cardId = cardId;
        this.userId = userId;
        this.attemptId = attemptId;
        this.scoreTimestamp = scoreTimestamp;
        this.score = score;
    }

    public ScoreCard(Long userId, Long attemptId) {
        this(null, userId, attemptId, System.currentTimeMillis(), DEFAULT_SCORE);
    }
}
