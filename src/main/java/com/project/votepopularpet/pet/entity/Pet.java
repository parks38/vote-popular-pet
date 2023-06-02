package com.project.votepopularpet.pet.entity;

import com.project.votepopularpet.pet.entity.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * Pet
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Pet extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PET_ID")
    private Long petId;

    @Column(name="NAME")
    private String name;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    @Column(name="TITLE")
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="VOTE_COUNT")
    private int voteCount;
}
