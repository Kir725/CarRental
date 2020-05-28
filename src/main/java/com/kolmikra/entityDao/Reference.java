package com.kolmikra.entityDao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ReferenceId.class)
@Table(name = "reference")
public class Reference {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "object_id")
    private CommonEntityDao object_id;
    @Id
    private int reference;
    @Id
    private int ref_type;

    @JsonIgnore
    public CommonEntityDao getObject_id() {
        return object_id;
    }

    public Reference() {
    }

    public Reference(CommonEntityDao object_id, int reference, int ref_type) {
        this.object_id = object_id;
        this.reference = reference;
        this.ref_type = ref_type;
    }
}
