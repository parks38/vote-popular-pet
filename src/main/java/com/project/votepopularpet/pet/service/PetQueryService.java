package com.project.votepopularpet.pet.service;

import com.project.votepopularpet.pet.entity.Pet;
import com.project.votepopularpet.pet.repository.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * PetQueryService
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PetQueryService {

    private final PetRepository petRepository;

    /**
     * pet 신규 정보 추가
     * @param pet
     */
    public void createNewPetInfo(Pet pet) {

        petRepository.save(pet);
    }
}
