package com.project.votepopularpet.pet.service;

import com.project.votepopularpet.common.exception.EntityNotFoundException;
import com.project.votepopularpet.pet.dto.PetDetailDto;
import com.project.votepopularpet.pet.entity.Pet;
import com.project.votepopularpet.pet.repository.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     *  Pet 상세 정보 단건 조회
     *
     * @Cacheable 은 캐시 애노테이션으로 해당 메서드의 반환값을 캐시에 저장하고
     * 동일한 파라미터로 호출 될 때 캐시된 값을 반환하게 된다.
     * 단건 조회 경우, 조건으로 메서드의 반환값이 null일 때에는 캐시 메모리에 저장하지 않는다.
     *
     * @param id
     * @return
     */
    @Cacheable(value="pet-detail", key="#id", unless = "#result == null")
    public PetDetailDto findPetDetailDtoById(Long id) {

        return petRepository.findById(id).map(PetDetailDto::of).orElseThrow(() -> new EntityNotFoundException("해당 정보를 찾을 수 없습니다."));
    }

    /**
     * Pet 리스트 조회
     * pageNumber 당 item cache (fixed. item 개수)
     * @param pageable
     * @return
     */
    @Cacheable(value="pet-list", key="#pageable.pageNumber", cacheManager = "cacheManager")
    public List<PetDetailDto> findPetInfoPageableList(Pageable pageable) {

        Page<Pet> petInfoList = petRepository.findAll(pageable);
        return petInfoList
                .getContent()
                .stream()
                .map(PetDetailDto::of)
                .toList();
    }
}
