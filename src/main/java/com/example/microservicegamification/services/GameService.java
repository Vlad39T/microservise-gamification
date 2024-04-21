package com.example.microservicegamification.services;

import com.example.microservicegamification.entities.GameStats;

public interface GameService {
    GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct);
    GameStats retrieveStatsForUser(Long userId);
}