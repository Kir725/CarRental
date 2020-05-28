package com.kolmikra.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LegalClient extends CommonClient{

    private String agent;

    private Integer organizationCode;

//    @Override
//    @JsonIgnore
//    public LegalClientDao getDaoEntity() {
//        return new LegalClientDao(this);
//    }
//
//    public LegalClient(LegalClientDao clientDao) {
//        this.id = clientDao.getId();
//        this.name = clientDao.getName();
//        this.type = clientDao.getType();
//        this.phone = clientDao.getPhone();
//        this.email = clientDao.getEmail();
//        this.agent = clientDao.getAgent();
//        this.organizationCode = clientDao.getOrganizationCode();
//    }
}
