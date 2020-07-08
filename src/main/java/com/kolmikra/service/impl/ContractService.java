package com.kolmikra.service.impl;

import com.kolmikra.entity.Contract;
import com.kolmikra.entity.factory.impl.ClientFactory;
import com.kolmikra.entity.factory.impl.ContractFactory;
import com.kolmikra.entityDao.CommonEntityDao;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.repository.ClientRepository;
import com.kolmikra.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService extends AbstractService<Contract, ContractFactory, ContractRepository> {


    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository, ContractFactory contractFactory) {
        super(contractRepository, contractFactory);
        this.contractRepository = contractRepository;
    }

    public List<Contract> getContractsByClient(int clientId) throws NoSuchItemException {
        List<CommonEntityDao> entityDaoList = contractRepository.getContractsByClientId(clientId);
        if (entityDaoList.size() != 0) {
            List<Contract> result = new ArrayList<>();
            entityDaoList.forEach(e -> {
                result.add((Contract) entityFactory.getRealEntity(e));
            });
            return result;
        }
        throw new NoSuchItemException();
    }
}
