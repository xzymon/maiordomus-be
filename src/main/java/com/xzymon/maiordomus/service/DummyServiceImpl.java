package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.DummyMessage;
import com.xzymon.maiordomus.repository.DummyMessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

	private final DummyMessageRepository dummyMessageRepository;

	public DummyServiceImpl(DummyMessageRepository dummyMessageRepository) {
		this.dummyMessageRepository = dummyMessageRepository;
	}

	@Override
	public List<DummyMessage> getAll() {
		return (List<DummyMessage>) this.dummyMessageRepository.findAll();
	}

	public void initRepo() {
		List<DummyMessage> dummyMessages = new ArrayList<>();
		dummyMessages.add(new DummyMessage(1L, "Pierwsza wiadomosc"));
		dummyMessages.add(new DummyMessage(2L, "Druga wiadomosc"));
		dummyMessages.add(new DummyMessage(3L, "Trzecia wiadomosc"));

		dummyMessageRepository.saveAll(dummyMessages);

	}
}
