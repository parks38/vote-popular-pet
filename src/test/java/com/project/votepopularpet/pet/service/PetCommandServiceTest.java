package com.project.votepopularpet.pet.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 Test PetCommandServiceTest.java
 *
 * @author suna.park
 * @createdDate 2023-06-22.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class PetCommandServiceTest {
    @Autowired
    PetCommandService petCommandService;

    @Test
    void cachePetList() {
        Pageable pageable = PageRequest.of(1, 3);
        petCommandService.findPetInfoPageableList(pageable);

        // redis 명령어
        // > keys *
        // > get keyName
    }
}