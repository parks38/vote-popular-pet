package com.project.votepopularpet.vote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.votepopularpet.common.exception.EntityNotFoundException;
import com.project.votepopularpet.pet.entity.Likes;
import com.project.votepopularpet.pet.entity.Pet;
import com.project.votepopularpet.pet.repository.LikeRepository;
import com.project.votepopularpet.pet.repository.PetRepository;
import com.project.votepopularpet.vote.producer.VoteProducer;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * VoteService.java
 *
 * @author suna.park
 * @createdDate 2023-08-08.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class VoteService {

  private final PetRepository petRepository;
  private final VoteProducer voteProducer;
  private final LikeRepository likeRepository;

  /**
   *
   * @param petId
   * @param like
   * @throws JsonProcessingException
   */
  public void produceLikeVotes (Long petId, Likes like) throws JsonProcessingException {

    Optional<Pet> pet = petRepository.findById(petId);

    pet.ifPresentOrElse(like::setPet, () -> {
      throw new EntityNotFoundException();
    });

    voteProducer.produceVote(like);
  }

  public void updateLikeVotes (Long petId, Likes like) {

    Optional<Pet> pet = petRepository.findById(petId);

    pet.ifPresentOrElse(like::setPet, () -> {
      throw new EntityNotFoundException();
    });

    likeRepository.save(like);
  }
}
