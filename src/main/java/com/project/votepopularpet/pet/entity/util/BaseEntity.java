package com.project.votepopularpet.pet.entity.util;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * BaseEntity.java
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    private String createdBy;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    private String modifiedBy;

    @UpdateTimestamp
    private LocalDateTime modifedDateTime;
}