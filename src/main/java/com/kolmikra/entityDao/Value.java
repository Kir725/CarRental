package com.kolmikra.entityDao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.Vehicle;
import lombok.Data;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@IdClass(ValueId.class)
@Table(name = "value")
public class Value <E extends AbstractEntityDao> {

    @Id
    @ManyToOne(targetEntity = VehicleDao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "object_id")
    private E object_id;

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

    public Value(E object_id, int attribute_id, Integer integerValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.integerValue = integerValue;
    }

    public Value(E object_id, int attribute_id, Double decimalValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.decimalValue = decimalValue;
    }

    public Value(E object_id, int attribute_id, Date dateValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.dateValue = dateValue;
    }

    public Value(E object_id, int attribute_id, String varcharValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.varcharValue = varcharValue;
    }

    public Value(E object_id, int attribute_id, Boolean booleanValue) {
        this.object_id = object_id;
        this.attribute_id = attribute_id;
        this.booleanValue = booleanValue;
    }

//    @JsonIgnore
//    public VehicleDao getObject_id() {
//        return object_id;
//    }
}
