package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.NoteDto;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.model.db.Note;
import com.xzymon.maiordomus.model.db.StooqDailyStockCandle;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StructureMapper {
	StructureMapper INSTANCE = Mappers.getMapper(StructureMapper.class);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "title", source = "title")
	@Mapping(target = "category", source = "category")
	@Mapping(target = "content", source = "content")
	@Mapping(target = "createdAt", source = "createdAt")
	@Mapping(target = "updatedAt", source = "updatedAt")
	@Mapping(target = "timeReference", source = "timeReference")
	@Mapping(target = "tags", source = "tags")
	@Mapping(target = "source", source = "source")
	@Mapping(target = "additionalInfo", source = "additionalInfo")
	@Mapping(target = "authorName", source = "authorName")
	NoteDto toNoteDto(Note note);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "title", source = "title")
	@Mapping(target = "category", source = "category")
	@Mapping(target = "content", source = "content")
	@Mapping(target = "createdAt", source = "createdAt")
	@Mapping(target = "updatedAt", source = "updatedAt")
	@Mapping(target = "timeReference", source = "timeReference")
	@Mapping(target = "tags", source = "tags")
	@Mapping(target = "source", source = "source")
	@Mapping(target = "additionalInfo", source = "additionalInfo")
	@Mapping(target = "authorName", source = "authorName")
	Note toNote(NoteDto dto);

	List<NoteDto> noteListToDtoList(List<Note> noteList);
}
