package com.dfx.advanced.deployment.mapper;

import com.dfx.advanced.deployment.service.model.NotebookDto;
import com.dfx.advanced.deployment.data.model.Notebook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotebookMapper {

    NotebookMapper INSTANCE = Mappers.getMapper(NotebookMapper.class);

    NotebookDto notbookToNotebookDto (Notebook item);

    Notebook notebookDtoToNotebook (NotebookDto dto);
}
