package com.dagacube.service;

import com.dagacube.dto.PlayerRequest;
import com.dagacube.exception.PlayerNotFoundException;
import com.dagacube.model.PlayerModel;
import com.dagacube.repository.PlayerRepository;
import com.dagacube.service.logging.PlayerLoggingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
public class PlayerServiceImplTest {

    @MockBean
    PlayerRepository playerRepository;
    @MockBean
    PlayerLoggingService playerLoggingService;
    PlayerServiceImpl playerService;
    private String transactionId;
    @Before
    public void setUp() {
        transactionId = UUID.randomUUID().toString();
        playerService = new PlayerServiceImpl(playerRepository,playerLoggingService);
    }

    @Test
    public void when_processRequest_actionEqualsWin_thenSuccess() {
        String action = "win";
        Optional<PlayerModel> playerModel = Optional.ofNullable(PlayerModel.builder()
                .id(1L)
                .currentBalance(new BigDecimal("1000"))
                .build());
        Mockito.when(playerRepository.findById(Mockito.any())).thenReturn(playerModel);
        PlayerRequest playerRequest = PlayerRequest.builder()
                .playerId(1L)
                .transactionId(transactionId)
                .amount(new BigDecimal("100"))
                .build();
        Assert.assertTrue(playerService.process(playerRequest, action).getStatusCode().is2xxSuccessful());
    }

    @Test
    public void when_processRequest_actionEqualsBet_thenSuccess() {
        String action = "bet";
        Optional<PlayerModel> playerModel = Optional.ofNullable(PlayerModel.builder()
                .id(1L)
                .currentBalance(new BigDecimal("1000"))
                .build());
        Mockito.when(playerRepository.findById(Mockito.any())).thenReturn(playerModel);
        PlayerRequest playerRequest = PlayerRequest.builder()
                .playerId(1L)
                .transactionId(transactionId)
                .amount(new BigDecimal("100"))
                .build();
        Assert.assertTrue(playerService.process(playerRequest, action).getStatusCode().is2xxSuccessful());
    }

    @Test
    public void when_processRequest_actionIsInValid_thenFailure() {
        String action = "bets";
        PlayerRequest playerRequest = PlayerRequest.builder()
                .playerId(1L)
                .transactionId(transactionId)
                .amount(new BigDecimal("100"))
                .build();
        Assert.assertTrue(playerService.process(playerRequest, action).getStatusCode().isError());
    }

    @Test
    public void when_processRequest_actionIsValid_and_noFundsLeft_thenFailure() {
        String action = "bet";
        Optional<PlayerModel> playerModel = Optional.ofNullable(PlayerModel.builder()
                .id(1L)
                .currentBalance(new BigDecimal("100"))
                .build());
        Mockito.when(playerRepository.findById(Mockito.any())).thenReturn(playerModel);
        PlayerRequest playerRequest = PlayerRequest.builder()
                .playerId(1L)
                .transactionId(transactionId)
                .amount(new BigDecimal("200"))
                .build();
        Assert.assertTrue(playerService.process(playerRequest, action).getStatusCode().isError());
    }

    @Test(expected = PlayerNotFoundException.class)
    public void when_processRequest_isInvalid_thenFailure() {
        String action = "win";
        PlayerRequest playerRequest = PlayerRequest.builder()
                .playerId(1L)
                .transactionId(transactionId)
                .amount(new BigDecimal("100"))
                .build();
        Assert.assertTrue(playerService.process(playerRequest, action).getStatusCode().is2xxSuccessful());
    }

    @Test
    public void when_getPlayerById_isValid_thenSuccess() {
        Optional<PlayerModel> playerModel = Optional.ofNullable(PlayerModel.builder()
                .id(1L)
                .currentBalance(new BigDecimal("1000"))
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build());
        Mockito.when(playerRepository.findById(Mockito.any())).thenReturn(playerModel);
        playerService.getPlayerById(1L,transactionId);
    }

    @Test(expected = PlayerNotFoundException.class)
    public void when_getPlayerById_isInValid_thenFailure() {
        Mockito.when(playerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        playerService.getPlayerById(1L,transactionId);
    }
}