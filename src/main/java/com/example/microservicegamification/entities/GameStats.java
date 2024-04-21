
package com.example.microservicegamification.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class GameStats {
    private final Long userId;
    private final int score;

    public GameStats() {
        this(0L, 0);
    }

    public GameStats(Long userId, int score) {
        this.userId = userId;
        this.score = score;
    }

    public static GameStats emptyStats(final Long userId) {
        return new GameStats(userId, 0);
    }

    @Override
    public String toString() {
        return "GameStats{" +
                "userId=" + userId +
                ", score=" + score +
                '}';
    }
}
