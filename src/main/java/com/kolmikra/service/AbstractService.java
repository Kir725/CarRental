package com.kolmikra.service;

import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.entityDao.VehicleDao;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.entityDao.AbstractEntityDao;
import com.kolmikra.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractService<ED extends AbstractEntityDao, E extends AbstractEntity,
        R extends CommonRepository<ED>> implements CommonService<E> {

    @Autowired
    R repository;

    @Override
    public E findById(int id) throws NoSuchItemException {
        ED entityDao = repository.findById(id).orElseThrow(NoSuchItemException::new);
        return entityDao.getRealEntity();
    }

    @Override
    public void deleteById(int id) throws NoSuchItemException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NoSuchItemException();
        }
    }

    @Override
    public void create(E entity) {
        repository.save(entity.getDaoEntity());
    }

    @Override
    public E updateById(int id, E entity) throws NoSuchItemException {
        if (repository.existsById(id)) {
            ED updated = entity.getDaoEntity();
            updated.setId(id);
            repository.save(updated);
            entity.setId(id);
            return entity;
        }
        throw new NoSuchItemException();
    }

}

