package com.derby.test.task.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "ttable")
public class DataModel implements Serializable {
    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="VALUE")
    private String value;
}
