package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.db.DummyMessage;

import java.util.List;

public interface DummyService {
	List<DummyMessage> getAll();
	void initRepo();
	void add(DummyMessage message);
}
