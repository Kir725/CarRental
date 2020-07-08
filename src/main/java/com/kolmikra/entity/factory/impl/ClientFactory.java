package com.kolmikra.entity.factory.impl;

import com.kolmikra.entity.*;
import com.kolmikra.entity.factory.EntityFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.entityDao.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kolmikra.attribute.AttributeTitle.*;

@Service
public class ClientFactory implements EntityFactory {
    @Override
    public CommonClient getRealEntity(CommonEntityDao commonEntityDao) {
        if ("физ".equals(commonEntityDao.getClientType())) {
            IndClient indClient = new IndClient();
            indClient.setId(commonEntityDao.getId());
            indClient.setName(commonEntityDao.getName());
            indClient.setSecondName(commonEntityDao.getSecondName());
            indClient.setMiddleName(commonEntityDao.getMiddleName());
            indClient.setClientType(commonEntityDao.getClientType());
            indClient.setPhone(commonEntityDao.getPhone());
            indClient.setEmail(commonEntityDao.getEmail());
            indClient.setDrivingExperience(commonEntityDao.getDrivingExperience());
            indClient.setPassportSeries(commonEntityDao.getPassportSeries());
            indClient.setPassportId(commonEntityDao.getPassportId());
            indClient.setBirthDate(commonEntityDao.getBirthDate());
            if (commonEntityDao.getContractId().size() != 0) {
                indClient.setContractsId(commonEntityDao.getContractId());
            }
            return indClient;
        }
        LegalClient legalClient = new LegalClient();
        legalClient.setId(commonEntityDao.getId());
        legalClient.setName(commonEntityDao.getName());
        legalClient.setClientType(commonEntityDao.getClientType());
        legalClient.setPhone(commonEntityDao.getPhone());
        legalClient.setEmail(commonEntityDao.getEmail());
        legalClient.setAgent(commonEntityDao.getAgent());
        legalClient.setOrganizationCode(commonEntityDao.getOrganizationCode());
        if (commonEntityDao.getContractId().size() != 0) {
            legalClient.setContractsId(commonEntityDao.getContractId());
        }
        return legalClient;
    }

    @Override
    public CommonEntityDao getDaoEntity(AbstractEntity abstractEntity) {
        if (abstractEntity instanceof CommonClient) {
            CommonEntityDao commonEntityDao = new CommonEntityDao();
            commonEntityDao.setType_id(2);
            List<Value> newValues = new ArrayList<>();
            if ("физ".equals((((CommonClient) abstractEntity).getClientType()))) {
                Collections.addAll(newValues,
                        new Value(commonEntityDao, nameNumb, ((IndClient) abstractEntity).getName()),
                        new Value(commonEntityDao, secondNameNumb, ((IndClient) abstractEntity).getSecondName()),
                        new Value(commonEntityDao, middleNameNumb, ((IndClient) abstractEntity).getMiddleName()),
                        new Value(commonEntityDao, clientTypeNumb, ((IndClient) abstractEntity).getClientType()),
                        new Value(commonEntityDao, phoneNumb, ((IndClient) abstractEntity).getPhone()),
                        new Value(commonEntityDao, emailNumb, ((IndClient) abstractEntity).getEmail()),
                        new Value(commonEntityDao, drivingExperienceNumb, ((IndClient) abstractEntity).getDrivingExperience()),
                        new Value(commonEntityDao, passportSeriesNumb, ((IndClient) abstractEntity).getPassportSeries()),
                        new Value(commonEntityDao, passportIdNumb, ((IndClient) abstractEntity).getPassportId()),
                        new Value(commonEntityDao, birthDateNumb, ((IndClient) abstractEntity).getBirthDate()));

                commonEntityDao.setValues(newValues);
                return commonEntityDao;
            }
            Collections.addAll(newValues,
                    new Value(commonEntityDao, nameNumb, ((LegalClient) abstractEntity).getName()),
                    new Value(commonEntityDao, phoneNumb, ((LegalClient) abstractEntity).getPhone()),
                    new Value(commonEntityDao, emailNumb, ((LegalClient) abstractEntity).getEmail()),
                    new Value(commonEntityDao, clientTypeNumb, ((LegalClient) abstractEntity).getClientType()),
                    new Value(commonEntityDao, agentNumb, ((LegalClient) abstractEntity).getAgent()),
                    new Value(commonEntityDao, organizationCodeNumb, ((LegalClient) abstractEntity).getOrganizationCode()));

            commonEntityDao.setValues(newValues);
            return commonEntityDao;
        }
        throw new ClassCastException();
    }
}
