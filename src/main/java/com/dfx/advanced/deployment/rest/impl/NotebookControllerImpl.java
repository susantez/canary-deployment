package com.dfx.advanced.deployment.rest.impl;

import com.dfx.advanced.deployment.rest.NotebookController;
import com.dfx.advanced.deployment.service.InventoryService;
import com.dfx.advanced.deployment.service.model.NotebookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NotebookControllerImpl implements NotebookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotebookControllerImpl.class);

    private InventoryService service;

    @Autowired
    public NotebookControllerImpl(InventoryService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<NotebookDto>> findAll() {
        List<NotebookDto> response = service.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> createBook(@Valid NotebookDto item) {
        boolean response = service.create(item);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
