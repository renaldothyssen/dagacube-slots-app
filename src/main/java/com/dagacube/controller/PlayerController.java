package com.dagacube.controller;

import com.dagacube.dto.PLayerLogRequest;
import com.dagacube.dto.PlayerRequest;
import com.dagacube.service.PlayerService;
import com.dagacube.service.logging.PlayerLoggingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerLoggingService playerLoggingService;

    public PlayerController(PlayerService playerService, PlayerLoggingService playerLoggingService) {
        this.playerService = playerService;
        this.playerLoggingService = playerLoggingService;
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayerBalance(@PathVariable long playerId, @RequestHeader (name = "transactionId", required = false) String transactionId){
        Optional<String> transId = Optional.of(Optional.ofNullable(transactionId).orElse(UUID.randomUUID().toString()));
        return ResponseEntity.ok().body(playerService.getPlayerById(playerId, transId.get()));
    }

    @PostMapping("/{playerId}/{action}")
    public ResponseEntity<?> processPlayer(@PathVariable long playerId, @PathVariable String action, @RequestHeader (name = "transactionId", required = false) String transactionId,
                                           @RequestBody PlayerRequest playerRequest){
        Optional<String> transId = Optional.of(Optional.ofNullable(transactionId).orElse(UUID.randomUUID().toString()));
        playerRequest.setTransactionId(transId.get());
        playerRequest.setPlayerId(playerId);
        ResponseEntity<?> responseStatus = playerService.process(playerRequest,action);
        if(responseStatus.getStatusCode().isError()){
            return new ResponseEntity<>(responseStatus.getBody(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity<?> getPLayerData(@RequestBody PLayerLogRequest pLayerLogRequest){
        return ResponseEntity.ok().body(playerLoggingService.getPlayerLogHistory(pLayerLogRequest));
    }
}
