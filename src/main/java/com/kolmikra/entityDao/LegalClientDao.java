package com.kolmikra.entityDao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.IndClient;
import com.kolmikra.entity.LegalClient;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "object")
public class LegalClientDao extends CommonClientDao {

    @Override
    @JsonIgnore
    public LegalClient getRealEntity() {
        return new LegalClient(this);
    }

    public String getAgent(){
        return this.getValue(19).getVarcharValue();
    }

    public Integer getOrganizationCode(){
        return this.getValue(20).getIntegerValue();
    }

    public LegalClientDao(LegalClient client) {

        this.setType_id(2);

        List<Value<AbstractEntityDao>> newValues = new ArrayList<>();
        Collections.addAll(newValues,
                new Value<>(this,12,client.getName()),
                new Value<>(this,15,client.getType()),
                new Value<>(this,16,client.getPhone()),
                new Value<>(this,17,client.getEmail()),
                new Value<>(this,19,client.getAgent()),
                new Value<>(this,20,client.getOrganizationCode())
        );

        this.setValues(newValues);
    }
}
