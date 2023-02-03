package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index} - value:{arguments}")
    @ValueSource(ints = {1, 5, 6, 7, 9})
    void intValues(int theParam) {
        Assumptions.assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run:{index} - Value:{arguments}")
    @CsvSource(value={"Steve,rogers","Captain,Marvel","bucky,barnes"})
    void csvSource_StringString(String param1, String param2){
        Assumptions.assumeFalse(param1.equals("Steve"),"The assumption failed for the follwing param 2:"+ param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run:{index} - Value:{arguments}")
    @CsvSource(value={"steve,32,true","captain,21,false","bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2 , boolean param3){
        Assumptions.assumingThat(param2 >20, ()-> System.out.println("this code run"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
