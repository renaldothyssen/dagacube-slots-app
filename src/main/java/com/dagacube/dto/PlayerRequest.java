package com.dagacube.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequest {

    private Long playerId;
    private BigDecimal amount;
    private String transactionId;
}
