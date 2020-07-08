package com.kolmikra.entityDao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(ReferenceId.class)
@Table(name = "reference")
public class BackReference {

    @Id
    private int object_id;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference")
    private CommonEntityDao reference;
    @Id
    private int ref_type;

    public BackReference() {
    }

    @JsonIgnore
    public CommonEntityDao getReference() {
        return reference;
    }

    public BackReference(int object_id, CommonEntityDao reference, int ref_type) {
        this.object_id = object_id;
        this.reference = reference;
        this.ref_type = ref_type;
    }
}
