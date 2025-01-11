package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
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
	@GeneratedValue(generator = "dummy_message_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String message;

	public DummyMessage(String message) {
		this.message = message;
	}
}
