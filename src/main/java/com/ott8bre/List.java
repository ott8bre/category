package com.ott8bre;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 * @param <A>
 */
public final class List<A> {
    private final LinkedList<A> impl;
    
    private List() {
        impl = new LinkedList<>();
    }

    private List(List<A> a) {
        this(a.impl);
    }

    private List(Collection<A> c){
        this();
        this.impl.addAll(c);
    }
    
    private List(A... as){
        this();
        Collections.addAll(this.impl, as);
    }

    public static <A> List<A> from(final A... ts) {
        return new List(ts);
    }
    
    public static <A> List<A> from(final Collection<? extends A> c){
        return new List(c);
    }
    
    public List<A> prepend(final A t) {        
        LinkedList<A> ll = new LinkedList<>();    
        ll.add(t);
        ll.addAll(impl);
        return new List(ll);
    }    
    
    public List<A> append(final A a) {
        LinkedList<A> ll = new LinkedList<>(impl);
        ll.add(a);
        return new List(ll);
    }

    public List<A> reverse(){
        LinkedList<A> ll = new LinkedList<>();
        for (int i = impl.size()-1; i >= 0; i--) {
            ll.add(impl.get(i));
        }
        return new List(ll);
    }
    
    public List<A> filter(final F1<A,Boolean> f1){
        if(f1==null) return null;
        
        LinkedList<A> ll = new LinkedList<>();
        for (A element : impl) {
            if(f1.apply(element)) ll.add(element);
        }
        return new List(ll);
    }
    
    public List<A> takeWhile(final F1<A,Boolean> f1){
        if(f1==null) return null;
        
        LinkedList<A> ll = new LinkedList<>();
        for (A element : impl) {
            if(f1.apply(element)){
                ll.add(element);
            } else {
                return new List(ll);
            }
        }
        return new List(ll);
    }
    
    public List<A> dropWhile(final F1<A,Boolean> f1){
        if(f1==null) return null;
        
        LinkedList<A> ll = new LinkedList<>(impl);
        for (A element : impl) {
            if(f1.apply(element)){
                ll.remove(0);
            } else {
                return new List(ll);
            }
        }
        return new List(ll);
    }
    
    public <B> List<B> map(final F1<? super A, ? extends B> f1){
        if(f1==null) return null;
        
        LinkedList<B> ll = new LinkedList<>();
        for (A element : impl) {
            ll.add( f1.apply(element) );
        }
        return new List(ll);
    }
    
    public <B> B reduce(final B b, final F2<A,B,B> f2){
        if(b==null || f2==null) return null;
        
        B reduced = b;
        for (A element : impl) {
            reduced = f2.apply(element, reduced);
        }
        return reduced;
    }    

    public A reduce1(final F2<A,A,A> f2){
        if(f2==null || impl.isEmpty()) return null;
        
        return tail().reduce(head(), f2);
    }        
    
    public A head(){
        if(impl.isEmpty()) return null;
        
        return impl.getFirst();
    }
    
    public List<A> tail(){
        if(impl.isEmpty()) return null;
        
        LinkedList<A> ll = new LinkedList<>(impl);
        ll.removeFirst();
        return new List(ll);
    }

    public int length() {
        return impl.size();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof List)) return false;

        List that = (List)other;        

        return this.impl.equals(that.impl);
    }

    @Override
    public int hashCode() {
        return impl.hashCode();
    }

    @Override
    public String toString() {
        return impl.toString();
    }  
}
