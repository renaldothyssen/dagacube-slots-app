package com.dagacube.service;

import com.dagacube.dto.PlayerRequest;
import com.dagacube.enums.Operation;
import com.dagacube.enums.ErrorMessage;
import com.dagacube.exception.ErrorResponse;
import com.dagacube.exception.PlayerNotFoundException;
import com.dagacube.model.PlayerModel;
import com.dagacube.repository.PlayerRepository;
import com.dagacube.service.logging.PlayerLoggingService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;
    private final PlayerLoggingService playerLoggingService;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerLoggingService playerLoggingService) {
        this.playerRepository = playerRepository;
        this.playerLoggingService = playerLoggingService;
    }

    @Override
    public ResponseEntity<?> process(PlayerRequest playerRequest, String action) {
        long playerLogId = playerLoggingService.auditRequestMessage(playerRequest.getTransactionId(), playerRequest.getPlayerId(),playerRequest.toString(), HttpMethod.POST.toString());
        Operation operation = Operation.fromValue(action);
        if(operation == null){
            playerLoggingService.auditResponseMessage(playerLogId,"",ErrorMessage.INVALID_OPERATION.getValue());
            return ResponseEntity.badRequest().body(ErrorResponse.builder()
                    .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .error(ErrorMessage.INVALID_OPERATION.getValue())
                    .transactionId(playerRequest.getTransactionId())
                    .build());
        }
        PlayerModel playerModel  = getPlayerById(playerRequest.getPlayerId(), playerRequest.getTransactionId());
        BigDecimal balance = calculateBalance(playerRequest.getAmount(),playerModel.getCurrentBalance(),operation);
        log.info("Transaction processed for Player {}, new balance: {}",playerRequest.getPlayerId(), balance);
        assert balance != null;
        if(balance.intValue() >= 0){
            playerModel.setCurrentBalance(balance.setScale(2,BigDecimal.ROUND_HALF_EVEN));
            playerModel.setModifiedDate(LocalDateTime.now());
            playerRepository.save(playerModel);
            playerLoggingService.auditResponseMessage(playerLogId,operation.getValue(),HttpStatus.OK.getReasonPhrase());
            return ResponseEntity.ok().build();
        }
        playerLoggingService.auditResponseMessage(playerLogId,operation.getValue(),HttpStatus.I_AM_A_TEAPOT.getReasonPhrase());
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .errorCode(String.valueOf(HttpStatus.I_AM_A_TEAPOT.value()))
                .error(HttpStatus.I_AM_A_TEAPOT.getReasonPhrase())
                .transactionId(playerRequest.getTransactionId())
                .build());

    }

    @Override
    public PlayerModel getPlayerById(long id, String transactionId) {
        log.info("Retrieving details for player : {}",id);
        Optional<PlayerModel> playerModel = playerRepository.findById(id);
        if(playerModel.isPresent()){
            return playerModel.get();
        }else{
            log.error("Player not found with id: {}", id);
            throw new PlayerNotFoundException(ErrorMessage.PLAYER_NOT_FOUND.getValue());
        }
    }

    private BigDecimal calculateBalance(BigDecimal amount, BigDecimal currentBalance, Operation operation){
        switch (operation){
            case ADD:
                return currentBalance.add(amount);
            case SUBTRACT:
                return currentBalance.subtract(amount);
        }
        return null;
    }
}