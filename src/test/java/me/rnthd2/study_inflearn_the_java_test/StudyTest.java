package me.rnthd2.study_inflearn_the_java_test;

import org.junit.jupiter.api.*;
import org.mockito.internal.util.Supplier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {


    @Test
    @DisplayName("테스트를 받아랏 ヽ| ・∀・|ノ-=≡≡≡卍卍")
    /**
     * assertEquals
     * assertEquals(기대값, 실제값, 테스트 실패 메세지);
     * 테스트 실패 메세지를 람다로 해놓으면 실패한 경우에만 연산하여 노출한다.
     *
     * assertAll
     * 보통 상단 테스트 코드가 실패 했을 경우, 아래 테스트 코드는 실행하지 않아 실패했는지 아닌지 알 수 없다.
     * 이 경우 assertAll로 묶고 람다로 해놓으면 한번에 실행  시킬 수 있다.
     *
     * assertTimeoutPreemptively
     * assertTimeoutPreemptively은 timeout과는 달리 100ms가 지나면 즉각적으로 테스트를 종료한다.
     * 하지만 Thread local가 돌고 있는게 있다면 주의해서 작성해야 한다.
     * 스프링 트랜잭션과는 다른 별개의 쓰레드로 돌 수 있기 때문이다.
     */
    @FastTest
    void create() {
        Study study = new Study(10);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Study(-10));

        assertAll(
                () -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
                    new Study(10);
                    Thread.sleep(300);
                }),
                () -> assertEquals("limit은 0보다 커야합니다.", ex.getMessage()),
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT 여야한다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0 보다 커야 한다")
        );
    }

    @SlowTest
    @Disabled
//    @Tag("slow")
    void create1() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }


}
