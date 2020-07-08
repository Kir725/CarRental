package com.kolmikra.entity.factory.impl;

import com.kolmikra.entity.*;
import com.kolmikra.entity.factory.EntityFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.entityDao.Reference;
import com.kolmikra.entityDao.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kolmikra.attribute.AttributeTitle.*;

@Service
public class UserFactory implements EntityFactory {

    @Override
    public AbstractEntity getRealEntity(CommonEntityDao commonEntityDao) {
        User user = new User();
        user.setId(commonEntityDao.getId());
        user.setEmail(commonEntityDao.getEmail());
        user.setPassword(commonEntityDao.getPassword());
        user.setUserType(commonEntityDao.getUserType());
        if (commonEntityDao.getClientIdForUser().isPresent()) {
            user.setClientId(commonEntityDao.getClientIdForUser().get());
        }
        return user;
    }

    @Override
    public CommonEntityDao getDaoEntity(AbstractEntity abstractEntity) {
        if (abstractEntity instanceof User) {
            CommonEntityDao commonEntityDao = new CommonEntityDao();
            commonEntityDao.setType_id(5);
            List<Value> newValues = new ArrayList<>();
            Collections.addAll(newValues,
                    new Value(commonEntityDao, emailNumb, ((User) abstractEntity).getEmail()),
                    new Value(commonEntityDao, passwordNumb, ((User) abstractEntity).getPassword()),
                    new Value(commonEntityDao, userTypeNumb, ((User) abstractEntity).getUserType()));

            commonEntityDao.setValues(newValues);

            if (((User) abstractEntity).getClientId() != null) {
                commonEntityDao.setReferences(
                        new ArrayList<>(Collections.singletonList(
                                new Reference(commonEntityDao, ((User) abstractEntity).getClientId(), beClientNumb))));
            }
            return commonEntityDao;


        }
        throw new ClassCastException();
    }
}
