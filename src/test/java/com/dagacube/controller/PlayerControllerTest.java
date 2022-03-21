package com.dagacube.controller;

import com.dagacube.model.PlayerModel;
import com.dagacube.service.PlayerService;
import com.dagacube.service.logging.PlayerLoggingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    PlayerService playerService;
    @MockBean
    PlayerLoggingService playerLoggingService;
    private final static String GET_PLAYER_URI = "/api/v1/player/{playerId}";
    private final static String PROCESS_PLAYER_URI = "/api/v1/player/{playerId}/{action}";


    @Test
    public void when_getPlayerBalance_actionIsValid_thenSuccess() throws Exception {
        Mockito.when(playerService.getPlayerById(Mockito.anyLong(),Mockito.anyString())).thenReturn(PlayerModel.builder().build());
        mockMvc.perform(MockMvcRequestBuilders.get(GET_PLAYER_URI,1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getPlayerBalance_actionInValid_thenFailure() throws Exception {
        Mockito.when(playerService.getPlayerById(Mockito.anyLong(),Mockito.anyString())).thenReturn(PlayerModel.builder().build());
        mockMvc.perform(MockMvcRequestBuilders.get(GET_PLAYER_URI))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void when_processPlayer_actionEqualsBet_thenSuccess() throws Exception {
        String action = "bet";
        Mockito.when(playerService.process(Mockito.any(),Mockito.any())).thenReturn(ResponseEntity.ok().build());
        mockMvc.perform(MockMvcRequestBuilders.post(PROCESS_PLAYER_URI,1,action).content("OK").contentType(MediaType.APPLICATION_JSON)).andReturn();
    }

    @Test
    public void when_processPlayer_actionEqualsWin_thenSuccess() throws Exception {
        String action = "win";
        Mockito.when(playerService.process(Mockito.any(),Mockito.any())).thenReturn(ResponseEntity.ok().build());
        mockMvc.perform(MockMvcRequestBuilders.post(PROCESS_PLAYER_URI,1,action).content("OK").contentType(MediaType.APPLICATION_JSON)).andReturn();
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_processPlayer_actionIsInvalid_thenSuccess() throws Exception {
        Mockito.when(playerService.process(Mockito.any(),Mockito.any())).thenReturn(ResponseEntity.ok().build());
        mockMvc.perform(MockMvcRequestBuilders.post(PROCESS_PLAYER_URI,1).content("OK").contentType(MediaType.APPLICATION_JSON)).andReturn();
    }
}