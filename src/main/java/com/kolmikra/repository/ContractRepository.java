package com.kolmikra.repository;

import com.kolmikra.entityDao.CommonEntityDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends CommonRepository<CommonEntityDao> {

    @Query(value = "SELECT e FROM CommonEntityDao e WHERE e.type_id = 3 AND e.id IN " +
            "(SELECT r.reference FROM Reference r WHERE r.ref_type = 30 AND r.object_id.id = :clientId)")
    List<CommonEntityDao> getContractsByClientId(@Param("clientId") int clientId);

}
