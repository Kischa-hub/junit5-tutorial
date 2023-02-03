package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest {

  @Test
  @Disabled(value="Disabled for demo of @disabled")
  void firstTest(){
      System.out.println("This is first test method");
  }

  @Test
  @DisabledOnOs(value= OS.WINDOWS,disabledReason = "Worked only on Windows")
  void secondTest(){
      System.out.println("This is second test method");
  }


    @Test
    @EnabledOnOs(value= OS.WINDOWS, disabledReason = "Worked only on Windows")
    void second2Test(){
        System.out.println("This is second2 test method");
    }

    @Test
    //@DisabledIfSystemProperty()
    void thirdTest(){
        System.out.println("This is third test method");
    }

    @Test
    @DisabledIf(value = "provider",disabledReason ="Disabled for demo of @ DisabledIf" )
    void forthTest(){
        System.out.println("This is forth test method");
    }

    @Test
    void fifthTest(){
        System.out.println("This is fifth test method");
    }

    boolean provider (){
      return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);
    }
}
