package com.dfx.advanced.deployment.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping(value = "/api")
public interface DefaultController {

    @GetMapping(value = "/version")
    ResponseEntity<String> getVersion();
}
