package com.dfx.advanced.deployment.service;

import com.dfx.advanced.deployment.service.model.NotebookDto;

import java.util.List;

public interface InventoryService {
    List<NotebookDto> findAll();
    boolean create(NotebookDto item);
    boolean update(NotebookDto item);
}
