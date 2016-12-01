package com.ott8bre;

/**
 * F2 : A -> B -> C
 * @author Francesco Frosini <ott8bre@gmail.com>
 * @param <A>
 * @param <B>
 * @param <C>
 */
public abstract class F2<A, B, C> {
    public abstract C apply(final A a, final B b);
    
    public F2<B, A, C> flip(){
        return new F2<B, A, C>() {
            @Override
            public C apply(B a, A b) {
                return F2.this.apply(b, a);
            }
        };
    }
    
    public <D> F2<A,B,D> then(final F1<C,D> f){
        return new F2<A,B,D>() {

            @Override
            public D apply(A a, B b) {
                return f.apply( F2.this.apply(a, b) );
            }
        };
    }
    
    public F1<B,C> apply1(final A a){
        return new F1<B,C>(){

            @Override
            public C apply(B b) {
                return F2.this.apply(a,b);
            }            
        };
    }

    public F1<A,C> apply2(final B b){
        return new F1<A,C>(){

            @Override
            public C apply(A a) {
                return F2.this.apply(a,b);
            }            
        };
    }

}
