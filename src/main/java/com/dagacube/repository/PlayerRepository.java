package com.dagacube.repository;

import com.dagacube.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {

    PlayerModel findByUserName(String userName);
}
