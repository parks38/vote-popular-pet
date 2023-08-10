package com.project.votepopularpetbackend.pet.entity;

import com.project.votepopularpetbackend.pet.entity.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Pet
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="pets")
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
    private Integer voteCount;

    @OneToMany(mappedBy = "pet")
    private List<Likes> likeList;
}
