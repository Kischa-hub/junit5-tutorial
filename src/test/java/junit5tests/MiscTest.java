package junit5tests;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {
    @Test
    //@Timeout(value= 5,unit= TimeUnit.MINUTES)
    @Timeout(5)
    void timeout() {
        System.out.println("This is test with timeout");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    Class NestedTest

    {

        @BeforeAll
        void beforeAll() {
        System.out.println("before all nested methods");
    }

        @Test
        void nestedTestMethod() {
        System.out.println("Nested test method");
    }
    }


}
