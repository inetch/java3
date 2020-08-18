package ru.gb.hw7.testsuite;

public class CheckTest {
    @BeforeSuite
    public static void before(){
        System.out.println("Before!");
    }

    /*@BeforeSuite
    public static void before2(){
        System.out.println("Before2!"); //excpetion as expected
    }*/

    @AfterSuite
    public static void after(){
        System.out.println("After!");
    }

    @Test(order = 9)
    public static void check9(){
        System.out.println("check9!");
    }

    @Test(order = 0)
    public static void check0(){
        System.out.println("Check0!");
    }

    @Test(order = 6)
    public static void check6(){
        System.out.println("Check6!");
    }
}
