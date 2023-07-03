package com.project.votepopularpet.pet.dto;

import lombok.Builder;

/**
 * null.java
 *
 * @author suna.park
 * @createdDate 2023-07-03.
 */
@Builder
public record ScheduleEventDto (
    long senderId,
    long receiverId,
    String feedMessage
) {
}
