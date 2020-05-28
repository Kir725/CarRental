package com.kolmikra.entity.factory;

import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entityDao.CommonEntityDao;
import org.springframework.stereotype.Service;

@Service
public interface EntityFactory {
    <E extends AbstractEntity> E getRealEntity(CommonEntityDao commonEntityDao);
    <E extends CommonEntityDao> E getDaoEntity(AbstractEntity abstractEntity);
}
