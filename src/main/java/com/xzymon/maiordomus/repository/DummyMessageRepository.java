package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.db.DummyMessage;
import org.springframework.data.repository.CrudRepository;

public interface DummyMessageRepository extends CrudRepository<DummyMessage, Long> {
}
