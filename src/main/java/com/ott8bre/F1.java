package com.ott8bre;

/**
 * F1 : A -> B
 * @author Francesco Frosini <ott8bre@gmail.com>
 * @param <A>
 * @param <B>
 */
public abstract class F1<A, B> {
    public abstract B apply(final A a);
    
    public <C> F1<A,C> then(final F1<B,C> f){
        return new F1<A,C>() {

            @Override
            public C apply(A a) {
                return f.apply( F1.this.apply(a) );
            }
        };
    }
    /*
    public F0<B> after(final F0<A> f){
        return new F0<B>() {

            @Override
            public B apply() {
                return F1.this.apply( f.apply() );
            }
        }; 
    }
    
    public <Z> F1<Z,B> after(final F1<Z,A> f){
        return new F1<Z,B>() {

            @Override
            public B apply(Z z) {
                return F1.this.apply( f.apply(z) );
            }
        };
    }
    
    public <Y,Z> F2<Y,Z,B> after(final F2<Y,Z,A> f){
        return new F2<Y,Z,B>() {

            @Override
            public B apply(Y y, Z z) {
                return F1.this.apply( f.apply(y,z) );
            }
        };
    }
    */
}
