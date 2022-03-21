package com.dagacube.service.logging;

import com.dagacube.dto.PLayerLogRequest;
import com.dagacube.exception.UserAccessDeniedException;
import com.dagacube.model.PlayerLogModel;
import com.dagacube.model.PlayerModel;
import com.dagacube.repository.PlayerLogRepository;
import com.dagacube.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlayerLoggingServiceImpl implements PlayerLoggingService{

    private final PlayerLogRepository playerLogRepository;
    private final PlayerRepository playerRepository;

    @Value("${player.secret.password}")
    private String password;

    public PlayerLoggingServiceImpl(PlayerLogRepository playerLogRepository, PlayerRepository playerRepository) {
        this.playerLogRepository = playerLogRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public long auditRequestMessage(String transactionId, long playerId, String requestMessage, String method){
        return playerLogRepository.save(PlayerLogModel.builder()
                .transactionId(transactionId)
                .playerId(playerId)
                .requestMessage(requestMessage)
                .httpMethod(method)
                .createDate(LocalDateTime.now())
                .build()).getId();
    }

    @Override
    public void auditResponseMessage(Long id, String type, String responseMessage){
        Optional<PlayerLogModel> playerLogModel = playerLogRepository.findById(id);
        if(playerLogModel.isPresent()){
            playerLogModel.get().setResponseMessage(responseMessage);
            playerLogModel.get().setTransactionType(type);
            playerLogModel.get().setModifiedDate(LocalDateTime.now());
            playerLogRepository.save(playerLogModel.get());
        }
    }

    @Override
    public List<PlayerLogModel> getPlayerLogHistory(PLayerLogRequest playerLogRequest) {
        if(password.equals(playerLogRequest.getPassword())){
            Optional<PlayerModel> playerModel = Optional.ofNullable(playerRepository.findByUserName(playerLogRequest.getUserName()));
            if(playerModel.isPresent()){
                return playerLogRepository.findTop10ByPlayerId(playerModel.get().getId());
            }
        }
        log.error("User access denied");
        throw new UserAccessDeniedException("User access denied.");
    }
}
