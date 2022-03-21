package com.dagacube.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_PLAYERS")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(name = "first_name")
    @JsonIgnore
    private String firstName;
    @Column(name = "last_name")
    @JsonIgnore
    private String lastName;
    @Column(name = "user_name")
    @JsonIgnore
    private String userName;
    @Column(name = "current_balance")
    private BigDecimal currentBalance;
    @Column(name = "create_dt")
    @JsonIgnore
    LocalDateTime createDate;
    @Column(name = "modified_dt")
    @JsonIgnore
    LocalDateTime modifiedDate;
}
