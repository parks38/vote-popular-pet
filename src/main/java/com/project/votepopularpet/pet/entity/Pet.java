package com.project.votepopularpet.pet.entity;

import com.project.votepopularpet.pet.entity.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Pet
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@Data
@Entity
public class Pet extends BaseEntity {

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
