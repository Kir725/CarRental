package com.kolmikra.service.impl;

import com.kolmikra.entity.User;
import com.kolmikra.entity.factory.impl.ContractFactory;
import com.kolmikra.entity.factory.impl.UserFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.repository.ContractRepository;
import com.kolmikra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserFactory, UserRepository> {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserFactory userFactory) {
        super(userRepository, userFactory);
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) throws NoSuchItemException {
        CommonEntityDao entityDao = userRepository.findByEmail(email).orElseThrow(NoSuchItemException::new);
        return (User) entityFactory.getRealEntity(entityDao);
    }

    public User updateClientForUser(int userId, int clientId) throws NoSuchItemException {
        userRepository.updateClientForUser(userId, clientId);
        CommonEntityDao entityDao = userRepository.findById(userId).orElseThrow(NoSuchItemException::new);
        return (User) entityFactory.getRealEntity(entityDao);
    }
}
