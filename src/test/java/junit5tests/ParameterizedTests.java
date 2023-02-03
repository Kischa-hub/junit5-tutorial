package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value:{arguments}")
    @ValueSource(ints = {1, 5, 6, 7, 9})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run:{index} - Value:{arguments}")
    //@NullSource
    //@EmptySource
    @NullAndEmptySource
    @ValueSource(strings = {"firststring", "secondstring", "thirdstring"})
    void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run:{index} - Value:{arguments}")
    @CsvSource(value={"Steve,rogers","Captain,Marvel","bucky,barnes"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run:{index} - Value:{arguments}")
    @CsvSource(value={"steve,32,true","captain,21,false","bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2 , boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest(name = "Run:{index} - Value:{arguments}")
    @CsvSource(value={"captain america,'steve,rogers'","winter solider,'bucky,branes'"})
    void csvSource_StringWithComa(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest(name = "Run:{index} - Value:{arguments}")
    @CsvSource(value={"steve?rogers","bucky?barnes"},delimiter='?')
    void csvSource_StringWithDeiffDeliminter(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files={"src/test/resources/params/shoppingList.csv","src/test/resources/params/shoppingList2.csv"},numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String param1,double param2, int param3, String param4,String param5){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3 + ", param4 = " + param4 + ", param5 = " + param5);
    }


    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/params/shoppingList3.csv",numLinesToSkip = 1,delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String param1,double param2, int param3, String param4,String param5){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3 + ", param4 = " + param4 + ", param5 = " + param5);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = " + param1);
    }


    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<String> sourceString(){
        //proccessing done here
        return Arrays.asList("Tomato","Carrot","Cabbage");
    }

    Stream<String> sourceStringAsStream(){
        //proccessing done here
        return Stream.of("Apple","Banana","Pear");
    }
    List<Arguments> sourceList_StringDouble(){
        //processing
        return Arrays.asList(arguments("Tomato",2.0), arguments("Carrot",4.5), arguments("Banana",3.9));
    }

}
