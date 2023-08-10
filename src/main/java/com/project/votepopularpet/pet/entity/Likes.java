package com.project.votepopularpet.pet.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.votepopularpet.pet.entity.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity(name="Likes")
@RequiredArgsConstructor
public class Likes extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LIKE_ID")
    private Long likeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PET_ID")
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class) // like list jsonMappingException 위해 제거
    private Pet pet;

    @Column(name="Status")
    private Boolean status;

    @Column(name = "USER_ID")
    private String userId;
}
