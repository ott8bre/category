package com.ott8bre;

import static com.ott8bre.Unit.unit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public class F0Test {
    
    private final F0<Integer> f0int = F.constant(1234567890);
    
    /**
     * Test of apply method, of class F0.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        assertEquals(1234567890, 1*f0int.apply());
    }

    @Test
    public void testThen() {
        System.out.println("then");
        Double value = f0int.then(new F1<Integer, Double>() {

            @Override
            public Double apply(Integer a) {
                return 0.0 * a;
            }
        }).apply();
        
        assertEquals(0.0, value, 0.1);    
    }

    @Test
    public void testF1Void() {
        Double value = (
            new F1<Unit, Double>() {

            @Override
            public Double apply(Unit _) {
                return 0.0;
            }
        }).apply(unit);
    }

}
