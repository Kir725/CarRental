package com.kolmikra.entityDao;

import lombok.Data;

import java.io.Serializable;

@Data
public class ValueId implements Serializable {

    private int object_id;

    private int attribute_id;
}
