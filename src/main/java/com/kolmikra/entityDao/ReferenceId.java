package com.kolmikra.entityDao;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReferenceId implements Serializable {
    private int object_id;
    private int reference;
    private int ref_type;
}
