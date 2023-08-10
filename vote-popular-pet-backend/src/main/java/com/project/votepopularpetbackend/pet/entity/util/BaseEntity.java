package com.project.votepopularpetbackend.pet.entity.util;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    @Column(name="CREATED_BY")
    private String createdBy;

    @CreationTimestamp
    @Column(name="CREATE_DATE_TIME")
    private LocalDateTime createDateTime;

    @Column(name="MODIFIED_BY")
    private String modifiedBy;

    @UpdateTimestamp
    @Column(name="MODIFIED_DATE_TIME")
    private LocalDateTime modifiedDateTime;
}