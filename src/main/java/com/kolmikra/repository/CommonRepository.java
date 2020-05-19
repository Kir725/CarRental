package com.kolmikra.repository;

import com.kolmikra.entityDao.AbstractEntityDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends AbstractEntityDao> extends JpaRepository<E, Integer> {
}
