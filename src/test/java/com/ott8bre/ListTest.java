package com.ott8bre;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public class ListTest {
    private final List<Integer> from123;

    private final F1<Integer, Boolean> isEven = new F1<Integer, Boolean>(){
            
            @Override
            public Boolean apply(Integer a) {
                return a%2==0;
            }
            
        };

    private final F1<Integer, Integer> add1 = new F1<Integer, Integer>() {

        @Override
        public Integer apply(Integer a) {
            return a+1;
        }
    };
    
    private final F2<Integer,Integer,Integer> add = new F2<Integer,Integer,Integer>(){

        @Override
        public Integer apply(Integer a, Integer b) {
            return a + b;
        }
    };
    
    public ListTest() {
        from123 = List.from(1,2,3);
    }
        
    /**
     * Test of prepend method, of class List.
     */
    @Test
    public void testPrepend() {
        System.out.println("prepend");
        assertEquals(List.from(0,1,2,3), from123.prepend(0));
    }

    /**
     * Test of append method, of class List.
     */
    @Test
    public void testAppend() {
        System.out.println("append");
        assertEquals(List.from(1,2,3,4), from123.append(4));
    }

    /**
     * Test of reverse method, of class List.
     */
    @Test
    public void testReverse() {
        System.out.println("reverse");
        assertEquals(List.from(3,2,1), from123.reverse());
    }

    /**
     * Test of filter method, of class List.
     */
    @Test
    public void testFilter() {
        System.out.println("filter");
        assertEquals(List.from(2), from123.filter(isEven));
    }

    /**
     * Test of takeWhile method, of class List.
     */
    @Test
    public void testTakeWhile() {
        System.out.println("takeWhile");
        assertEquals(List.from(), from123.takeWhile(isEven));
    }

    /**
     * Test of dropWhile method, of class List.
     */
    @Test
    public void testDropWhile() {
        System.out.println("dropWhile");
        assertEquals(from123, from123.dropWhile(isEven));
    }

    /**
     * Test of map method, of class List.
     */
    @Test
    public void testMap() {
        System.out.println("map");
        assertEquals(List.from(2,3,4), from123.map(add1));
    }

    /**
     * Test of reduce method, of class List.
     */
    @Test
    public void testReduce() {
        System.out.println("reduce");
        assertEquals(6, 1*from123.reduce(0, add));
    }

    /**
     * Test of reduce1 method, of class List.
     */
    @Test
    public void testReduce1() {
        System.out.println("reduce1");
        assertEquals(6, 1*from123.reduce1(add));
    }

    /**
     * Test of head method, of class List.
     */
    @Test
    public void testHead() {
        System.out.println("head");
        assertEquals(1, 1*from123.head());
    }

    /**
     * Test of tail method, of class List.
     */
    @Test
    public void testTail() {
        System.out.println("tail");
        assertEquals(List.from(2,3), from123.tail());
    }

    /**
     * Test of length method, of class List.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        assertEquals(3, from123.length());
    }

    /**
     * Test of toString method, of class List.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("[1, 2, 3]", from123.toString());
    }
    
}
