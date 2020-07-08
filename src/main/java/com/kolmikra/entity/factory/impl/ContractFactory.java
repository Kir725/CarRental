package com.kolmikra.entity.factory.impl;

import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.Contract;
import com.kolmikra.entity.factory.EntityFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.entityDao.Reference;
import com.kolmikra.entityDao.BackReference;
import com.kolmikra.entityDao.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kolmikra.attribute.AttributeTitle.*;

@Service
public class ContractFactory implements EntityFactory {

    @Override
    public AbstractEntity getRealEntity(CommonEntityDao commonEntityDao) {
        Contract contract = new Contract();
        contract.setId(commonEntityDao.getId());
        contract.setStartDate(commonEntityDao.getStartDate());
        contract.setDropOffDate(commonEntityDao.getDropOffDate());
        contract.setRentalCost(commonEntityDao.getRentalCost());
        contract.setVehicleId(commonEntityDao.getVehicleIssuedId());
        contract.setClientId(commonEntityDao.getClientIdForContract());
        return contract;
    }

    @Override
    public CommonEntityDao getDaoEntity(AbstractEntity abstractEntity) {
        if (abstractEntity instanceof Contract) {
            CommonEntityDao commonEntityDao = new CommonEntityDao();
            commonEntityDao.setType_id(3);
            List<Value> newValues = new ArrayList<>();
            Collections.addAll(newValues,
                    new Value(commonEntityDao, startDateNumb, ((Contract) abstractEntity).getStartDate()),
                    new Value(commonEntityDao, dropOffDateNumb, ((Contract) abstractEntity).getDropOffDate()),
                    new Value(commonEntityDao, rentalCostNumb, ((Contract) abstractEntity).getRentalCost())
            );
            commonEntityDao.setValues(newValues);

            commonEntityDao.setReferences(
                    new ArrayList<>(Collections.singletonList(
                            new Reference(commonEntityDao, ((Contract) abstractEntity).getVehicleId(), carIssuedNumb))));

            commonEntityDao.setBackReferences(new ArrayList<>(Collections.singletonList(
                    new BackReference(((Contract) abstractEntity).getClientId(), commonEntityDao, contractSignedNumb))));

            return commonEntityDao;
        }
        throw new ClassCastException();
    }
}
