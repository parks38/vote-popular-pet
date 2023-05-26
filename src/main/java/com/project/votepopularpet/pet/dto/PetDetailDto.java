package com.project.votepopularpet.pet.dto;

import com.project.votepopularpet.pet.entity.Pet;
import com.project.votepopularpet.pet.entity.util.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * PetDetailDto
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class PetDetailDto {

    private Long petId;
    private String name;
    private String imageUrl;
    private String title;
    private String description;
    private int voteCount;

    public static PetDetailDto of(Pet pet) {
//        this.petId = pet.getPetId();
//        this.name = pet.getName();
//        this.imageUrl = pet.getImageUrl();
//        this.title = pet.getTitle();
//        this.description = pet.getDescription();
//        this.voteCount = pet.getVoteCount();
        return PetDetailDto.builder()
                .petId(pet.getPetId())
                .name(pet.getName())
                .imageUrl(pet.getImageUrl())
                .title(pet.getTitle())
                .description(pet.getDescription())
                .voteCount(pet.getVoteCount())
                .build();
    }
}
