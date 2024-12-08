package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.DummyMessage;
import org.springframework.data.repository.CrudRepository;

public interface DummyMessageRepository extends CrudRepository<DummyMessage, Long> {
}
