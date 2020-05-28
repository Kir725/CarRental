package com.kolmikra.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IndClient.class, name = "физ"),
        @JsonSubTypes.Type(value = LegalClient.class, name = "юр")
})
public abstract class CommonClient extends AbstractEntity {

    protected String name;

    protected String clientType;

    protected Double phone;

    protected String email;

    protected List<Integer> contractsId;
}
