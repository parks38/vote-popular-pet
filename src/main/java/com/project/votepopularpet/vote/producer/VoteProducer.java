package com.project.votepopularpet.vote.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.votepopularpet.pet.entity.Likes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * VoteProducer.java
 *
 * @author suna.park
 * @createdDate 2023-07-03.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class VoteProducer {
  private final RabbitTemplate rabbitTemplate;
  private final ObjectMapper objectMapper;

  private static final String EXCHANGE = "hello.exchange";
  private static final String SCHEDULE_ROUTING_KEY = "hello.key";

  /**
   *
   * @param like
   * @throws JsonProcessingException
   */
  public void produceVote(Likes like) throws JsonProcessingException {

    rabbitTemplate.convertAndSend(EXCHANGE, SCHEDULE_ROUTING_KEY, objectMapper.writeValueAsString(like));
    log.info("---------- RabbitMQ produces message: " + like.getUserId() + " likes " + like.getPet().getPetId());
  }
}
