package com.kolmikra.entityDao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class CommonClientDao extends AbstractEntityDao{

    public String getName(){
        return this.getValue(12).getVarcharValue();
    }

    public String getType(){
        return this.getValue(15).getVarcharValue();
    }

    public Double getPhone(){
        return this.getValue(16).getDecimalValue();
    }

    public String getEmail(){
        return this.getValue(17).getVarcharValue();
    }

}
