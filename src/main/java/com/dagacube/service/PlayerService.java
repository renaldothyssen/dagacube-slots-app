package com.dagacube.service;

import com.dagacube.dto.PlayerRequest;
import com.dagacube.model.PlayerModel;
import org.springframework.http.ResponseEntity;


public interface PlayerService {

    ResponseEntity<?> process(PlayerRequest playerRequest, String action);
    PlayerModel getPlayerById(long id, String transactionId);

}
