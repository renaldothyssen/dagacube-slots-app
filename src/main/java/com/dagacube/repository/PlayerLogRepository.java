package com.dagacube.repository;

import com.dagacube.model.PlayerLogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerLogRepository extends JpaRepository<PlayerLogModel, Long> {

    List<PlayerLogModel> findTop10ByPlayerId(Long playerId);

}
