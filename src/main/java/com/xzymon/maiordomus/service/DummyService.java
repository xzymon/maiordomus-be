package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.DummyMessage;

import java.util.List;

public interface DummyService {
	List<DummyMessage> getAll();
	void initRepo();
}
