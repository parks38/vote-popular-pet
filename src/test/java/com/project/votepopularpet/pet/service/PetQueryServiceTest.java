package com.project.votepopularpet.pet.service;

import com.project.votepopularpet.pet.entity.Pet;
import com.project.votepopularpet.repository.PetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * PetQueryServiceTest.java
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */

@ExtendWith(MockitoExtension.class)
class PetQueryServiceTest {

    /**
     * @ExtendWith(SpringExtension.class) SpringContainer를 로드하므로 Test 객체에 @Autowired를 통해 Bean 의존성을 주입시킬 수 있다.
     * 또한 Bean을 Mocking하기위한 @MockBean 기능을 사용할 수 있다.
     * 테스트를 위해 Spring이 필요하다면 사용해야 한다.
     * @ExtendWith(MockitoExtension.class) SpringContainer를 로드하지않고 테스트를 위한 기능만 제공한다.
     * @Mock, @Spy 기능을 사용할 수 있다.
     * 테스트에 Spring이 필요없이 순수한 단위 테스트만 필요하다면 위 코드를 추가하면 된다.
     * <p>
     * org.mockito.exceptions.misusing.UnnecessaryStubbingException:
     * Unnecessary stubbings detected.
     * => 원인 :  1.x일 때 없었던 Strictness(테스트코드의 엄격성)을 규정하기 위해 생긴 에러
     * 테스트코드에서 사용되지 않는 stub (when/thenReturn)을 줄여줍니다.
     * 테스트코드에서 불필요한 코드 중복을 없애주고 이를 통해 필요없는 테스트 코드 역시 줄여줍니다.
     * 죽은 코드를 제거하면서 생기는 불필요한 테스트를 없애도록 도와줍니다.
     * 이를 통해 디버깅 편의성과 생산 효율을 올려줍니다.
     * 해결방법 :
     * - @MockitoSettings(strictness = Strictness.LENIENT)
     * - @Rule public MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.LENIENT);
     */

    @InjectMocks
    private PetCommandService petCommandService;

    @Mock
    private PetRepository petRepository;

    private Pet pet;

    @Test
    @DisplayName("")
    void successToCreateNewPetInfo() {
    }

}