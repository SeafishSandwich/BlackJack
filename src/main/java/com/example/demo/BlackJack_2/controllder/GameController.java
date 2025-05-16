package com.example.demo.BlackJack_2.controllder;

import com.example.demo.BlackJack_2.model.GameSession;
import com.example.demo.BlackJack_2.model.GameState;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/game")

public class GameController {
    private final GameSession gameSession;
    public GameController(GameSession gameSession){

        this.gameSession = gameSession;
    }
    //start new round
    @PostMapping("/start")
    public GameState startGame() throws InterruptedException {
        if (gameSession == null) {
            throw new IllegalStateException("Game session is not available.");
        }
        gameSession.startGame();
        return gameSession.getState();
    }

    //Hit
    @PostMapping("/hit")
    public GameState hit(){
        return gameSession.hit();
    }

    //Stand
    @PostMapping("/stand")
    public GameState stand() throws InterruptedException {
        return  gameSession.stand();
    }
    
    @PostMapping("/cheat")
    public GameState Cheat() throws InterruptedException{
    	return gameSession.Cheat();
    }
    

    @PostMapping("/state")
    public GameState getState(){
        return gameSession.getState();
    }

}
