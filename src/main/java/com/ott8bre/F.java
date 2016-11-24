package com.ott8bre;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public final class F {

    public static <A> F0<A> constant(final A a){
        return new F0<A>() {

            @Override
            public A apply(Unit _) {
                return a;
            }
        };
    }
    
    public static <A> F1<A,A> identity(){
        return new F1<A, A>() {

            @Override
            public A apply(A a) {
                return a;
            }
        };
    }
            
    //always
}
