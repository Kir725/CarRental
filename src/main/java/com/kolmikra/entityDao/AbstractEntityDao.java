package com.kolmikra.entityDao;

import com.kolmikra.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Data
@MappedSuperclass
public abstract class AbstractEntityDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private int id;

    @OneToMany(mappedBy = "object_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Value<AbstractEntityDao>> values;

    @Column(name="type_id")
    private Integer type_id;

    protected Value<AbstractEntityDao> getValue(int attrId){
        return this.getValues().stream().filter(v -> v.getAttribute_id() == attrId).findFirst().get();
    }

    public abstract <E extends AbstractEntity> E getRealEntity();
}
