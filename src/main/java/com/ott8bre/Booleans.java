package com.ott8bre;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public final class Booleans {
    
    // UNARY //
    
    public static F1<Boolean,Boolean> not = new F1<Boolean, Boolean>() {

        @Override
        public Boolean apply(Boolean a) {
            return !a;
        }
    };
    
    // BINARY //
    
    public static F2<Boolean,Boolean,Boolean> or = new F2<Boolean, Boolean, Boolean>() {

        @Override
        public Boolean apply(Boolean a, Boolean b) {
            return a || b;
        }
    };
    
    public static F2<Boolean,Boolean,Boolean> and = new F2<Boolean, Boolean, Boolean>() {

        @Override
        public Boolean apply(Boolean a, Boolean b) {
            return a && b;
        }
    };
    
}
