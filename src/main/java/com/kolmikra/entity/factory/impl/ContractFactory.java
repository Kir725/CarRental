package com.kolmikra.entity.factory.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.Contract;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.entity.factory.EntityFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.entityDao.Reference;
import com.kolmikra.entityDao.ReverseReference;
import com.kolmikra.entityDao.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
        contract.setRentalTime(commonEntityDao.getRentalTime());
        contract.setRentalCost(commonEntityDao.getRentalCost());
        contract.setVehicleId(commonEntityDao.getVehicleIssuedId());
        contract.setClientId(commonEntityDao.getClientId());
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
                    new Value(commonEntityDao, rentalTimeNumb, ((Contract) abstractEntity).getRentalTime()),
                    new Value(commonEntityDao, rentalCostNumb, ((Contract) abstractEntity).getRentalCost())
            );
            commonEntityDao.setValues(newValues);

            commonEntityDao.setReferences(
                    new ArrayList<>(Collections.singletonList(
                            new Reference(commonEntityDao, ((Contract) abstractEntity).getVehicleId(), carIssuedNumb))));

            commonEntityDao.setReverseReferences(new ArrayList<>(Collections.singletonList(
                    new ReverseReference(((Contract) abstractEntity).getClientId(), commonEntityDao, contractSignedNumb))));

            return commonEntityDao;
        }
        throw new ClassCastException();
    }
}
