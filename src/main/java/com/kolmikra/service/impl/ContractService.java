package com.kolmikra.service.impl;

import com.kolmikra.entity.Contract;
import com.kolmikra.entity.factory.impl.ContractFactory;
import com.kolmikra.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService extends AbstractService<Contract, ContractFactory, ContractRepository> {

    @Autowired
    ContractRepository contractRepository;
}
