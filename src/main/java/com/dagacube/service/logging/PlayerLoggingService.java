package com.dagacube.service.logging;

import com.dagacube.dto.PLayerLogRequest;
import com.dagacube.model.PlayerLogModel;

import java.util.List;

public interface PlayerLoggingService {

    long auditRequestMessage(String transactionId, long playerId, String requestMessage, String method);
    void auditResponseMessage(Long id, String type, String responseMessage);
    List<PlayerLogModel> getPlayerLogHistory(PLayerLogRequest playerLogRequest);
}
