package com.project.votepopularpetbackend.vote.service;

import com.project.votepopularpetbackend.pet.entity.Likes;
import com.project.votepopularpetbackend.pet.repository.LikeRepository;
import jakarta.transaction.Transactional;
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

  private final LikeRepository likeRepository;

  /**
   * like 투표하기
   * (투표시 동일한 petId, userId 매치가 있다면 update 수정)
   *
   * @param like
   */
  public void saveLikeVotes(Likes like) {

    // 해당 값을 찾아서 동일한 것이 있다면 대체
    Optional<Likes> originalLike = likeRepository.findByUserIdAndPetId(like.getUserId(), like.getPet().getPetId());

    originalLike.ifPresentOrElse(orlike -> {
      orlike.setStatus(like.getStatus());
    }, () -> {
      likeRepository.save(like);
    });
  }
}
