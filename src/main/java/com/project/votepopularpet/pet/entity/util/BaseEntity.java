package com.project.votepopularpet.pet.entity.util;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * null.java
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    private String createdBy;

    private LocalDateTime createDate;

    private String lastModifiedBy;

    private LocalDateTime lastModifedDate;
}