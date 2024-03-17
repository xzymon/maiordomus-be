package com.xzymon.maiordomus.api.v1.mapper;

import com.xzymon.maiordomus.api.v1.model.BetDTO;
import com.xzymon.maiordomus.model.Bet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BetMapper {
	BetMapper INSTANCE = Mappers.getMapper(BetMapper.class);

	@Mapping(source = "id", target = "id")
	BetDTO betToDto(Bet bet);

	@Mapping(source = "id", target = "id")
	Bet dtoToBet(BetDTO betDto);
}
