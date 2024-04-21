package com.example.microservicegamification.services;

import com.example.microservicegamification.entities.GameStats;
import com.example.microservicegamification.entities.ScoreCard;
import com.example.microservicegamification.repository.ScoreCardRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private ScoreCardRepository scoreCardRepository;



    @Override
    public GameStats newAttemptForUser(final Long userId, final Long attemptId, final boolean correct) {
        if (correct) {
            ScoreCard scoreCard = new ScoreCard(userId, attemptId);
            scoreCardRepository.save(scoreCard);
            return new GameStats(userId, scoreCard.getScore());
        }
        return GameStats.emptyStats(userId);
    }

    @Override
    public GameStats retrieveStatsForUser(final Long userId) {
        int score = scoreCardRepository.getTotalScoreForUser(userId);
        return new GameStats(userId, score);
    }




}