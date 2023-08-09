package com.project.votepopularpet.pet.dto;

import lombok.Builder;
import lombok.Data;

/**
 * null.java
 *
 * @author suna.park
 * @createdDate 2023-07-03.
 */
@Builder
@Data
public class ScheduleEventDto {
  String senderId;
  long receiverId;
  Boolean status;
}
