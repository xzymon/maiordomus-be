package com.xzymon.maiordomus.bootstrap;

import com.xzymon.maiordomus.model.Bet;
import com.xzymon.maiordomus.repository.BetRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class MaiordomusBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private BetRepository betRepository;

	public MaiordomusBootstrap(BetRepository betRepository) {
		this.betRepository = betRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.betRepository.saveAll(provideBets());
	}

	private List<Bet> provideBets() {
		return List.of(
				new Bet(1l, "Solana", LocalDateTime.parse("2024-03-17T20:34:23"), LocalDateTime.parse("2024-03-17T20:34:25"), new BigDecimal(10), new BigDecimal(1900), new BigDecimal(2000))
		);
	}
}
