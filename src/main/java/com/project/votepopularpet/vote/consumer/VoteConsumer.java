package com.project.votepopularpet.vote.consumer;

import com.project.votepopularpet.pet.dto.ScheduleEventDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * VoteConsumer.java
 *
 * @author suna.park
 * @createdDate 2023-07-03.
 */
@Component
@RequiredArgsConstructor
public class VoteConsumer {

  private static final String SCHEDULE_QUEUE = "hello.queue";

  @RabbitListener(queues = SCHEDULE_QUEUE)
  public void consume(ScheduleEventDto scheduleEventDto) {
    System.out.println("!!!!" + scheduleEventDto.feedMessage());
  }
}
