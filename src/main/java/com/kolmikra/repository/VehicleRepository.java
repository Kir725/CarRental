package com.kolmikra.repository;

import com.kolmikra.entityDao.CommonEntityDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface VehicleRepository extends CommonRepository<CommonEntityDao>{

    @Query(value="SELECT e FROM CommonEntityDao e WHERE e.type_id = 1 AND (e.id IN " +
            "(SELECT r.reference FROM Reference r WHERE r.ref_type = 31 AND r.object_id IN " +
            "(SELECT v.object_id FROM Value v WHERE (v.attribute_id = 24 AND v.dateValue > :dropOffDate) " +
            "OR v.attribute_id = 25 AND v.dateValue < :pickupDate )) OR e.id NOT IN " +
            "(SELECT r.reference FROM Reference r WHERE r.ref_type = 31))")
    List<CommonEntityDao> findNotInRent(@Param("pickupDate") Date pickupDate,
                                        @Param("dropOffDate") Date dropOffDate);
}
