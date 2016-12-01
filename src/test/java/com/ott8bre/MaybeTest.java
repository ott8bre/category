package com.ott8bre;

import com.ott8bre.data.Maybe;
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
public class MaybeTest {

    /**
     * Test of withDefault method, of class Maybe.
     */
    @Test
    public void testWithDefault() {
        System.out.println("withDefault");
        assertEquals(0, Maybe.nothing().withDefault(0));
        assertEquals(1, 1*Maybe.just(1).withDefault(0));
    }

    /**
     * Test of isJust method, of class Maybe.
     */
    @Test
    public void testIsJust() {
        System.out.println("isJust");
        assertFalse(Maybe.nothing().isJust());
        assertTrue(Maybe.just(1).isJust());
    }

    /**
     * Test of isNothing method, of class Maybe.
     */
    @Test
    public void testIsNothing() {
        System.out.println("isNothing");
        assertTrue(Maybe.nothing().isNothing());
        assertFalse(Maybe.just(1).isNothing());
    }
    
}
