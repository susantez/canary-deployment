package com.dfx.advanced.deployment.service.impl;

import com.dfx.advanced.deployment.data.dao.NotebookRepository;
import com.dfx.advanced.deployment.data.model.Notebook;
import com.dfx.advanced.deployment.mapper.NotebookMapper;
import com.dfx.advanced.deployment.service.InventoryService;
import com.dfx.advanced.deployment.service.model.NotebookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    NotebookRepository repository;

    @Autowired
    public InventoryServiceImpl(NotebookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NotebookDto> findAll() {
        Iterable<Notebook> items = repository.findAll();
        List<NotebookDto> result = new ArrayList<>();

        for(Notebook item: items) {
            result.add(NotebookMapper.INSTANCE.notbookToNotebookDto(item));
        }
        return result;
    }

    @Override
    public boolean create(NotebookDto item) {
        repository.save(NotebookMapper.INSTANCE.notebookDtoToNotebook(item));
        return true;
    }

    @Override
    public boolean update(NotebookDto book) {
        return false;
    }

}
