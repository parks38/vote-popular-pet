package com.project.votepopularpet.vote.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.votepopularpet.pet.entity.Likes;
import com.project.votepopularpet.pet.entity.Pet;
import com.project.votepopularpet.pet.repository.PetRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

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

  @Autowired
  ObjectMapper objectMapper;
  @Autowired
  private PetRepository petRepository;

  @Test
  @Transactional
  void setVoteProducer() {

    Optional<Pet> pet = petRepository.findById(13L);

    pet.ifPresent(p -> {

      p.setLikeList(new ArrayList<>());
      Likes like = new Likes();
      like.setStatus(true);
      like.setPet(p);
      like.setUserId("suna.park");

      try {
        voteProducer.produceVote(like);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    });
  }
}