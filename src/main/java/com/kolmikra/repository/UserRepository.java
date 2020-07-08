package com.kolmikra.repository;

import com.kolmikra.entityDao.CommonEntityDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
public interface UserRepository extends CommonRepository<CommonEntityDao> {

    @Query(value = "SELECT e FROM CommonEntityDao e where e.type_id = 5 AND e.id IN (SELECT v.object_id FROM Value v WHERE v.varcharValue =:email AND v.attribute_id = 17)")
    Optional<CommonEntityDao> findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reference VALUES (:userId,:clientId,34)", nativeQuery = true)
    void updateClientForUser(@Param("userId") int userId, @Param("clientId") int clientId);
}
