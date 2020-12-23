package me.rnthd2.study_inflearn_the_java_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudyJUnit4Test {

    @Before
    public void beforeTest(){
        System.out.println("before test");
    }

    @Test
    public void createTest1(){
        System.out.println("create test1");
    }

    @Test
    public void createTest2(){
        System.out.println("create test2");
    }

    @After
    public void afterTest(){
        System.out.println("after test");
    }
}
