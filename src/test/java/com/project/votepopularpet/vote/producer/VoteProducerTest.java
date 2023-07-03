package com.project.votepopularpet.vote.producer;

import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * JUnit5 Test Class.java.java
 *
 * @author suna.park
 * @createdDate 2023-07-03.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class VoteProducerTest {

  @Autowired
  VoteProducer voteProducer;

  @Test
  void setVoteProducer() {

    voteProducer.produceVote(1L, 2L, () ->
      MessageFormat.format("helllpo", "2019-01-01"));
  }
}