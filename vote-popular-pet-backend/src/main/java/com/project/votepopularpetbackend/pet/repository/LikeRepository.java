package com.project.votepopularpetbackend.pet.repository;

import com.project.votepopularpetbackend.pet.entity.Likes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PetRepository
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

  /**
   *  like 동일한 userId, password 체크
   *
   * @param userId
   * @param petId
   * @return
   */
  @Query(value= "SELECT like FROM Likes like WHERE like.userId = :userId and like.pet.petId = :petId")
  Optional<Likes> findByUserIdAndPetId(String userId, Long petId);
}
