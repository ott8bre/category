package com.ott8bre;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public class ListTest {
    private final List<Integer> empty;
    private final List<Integer> from123;

    private final F2<Integer, List<Integer>, List<Integer>> cons = Lists.cons();
    
    private final F1<Integer, Boolean> isEven = Integers.even;
    private final F2<Integer,Integer,Integer> add = Integers.add;
    private final F1<Integer, Integer> add1 = add.apply2(1);
    
    public ListTest() {
        empty = List.empty();
        from123 = List.from(1,2,3);
    }
        
    @Test
    public void testRepeat() {
        System.out.println("repeat");
        assertEquals(List.empty(), List.repeat(0, 1));
        assertEquals(List.single(1), List.repeat(1, 1));
        assertEquals(List.from(1,1), List.repeat(2, 1));
    }

    @Test
    public void testRange() {
        System.out.println("range");
        assertEquals(from123, List.range(1, 3));
        assertEquals(List.single(1), List.range(1, 1));
        assertEquals(List.empty(), List.range(3, 1));
    }

    @Test
    public void testPrepend() {
        System.out.println("prepend");
        assertEquals(List.single(0), empty.prepend(0));
        assertEquals(List.from(0,1,2,3), from123.prepend(0));
        //assertEquals(List.from(0,1,2,3), from123.prepend(List.single(0)));
    }

    @Test
    public void testAppend() {
        System.out.println("append");
        assertEquals(List.single(4), empty.append(4));
        assertEquals(List.from(1,2,3,4), from123.append(4));
        //assertEquals(List.from(1,2,3,4), from123.append( List.single(4) ));
    }

    @Test
    public void testReverse() {
        System.out.println("reverse");
        assertEquals(empty, empty.reverse());
        assertEquals(List.from(3,2,1), from123.reverse());
    }

    @Test
    public void testFilter() {
        System.out.println("filter");
        assertEquals(empty, empty.filter(isEven));
        assertEquals(List.from(2), from123.filter(isEven));
    }

    @Test
    public void testTakeWhile() {
        System.out.println("takeWhile");
        assertEquals(empty, empty.takeWhile(isEven));
        assertEquals(List.from(), from123.takeWhile(isEven));
    }

    @Test
    public void testDropWhile() {
        System.out.println("dropWhile");
        assertEquals(empty, empty.dropWhile(isEven));
        assertEquals(from123, from123.dropWhile(isEven));
    }

    @Test
    public void testMap() {
        System.out.println("map");
        assertEquals(empty, empty.map(add1));
        assertEquals(List.from(2,3,4), from123.map(add1));
    }

    @Test
    public void testFoldLeft() {
        System.out.println("foldLeft");
        assertEquals(empty, empty.foldLeft(cons, empty));
        assertEquals(List.from(3,2,1), from123.foldLeft(cons, empty));
    }

    @Test
    public void testFoldRight() {
        System.out.println("foldRight");
        assertEquals(empty, empty.foldRight(cons, empty));
        assertEquals(from123, from123.foldRight(cons, empty));
    }

    @Test
    public void testFoldLeft1() {
        System.out.println("foldLeft1");
        try {
            empty.foldLeft1(add);
            fail("foldLeft1 on empty");
        } catch (Exception e) {
        }
        assertEquals(6, 1*from123.foldLeft1(add));
    }

    @Test
    public void testFoldRight1() {
        System.out.println("foldRight1");
        try {
            empty.foldRight1(add);
            fail("foldRight1 on empty");
        } catch (Exception e) {
        }
        assertEquals(6, 1*from123.foldRight1(add));
    }

    @Test
    public void testHead() {
        System.out.println("head");
        try {
            empty.head();
            fail("head on empty");
        } catch (Exception e) {           
        }
        assertEquals(1, 1*from123.head());
    }

    @Test
    public void testTail() {
        System.out.println("tail");
        try {
            empty.tail();
            fail("tail on empty");
        } catch (Exception e) {
        }
        assertEquals(List.from(2,3), from123.tail());
    }

    @Test
    public void testLength() {
        System.out.println("length");
        assertEquals(0, empty.length());
        assertEquals(3, from123.length());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("[]", empty.toString());
        assertEquals("[1,2,3]", from123.toString());
    }
    
}
