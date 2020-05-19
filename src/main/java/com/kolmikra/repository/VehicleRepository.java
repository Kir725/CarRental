package com.kolmikra.repository;

import com.kolmikra.entityDao.VehicleDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CommonRepository<VehicleDao>{

    @Override
    @Query(value = "SELECT v FROM VehicleDao v WHERE v.type_id = 1 ")
    List<VehicleDao> findAll();
}
