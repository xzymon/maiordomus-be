package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.api.v1.model.BetDTO;

public interface BetService {
	BetDTO getBetByInstrument(String name);
}
