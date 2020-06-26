package com.kolmikra.repository;

import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.entityDao.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.kolmikra.attribute.AttributeTitle.*;


@Repository
public interface UserRepository extends CommonRepository<CommonEntityDao>{

    @Query(value = "SELECT e FROM CommonEntityDao e where e.id IN (SELECT v.object_id FROM Value v WHERE v.varcharValue =:email AND v.attribute_id = 17)")
    Optional<CommonEntityDao> findByEmail(@Param("email") String email);
}
