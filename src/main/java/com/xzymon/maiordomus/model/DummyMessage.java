package com.xzymon.maiordomus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dummy_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DummyMessage {
	@Id
	private Long id;
	private String message;
}
