package com.kolmikra.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    protected int id;

    //public abstract <ED extends AbstractEntityDao> ED getDaoEntity();
}
