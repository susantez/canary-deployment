package com.dfx.advanced.deployment.rest;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Validated
@RequestMapping(value = "/api")
public interface DefaultController {

    @GetMapping(value = "/version")
    ResponseEntity<String> getVersion() throws Exception;

    @PostMapping(value = "/delay")
    ResponseEntity<Boolean> setDelay(@Valid @RequestBody Boolean state);

    @PostMapping(value = "/error")
    ResponseEntity<Boolean> setError(@Valid @RequestBody Boolean state);
}
