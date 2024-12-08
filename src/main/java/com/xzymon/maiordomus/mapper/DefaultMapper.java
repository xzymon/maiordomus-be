package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.DummyMessageDTO;
import com.xzymon.maiordomus.model.DummyMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DefaultMapper {
    DefaultMapper INSTANCE = Mappers.getMapper(DefaultMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "message", source = "message")
    DummyMessageDTO toDummyMessageDto(DummyMessage message);
}
