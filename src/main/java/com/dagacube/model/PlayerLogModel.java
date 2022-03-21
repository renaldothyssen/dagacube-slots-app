package com.dagacube.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_PLAYERS_LOG")
public class PlayerLogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "api_request_message")
    private String requestMessage;
    @Column(name = "api_response_message")
    private String responseMessage;
    @Column(name = "http_method")
    private String httpMethod;
    @Column(name = "create_dt")
    LocalDateTime createDate;
    @Column(name = "modified_dt")
    LocalDateTime modifiedDate;
}
