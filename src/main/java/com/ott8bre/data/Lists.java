package com.ott8bre.data;

import com.ott8bre.F2;


/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 */
public final class Lists {    
    
    public static <A> F2<A, List<A>, List<A>> cons(){
        return new F2<A, List<A>, List<A>>() {

            @Override
            public List<A> apply(A a, List<A> b) {
                return List.cons(a, b);
            }
        };  
    }

    /*

    public static <T> List<T> prepend(final List<T> src, final T t) {
        if(src==null) return null;
        
        return src.prepend(t);
    }
    
    public static <T> List<T> append(final List<T> src, final T item){
        if(src==null) return null;
        
        return src.append(item);
    }
    
    public static <T> List<T> reverse(final List<T> src){
        if(src==null) return null;
        
        return src.reverse();
    }    
    
    public static <T> List<T> filter(final List<T> src, final Predicate<? super T> predicate){
        if(src==null) return null;
        
        return src.filter(predicate);
    }

    public static <T> List<T> takeWhile(final List<T> src, final Predicate<? super T> predicate){
        if(src==null) return null;
        
        return src.takeWhile(predicate);
    }
    
    public static <T> List<T> dropWhile(final List<T> src, final Predicate<? super T> predicate){
        if(src==null) return null;
        
        return src.dropWhile(predicate);
    }
    
    public static <I,O> List<O> map(final List<I> src, final F1<? super I, ? extends O> mapper){
        if(src==null) return null;
        
        return src.map(mapper);
    }
    
    public static <A,B> B reduce(final List<A> src, final B init, final Reducer<A,B> reducer){
        if(src==null) return null;
        
        return src.reduce(init, reducer);
    }    

    public static <T> T reduce1(final List<T> src, final Reducer<T,T> reducer){
        if(src==null) return null;
        
        return src.reduce1(reducer);
    }    

    */
}
