package com.dfx.advanced.deployment.service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class NotebookDto {

    private long id;
    private String system;
    private String manufacturer;
    private String model;
    private Date creationDate;
}
