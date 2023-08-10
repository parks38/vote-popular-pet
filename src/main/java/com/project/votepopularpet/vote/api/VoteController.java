package com.project.votepopularpet.vote.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.votepopularpet.common.exception.EntityNotFoundException;
import com.project.votepopularpet.pet.entity.Likes;
import com.project.votepopularpet.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * VoteController.java
 *
 * @author suna.park
 * @createdDate 2023-08-09.
 */
@RestController
@RequestMapping("/api/v1/vote")
@RequiredArgsConstructor
public class VoteController {

  private final VoteService voteService;

  /**
   * Like, PetId
   * @param like
   * @return
   */
  @PostMapping("/{petId}")
  public ResponseEntity<Void> voteForPetMessageQueue (@PathVariable Long petId, @RequestBody Likes like) throws JsonProcessingException {
    try {
      voteService.produceLikeVotes(petId, like);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/test/{petId}")
  public ResponseEntity<Void> voteForPet (@PathVariable Long petId, @RequestBody Likes like) throws JsonProcessingException {
    try {
      System.out.println("!!!!!!!!!!!!!!");
      voteService.updateLikeVotes(petId, like);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
