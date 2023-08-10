package com.project.votepopularpet.pet.repository;

import com.project.votepopularpet.pet.entity.Likes;
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

  @Query(value= "SELECT like FROM Likes like WHERE like.userId = :userId and like.pet.petId = :petId")
  Optional<Likes> findByUserIdAndPetId(String userId, Long petId);
}
