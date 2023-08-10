package com.project.votepopularpet.pet.dto;

import com.project.votepopularpet.pet.entity.Pet;
import lombok.*;

/**
 * PetDetailDto
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetDetailDto {

    private Long petId;
    private String name;
    private String imageUrl;
    private String title;
    private String description;
    private int voteCount;

    public static PetDetailDto of(Pet pet) {
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
