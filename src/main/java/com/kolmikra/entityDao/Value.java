package com.kolmikra.entityDao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@IdClass(ValueId.class)
@Table(name = "value")
public class Value {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "object_id")
    private CommonEntityDao object_id;

    @Id
    @Column(name = "attribute_id")
    private int attribute_id;

    @Column(name = "integer_value")
    private Integer integerValue;

    @Column(name = "decimal_value")
    private Double decimalValue;

    @Column(name = "date_value")
    private Date dateValue;

    @Column(name = "varchar_value")
    private String varcharValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    public Value() {
    }

    public Value(CommonEntityDao object_id, int attribute_id, Integer integerValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.integerValue = integerValue;
    }

    public Value(CommonEntityDao object_id, int attribute_id, Double decimalValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.decimalValue = decimalValue;
    }

    public Value(CommonEntityDao object_id, int attribute_id, Date dateValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.dateValue = dateValue;
    }

    public Value(CommonEntityDao object_id, int attribute_id, String varcharValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.varcharValue = varcharValue;
    }

    public Value(CommonEntityDao object_id, int attribute_id, Boolean booleanValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.booleanValue = booleanValue;
    }

    @JsonIgnore
    public CommonEntityDao getObject_id() {
        return object_id;
    }
}
