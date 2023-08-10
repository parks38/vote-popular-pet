package com.project.votepopularpet.pet.repository;

import com.project.votepopularpet.pet.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PetRepository
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

}
