package com.project.votepopularpet.pet.entity;

import com.project.votepopularpet.pet.entity.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Like extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LIKE_ID")
    private Long likeId;

    @Column(name="PET_ID")
    private Long petId;

    @Column(name="Status")
    private Boolean Status;

}
