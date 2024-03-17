package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.api.v1.mapper.BetMapper;
import com.xzymon.maiordomus.api.v1.model.BetDTO;
import com.xzymon.maiordomus.repository.BetRepository;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements BetService {
	private final BetMapper betMapper;
	private final BetRepository betRepository;

	public BetServiceImpl(BetMapper betMapper, BetRepository betRepository) {
		this.betMapper = betMapper;
		this.betRepository = betRepository;
	}

	@Override
	public BetDTO getBetByInstrument(String instrument) {
		return betMapper.betToDto(betRepository.findByInstrument(instrument));
	}
}
