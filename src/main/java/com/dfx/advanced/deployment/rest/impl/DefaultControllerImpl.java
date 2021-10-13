package com.dfx.advanced.deployment.rest.impl;

import com.dfx.advanced.deployment.rest.DefaultController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DefaultControllerImpl implements DefaultController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultControllerImpl.class);

    @Value("${app.version}")
    private String appVersion;
    private static boolean SLOW_RESPONSE = false;
    private static boolean RANDOM_EXCEPTIONS = false;

    @Override
    public ResponseEntity<String> getVersion() throws Exception {
        HttpStatus status = HttpStatus.OK;
        if (SLOW_RESPONSE) {
            int rand = (int)(Math.random() * 10);
            try {
                Thread.sleep(rand * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (RANDOM_EXCEPTIONS) {
            int rand = (int)(Math.random() * 10);
            if (rand > 5) {
                status = HttpStatus.BAD_REQUEST;
            }
            if (rand > 8) {
                throw new Exception("Custom Exception");
            }
        }
        return new ResponseEntity<>(appVersion, status);
    }

    @Override
    public ResponseEntity<Boolean> setDelay(@Valid Boolean state) {
        this.SLOW_RESPONSE = state;
        return new ResponseEntity<>(this.SLOW_RESPONSE, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> setError(@Valid Boolean state) {
        this.RANDOM_EXCEPTIONS = state;
        return new ResponseEntity<>(this.RANDOM_EXCEPTIONS, HttpStatus.OK);
    }
}
