package com.ott8bre.data;

import com.ott8bre.F1;
import com.ott8bre.F2;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *
 * @author Francesco Frosini <ott8bre@gmail.com>
 * @param <A>
 */
public abstract class List<A> implements Iterable<A> {

    //- STATICS -//
    
    public static <A> List<A> empty(){ 
        return new Empty<>(); 
    }
    
    public static <A> List<A> cons(final A head, final List<A> tail) {
        return new Cons<>(head, tail);
    }
    
    public static <A> List<A> single(final A a) {
        return cons(a, List.<A>empty());
    }
    
    public static <A> List<A> fromArray(final A[] as) {
        List<A> l = empty();
        for (int i = as.length-1; i >= 0; i--) {
            l = cons(as[i], l);                       
        }
        return l;
    }

    public static <A> List<A> fromCollection(final Collection<A> as) {
        List<A> l = empty();
        for (A a : as) {
            l = cons(a, l);          
        }
        return l.reverse();    
    }
    
    public static <A> List<A> from(A... as) {
        return fromArray(as);
    }
    
    public static <A> List<A> repeat(final int n, final A a) {
        return (n <= 0 ? List.<A>empty() : cons(a, repeat(n-1, a)));
    }
    
    public static List<Integer> range(final int from, final int to) {
        return (from > to ? List.<Integer>empty() : cons(from, range(from+1, to)));
    }

    @Override
    public final Iterator<A> iterator() {
        return toCollection().iterator();
    }

    
    //- Basics -//
    public abstract boolean isEmpty();
    public abstract int length(); 
    public abstract List<A> reverse(); 
    public abstract boolean contains(final A a);
    public abstract <B> boolean equals(List<B> b);

    //- Sub-lists -//
    public abstract A head();   
    public abstract List<A> tail();
    public abstract List<A> take(final int a);
    public abstract List<A> drop(final int a);
    public abstract List<A> takeWhile(final F1<A,Boolean> f);
    public abstract List<A> dropWhile(final F1<A,Boolean> f);
    public abstract List<A> filter(final F1<A,Boolean> f);

    //- Putting Lists Together -//
    public final List<A> prepend(final A a){ return cons(a, this); }
    //public abstract List<A> prepend(final List<A> a);
    public final List<A> append(final A a){ return isEmpty() ? single(a) : cons(head(), tail().append(a)); }
    //public abstract List<A> append(final List<A> a);
    //public abstract List<A> concat();
    //, intersperse
    
    //- Taking Lists Apart
    //partition, unzip

    //- Special Maps
    public abstract <B> List<B> map(final F1<A,B> f);
    //filterMap, concatMap, indexedMap

    //- Folding
    public abstract <B> B foldLeft(final F2<B,A,B> f, final B b);
    public abstract <B> B foldRight(final F2<A,B,B> f, final B b);
    public abstract A foldLeft1(final F2<A,A,A> f);
    public abstract A foldRight1(final F2<A,A,A> f);

    //- Special Folds
    //sum, product, maximum, minimum, all, any, scanl

    //- Sorting
    //sort, sortBy, sortWith

    //- Set
    //union, intersect
    
    public final A[] toArray(){
        A[] arr = (A[]) new Object[length()];
        int i=0;
        for (A a : this) {
            arr[i++] = a;
        }
        return arr;
    }
    
