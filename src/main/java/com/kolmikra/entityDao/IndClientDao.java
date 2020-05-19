package com.kolmikra.entityDao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kolmikra.entity.AbstractEntity;
import com.kolmikra.entity.IndClient;
import com.kolmikra.entity.Vehicle;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "object")
public class IndClientDao extends CommonClientDao {

    @Override
    @JsonIgnore
    public IndClient getRealEntity() {
        return new IndClient(this);
    }

    public String getSecondName(){
        return this.getValue(13).getVarcharValue();
    }

    public String getMiddleName(){
        return this.getValue(14).getVarcharValue();
    }

    public Integer getDrivingExperience(){
        return this.getValue(18).getIntegerValue();
    }

    public Integer getPassportSeries(){
        return this.getValue(21).getIntegerValue();
    }

    public Integer getPassportId(){
        return this.getValue(22).getIntegerValue();
    }

    public Date getBirthDate(){
        return this.getValue(23).getDateValue();
    }

    public IndClientDao(IndClient client) {

        this.setType_id(2);

        List<Value<AbstractEntityDao>> newValues = new ArrayList<>();
        Collections.addAll(newValues,
                new Value<>(this,12,client.getName()),
                new Value<>(this,13,client.getSecondName()),
                new Value<>(this,14,client.getMiddleName()),
                new Value<>(this,15,client.getType()),
                new Value<>(this,16,client.getPhone()),
                new Value<>(this,17,client.getEmail()),
                new Value<>(this,18,client.getDrivingExperience()),
                new Value<>(this,21,client.getPassportSeries()),
                new Value<>(this,22,client.getPassportId()),
                new Value<>(this,23,client.getBirthDate())
            );


        this.setValues(newValues);
    }
}
