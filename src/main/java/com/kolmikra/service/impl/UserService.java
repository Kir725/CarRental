package com.kolmikra.service.impl;

import com.kolmikra.entity.User;
import com.kolmikra.entity.factory.impl.UserFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserFactory, UserRepository> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserFactory userFactory;

    public User findByEmail(String email) throws NoSuchItemException {
        CommonEntityDao entityDao = userRepository.findByEmail(email).orElseThrow(NoSuchItemException::new);
        return (User)userFactory.getRealEntity(entityDao);
    }
}
