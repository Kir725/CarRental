package com.kolmikra.service;

import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.exception.NoSuchItemException;

import java.util.List;

public interface CommonService<E extends AbstractEntity> {

    E findById(int id) throws NoSuchItemException;

    void deleteById(int id) throws NoSuchItemException;

    E create(E entity);

    E updateById(int id, E entity) throws NoSuchItemException;

    List<E> findAll(int typeId);

}
