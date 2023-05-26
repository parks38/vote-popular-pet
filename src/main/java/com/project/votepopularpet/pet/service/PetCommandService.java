package com.project.votepopularpet.pet.service;

import com.project.votepopularpet.common.exception.EntityNotFoundException;
import com.project.votepopularpet.pet.dto.PetDetailDto;
import com.project.votepopularpet.pet.entity.Pet;
import com.project.votepopularpet.repository.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * PetCommandService
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PetCommandService {

    private final PetRepository petRepository;

    public PetDetailDto findPetDetailDtoById(Long id) {

        Pet petInfo = petRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 정보를 찾을 수 없습니다."));

        return PetDetailDto.of(petInfo);
    }
}
