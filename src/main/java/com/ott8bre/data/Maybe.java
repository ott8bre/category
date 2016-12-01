package com.ott8bre.data;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 * @param <A>
 */
public abstract class Maybe<A> {

    private Maybe() {
    }

    public abstract A withDefault(final A a);
    
    public final boolean isJust() {
        return this instanceof Just;
    }

    public final boolean isNothing() {
        return this instanceof Nothing;
    }
    
    // CTORS //
    
    public static <T> Maybe<T> just(final T t) {
        return new Just<>(t);
    }

    public static <T> Maybe<T> nothing() {
        return new Nothing<>();
    }

    // INSTANCES //
      
    private static final class Nothing<A> extends Maybe<A> {
        @Override
        public A withDefault(final A a) {
            return a;
        }
    }

    private static final class Just<A> extends Maybe<A> {
        private final A impl;

        Just(final A a) {
            this.impl = a;
        }
        
        @Override
        public A withDefault(final A a) {
            return impl;
        }
    }
    
    
} // END Maybe
