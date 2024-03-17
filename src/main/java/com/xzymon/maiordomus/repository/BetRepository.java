package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
	Bet findByInstrument(String instrument);
}
