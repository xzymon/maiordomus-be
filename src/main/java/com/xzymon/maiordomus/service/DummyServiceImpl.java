package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.db.DummyMessage;
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
		dummyMessages.add(new DummyMessage("Pierwsza wiadomosc"));
		dummyMessages.add(new DummyMessage("Druga wiadomosc"));
		dummyMessages.add(new DummyMessage("Trzecia wiadomosc"));

		dummyMessageRepository.saveAll(dummyMessages);

	}

	@Override
	public void add(DummyMessage message) {
		dummyMessageRepository.save(message);
	}
}
