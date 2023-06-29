package com.project.votepopularpet.pet.api;

import com.project.votepopularpet.pet.dto.PetDetailDto;
import com.project.votepopularpet.pet.service.PetCommandService;
import com.project.votepopularpet.pet.service.PetQueryService;
import lombok.RequiredArgsConstructor;
import com.project.votepopularpet.pet.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PetRestController
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
@RestController
@RequestMapping("/api/v1/pet")
@RequiredArgsConstructor
public class PetRestController {

    private final PetQueryService petQueryService;
    private final PetCommandService petCommandService;

    /**
     * 신규 Pet Information 생성
     *
     * @param pet
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> createNewPetInfo (@RequestBody Pet pet) {

        petQueryService.createNewPetInfo(pet);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * pet 정보 조회 by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PetDetailDto> findPetInfoById (@PathVariable Long id) {

        return new ResponseEntity<>(petCommandService.findPetDetailDtoById(id), HttpStatus.OK);
    }

    /**
     * pet 리스트 조회
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<PetDetailDto>> findPetInfoPageableList (@PageableDefault(page = 0, size = 20) Pageable pageable) {

        return new ResponseEntity<>(petCommandService.findPetInfoPageableList(pageable), HttpStatus.OK);
    }
}