  public final Collection<A> toCollection() {
    return new AbstractCollection<A>() {
      @Override
      public Iterator<A> iterator() {
        return new Iterator<A>() {
          private List<A> xs = List.this;

          @Override
          public boolean hasNext() {
            return !xs.isEmpty();
          }

          @Override
          public A next() {
            if (xs.isEmpty())
              throw new NoSuchElementException();
            else {
              final A a = xs.head();
              xs = xs.tail();
              return a;
            }
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }

      @Override
      public int size() {
        return length();
      }
    };
  }
    
    
    private static final class Empty<A> extends List<A> {
        public static final Empty<Object> INSTANCE = new Empty<>();

        @Override
        public A head() {
            throw new RuntimeException("head on empty list");
        }

        @Override
        public List<A> tail() {
            throw new RuntimeException("tail on empty list");
        }

        @Override
        public <B> B foldLeft(F2<B, A, B> f, B b) {
            return b;
        }

        @Override
        public <B> B foldRight(F2<A, B, B> f, B b) {
            return b;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public int length() {
            return 0;
        }

        @Override
        public List<A> reverse() {
            return this;
        }

        @Override
        public boolean contains(final A a) {
            return false;
        }

        @Override
        public A foldLeft1(final F2<A, A, A> f) {
            throw new RuntimeException("foldLeft1 on empty list");
        }

        @Override
        public A foldRight1(final F2<A, A, A> f) {
            throw new RuntimeException("foldRight1 on empty list");
        }

        @Override
        public List<A> filter(F1<A, Boolean> f) {
            return this;
        }

        @Override
        public List<A> take(int a) {
            return this;
        }
        
        @Override
        public List<A> takeWhile(F1<A, Boolean> f) {
            return this;
        }

        @Override
        public List<A> drop(int a) {
            return this;
        }
        
        @Override
        public List<A> dropWhile(F1<A, Boolean> f) {
            return this;
        }

        @Override
        public <B> List<B> map(F1<A, B> f) {
            return List.<B>empty();
        }

        @Override
        public <B> boolean equals(List<B> b) {
            return b.isEmpty();
        }
    
        @Override
        public final String toString() {
            return "[]";
        }

    }

    private static final class Cons<A> extends List<A> {
        private final A head;
        private final List<A> tail;

        Cons(final A head, final List<A> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public A head() {
            return head;
        }

        @Override
        public List<A> tail() {
            return tail;
        }

        /*private void tail(final List<A> tail) {
          this.tail = tail;
        }*/

        @Override
        public <B> B foldLeft(F2<B, A, B> f, B b) {
            return tail.foldLeft(f, f.apply(b, head)); 
        }

        @Override
        public <B> B foldRight(F2<A, B, B> f, B b) {
            return f.apply(head, tail.foldRight(f,b)); // foldr f e (x:xs) = f x (foldr f e xs)
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public int length() {
            return 1 + tail().length();
        }

        @Override
        public List<A> reverse() { //foldl (::) [] list
            return tail.reverse().append(head); 
        }

        @Override
        public boolean contains(final A a) {
            return head == a || tail.contains(a);
        }

        @Override
        public A foldLeft1(final F2<A, A, A> f) {
            return tail.foldLeft(f, head);
        }

        @Override
        public A foldRight1(final F2<A, A, A> f) {
            return tail.foldRight(f, head);
        }

        @Override
        public List<A> filter(F1<A, Boolean> f) {
            return f.apply(head) ? cons(head, tail.filter(f)) : tail.filter(f);
        }

        @Override
        public List<A> take(int a) {
            return a > 0 ? cons(head, tail.take(a-1)) : List.<A>empty();
        }
        
        @Override
        public List<A> takeWhile(F1<A, Boolean> f) {
            return f.apply(head) ? cons(head, tail.takeWhile(f)) : List.<A>empty();
        }

        @Override
        public List<A> drop(int a) {
            return a > 0 ? tail.drop(a-1) : this;
        }

        @Override
        public List<A> dropWhile(F1<A, Boolean> f) {
            return f.apply(head) ? tail.takeWhile(f) : this;
        }

        @Override
        public <B> List<B> map(F1<A, B> f) {
            return cons(f.apply(head), tail.map(f));
        }

        @Override
        public <B> boolean equals(List<B> b) {
            return !b.isEmpty() && ( this.head.equals(b.head()) ) && ( this.tail.equals(b.tail()) );
        }

        @Override
        public final String toString() {
            return "[" + head.toString() + tail.foldLeft(new F2<String,A,String>() {

                @Override
                public String apply(String a, A b) {
                    return a + "," + b.toString();
                    //return b.isEmpty() ? a.toString() : a.toString() + "," + b;
                }
            }, "") + "]";
        }  

  }
    

    //--//
    
    
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof List)) return false;

        List that = (List)other;        

        return this.equals(that);
    }

    @Override
    public int hashCode() {
        return isEmpty() ? -1 : 41 * head().hashCode() + 23 * tail().hashCode();
    }
        
}
