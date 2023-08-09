package com.project.votepopularpet.vote.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.votepopularpet.pet.entity.Likes;
import com.project.votepopularpet.vote.service.VoteService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Transactional
public class VoteConsumer {

  private static final String SCHEDULE_QUEUE = "hello.queue";
  private static final Logger log = LoggerFactory.getLogger(VoteConsumer.class);
  private final VoteService voteService;
  private final ObjectMapper objectMapper;

  @RabbitListener(queues = SCHEDULE_QUEUE)
  public void consume(String message) throws JsonProcessingException {
    Likes like = objectMapper.readValue(message, Likes.class);
    voteService.saveLikeVotes(like);
    log.info("---------- scheduledEventDto.feedMessage(): " + like.getUserId());
  }
}
