package com.dfx.advanced.deployment.rest.impl;

import com.dfx.advanced.deployment.rest.DefaultController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultControllerImpl implements DefaultController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultControllerImpl.class);

    @Value("${app.version}")
    private String appVersion;

    @Override
    public ResponseEntity<String> getVersion() {
        return new ResponseEntity<>(appVersion, HttpStatus.OK);
    }
}
