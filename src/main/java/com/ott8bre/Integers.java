package com.ott8bre;

import java.util.Objects;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public final class Integers {
    
    // UNARY //
    
    public static F1<Integer,Integer> not = new F1<Integer, Integer>() {

        @Override
        public Integer apply(Integer a) {
            return -a;
        }
    };

    public static final F1<Integer, Boolean> even = new F1<Integer, Boolean>(){

        @Override
        public Boolean apply(Integer a) {
            return a%2==0;
        }
    };    
    
    // BINARY //
    
    public static F2<Integer,Integer,Integer> add = new F2<Integer, Integer, Integer>() {

        @Override
        public Integer apply(Integer a, Integer b) {
            return a + b;
        }
    };
    
    public static F2<Integer,Integer,Integer> sub = new F2<Integer, Integer, Integer>() {

        @Override
        public Integer apply(Integer a, Integer b) {
            return a - b;
        }
    };
    
    public static F2<Integer,Integer,Integer> mul = new F2<Integer, Integer, Integer>() {

        @Override
        public Integer apply(Integer a, Integer b) {
            return a * b;
        }
    };
    
    public static F2<Integer,Integer,Integer> div = new F2<Integer, Integer, Integer>() {

        @Override
        public Integer apply(Integer a, Integer b) {
            return a / b;
        }
    };
    
    

}
