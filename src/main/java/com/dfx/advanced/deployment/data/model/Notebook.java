package com.dfx.advanced.deployment.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String system;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String model;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date creationDate;

    @PrePersist
    void onPrePersist() {
        this.setCreationDate(new Date());
    }

}
