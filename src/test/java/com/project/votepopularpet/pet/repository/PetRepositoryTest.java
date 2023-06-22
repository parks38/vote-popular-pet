package com.project.votepopularpet.pet.repository;

import com.project.votepopularpet.pet.entity.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 Test PetRepositoryTest.java
 *
 * @author suna.park
 * @createdDate 2023-06-22.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PetRepositoryTest {

    @Autowired
    PetRepository petRepository;

    @Test
    @DisplayName("pet name sort descending")
    void findAll() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("name").descending());
        Page<Pet> petList = petRepository.findAll(pageable);
        System.out.println(Arrays.toString(petList.getContent().toArray()));
    }
}