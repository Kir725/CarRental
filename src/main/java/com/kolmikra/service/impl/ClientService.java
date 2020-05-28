package com.kolmikra.service.impl;

import com.kolmikra.entity.CommonClient;
import com.kolmikra.entity.factory.impl.ClientFactory;
import com.kolmikra.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractService<CommonClient, ClientFactory, ClientRepository> {

    @Autowired
    ClientRepository clientRepository;

}
