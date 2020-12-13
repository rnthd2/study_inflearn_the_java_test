package me.rnthd2.study_inflearn_the_java_test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {


	@Test
	@DisplayName("테스트를 받아랏 ヽ| ・∀・|ノ-=≡≡≡卍卍")
	void create(){
		Study study = new Study();
		assertNotNull(study);
		System.out.println("create");
	}

	@Test
	@Disabled
	void create1(){
		System.out.println("create1");
	}

	@BeforeAll
	static void beforeAll(){
		System.out.println("beforeAll");
	}

	@AfterAll
	static void afterAll(){
		System.out.println("afterAll");
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("beforeEach");
	}

	@AfterEach
	void afterEach(){
		System.out.println("afterEach");
	}



}
