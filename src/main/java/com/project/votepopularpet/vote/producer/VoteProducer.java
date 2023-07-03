package com.project.votepopularpet.vote.producer;

import com.project.votepopularpet.pet.dto.ScheduleEventDto;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * null.java
 *
 * @author suna.park
 * @createdDate 2023-07-03.
 */
@Component
@RequiredArgsConstructor
public class VoteProducer {
  private final RabbitTemplate rabbitTemplate;

  private static final String EXCHANGE = "hello.exchange";
  private static final String SCHEDULE_ROUTING_KEY = "hello.key";

  public void produceVote(Long senderId, Long receiverId, Supplier<String> messageSupplier) {
    rabbitTemplate.convertAndSend(EXCHANGE, SCHEDULE_ROUTING_KEY,  ScheduleEventDto.builder()
        .senderId(senderId)
        .receiverId(receiverId)
        .feedMessage(messageSupplier.get())
        .build()
    );
  }
}
