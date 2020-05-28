package com.kolmikra.repository;

import com.kolmikra.entityDao.CommonEntityDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonRepository<E extends CommonEntityDao> extends JpaRepository<E, Integer> {

    @Query(value = "SELECT e FROM CommonEntityDao e WHERE e.type_id = :typeId")
    List<E> findAll(@Param("typeId") int typeId);
}
