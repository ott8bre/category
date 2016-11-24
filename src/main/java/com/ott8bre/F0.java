package com.ott8bre;

import static com.ott8bre.Unit.unit;

/**
 * F0 : () -> A alias for F1 : Unit -> A
 * @author Francesco Frosini <ott8bre@gmail.com>
 * @param <A>
 */

/*
Void non può essere istanziato

public abstract class F0<A> extends F1<Void,A>{
    public abstract A apply();
    
    @Override
    public A apply(Void a) {
        return apply();
    }

}
*/

public abstract class F0<A> extends F1<Unit,A>{
    public A apply(){
        return apply(unit);
    }
    
    @Override
    public <B> F0<B> then(final F1<A,B> f){
        return new F0<B>() {

            @Override
            public B apply(Unit _) {
                return f.apply( F0.this.apply() );
            }
        };
    }
}
/*
public abstract class F0<A> {
    public abstract A apply();
    
    public <B> F0<B> then(final F1<A,B> f){
        return new F0<B>() {

            @Override
            public B apply() {
                return f.apply( F0.this.apply() );
            }
        };
    }
}
*/