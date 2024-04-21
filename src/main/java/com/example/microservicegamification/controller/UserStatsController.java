package com.example.microservicegamification.controller;


import com.example.microservicegamification.entities.GameStats;
import com.example.microservicegamification.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class UserStatsController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public GameStats getStatsForUser(@RequestParam("userId") final Long userId) {
        return gameService.retrieveStatsForUser(userId);
    }

}