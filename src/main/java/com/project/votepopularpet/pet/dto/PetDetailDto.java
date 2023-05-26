package com.project.votepopularpet.pet.dto;

import lombok.Data;

/**
 * PetDetailDto
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@Data
public class PetDetailDto {

    private Long id;
    private String name;
    private String imageUrl;
    private String title;
    private String description;
    private int voteCount;
}
