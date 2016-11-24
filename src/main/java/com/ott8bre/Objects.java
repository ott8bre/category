package com.ott8bre;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public final class Objects {
    
    // COMPARISON //
    
    public static F2<Object, Object, Boolean> equals = new F2<Object, Object, Boolean>() {
        @Override
        public Boolean apply(Object a, Object b) {
            return java.util.Objects.equals(a, b);
        }
    };
    
}
