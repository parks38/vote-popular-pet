package com.project.votepopularpet.pet.repository;

import com.project.votepopularpet.pet.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PetRepository
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Page<Pet> findAll(Pageable pageable);
}
