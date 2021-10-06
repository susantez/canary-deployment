package com.dfx.advanced.deployment.rest;

import com.dfx.advanced.deployment.service.model.NotebookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping(value = "/inventory/v1")
public interface NotebookController {

    @GetMapping(value = "/notebook/all")
    ResponseEntity<List<NotebookDto>> findAll();


    @PostMapping(value = "/notebook/create")
    ResponseEntity<Boolean> createBook(@Valid @RequestBody NotebookDto book);

}
