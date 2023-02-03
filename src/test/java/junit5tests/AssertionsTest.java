package junit5tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    void assertEqualTest() {
        assertEquals("firstString", "secondString", "this two string not the same");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString", "thirdString");
        assertEquals(expectedValues,actualValues);
    }

    @Test
    void assertEqualArrayTest(){
        int[] expectedValues={1,3,4};
        int[] actualValues={1,2,4};
        assertArrayEquals(expectedValues,actualValues);
    }
    @Test
    void assertTrueTest(){
        assertFalse(false,"The bool condition is not evaluate to true");
        assertTrue(false,"The bool condition is not evaluate to true");
    }
    @Test
    void assertThrowTest(){
       assertThrows(NullPointerException.class,null);
    }
    @Test
    void assertForMapTest(){
        Map<String,Integer> theMap = new HashMap<>();
        theMap.put("firstKey",1);
        theMap.put("secondKey",2);
        theMap.put("thirdKey",3);
        assertThat(theMap, hasValue(2));
        assertThat(theMap, hasKey("secondKey1"));
    }
    @Test
    void assertForList(){
        List<String> theList = Arrays.asList("firstString","secondString","thirdString");
        assertThat(theList, hasItem("thirdString"));
    }

    @Test
    void assertForAnyOf(){
        List<String> theList = Arrays.asList("firstString","secondString","thirdString");
        assertThat(theList, allOf(hasItem("thirdString"),
                hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder(){
        List<String> theList = Arrays.asList("firstString","secondString","thirdString");
        assertThat(theList, containsInAnyOrder("firstString","thirdString","secondString"));

    }

}
