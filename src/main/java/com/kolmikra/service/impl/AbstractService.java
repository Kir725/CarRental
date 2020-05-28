package com.kolmikra.service.impl;

import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.factory.EntityFactory;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.repository.CommonRepository;
import com.kolmikra.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractService<E extends AbstractEntity, F extends EntityFactory,
        R extends CommonRepository<CommonEntityDao>> implements CommonService<E> {

    @Autowired
    R repository;

    @Autowired
    F entityFactory;

    @Override
    public E findById(int id) throws NoSuchItemException {
        CommonEntityDao entityDao = repository.findById(id).orElseThrow(NoSuchItemException::new);
        return entityFactory.getRealEntity(entityDao);
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
        repository.save(entityFactory.getDaoEntity(entity));
    }

    @Override
    public E updateById(int id, E entity) throws NoSuchItemException {
        if (repository.existsById(id)) {
            CommonEntityDao updated = entityFactory.getDaoEntity(entity);
            updated.setId(id);
            repository.save(updated);
            entity.setId(id);
            return entity;
        }
        throw new NoSuchItemException();
    }

    @Override
    public List<E> findAll(int typeId) {
        List<CommonEntityDao> entityDaoList = repository.findAll(typeId);
        List<E> result = new ArrayList<>();
        entityDaoList.forEach(e -> {
            result.add(entityFactory.getRealEntity(e));
        });
        return result;
     }
}

