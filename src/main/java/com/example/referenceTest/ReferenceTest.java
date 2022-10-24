package com.example.referenceTest;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
public class ReferenceTest {
    public static void main(String[] args)
    {
        // Strong Reference
        Gfg g = new Gfg();
        g.x();

        // Creating Weak Reference to Gfg-type object to which 'g'
        // is also pointing.
        WeakReference<Gfg> weakref = new WeakReference<Gfg>(g);

        //Now, Gfg-type object to which 'g' was pointing earlier
        //is available for garbage collection.
        //But, it will be garbage collected only when JVM needs memory.
        g = null;

//        System.gc(); //会回收weakref
        // You can retrieve back the object which
        // has been weakly referenced.
        // It successfully calls the method.
        g = weakref.get();

        g.x();

        // Strong Reference
        Gfg h = new Gfg();
        h.x();

        // Creating Soft Reference to Gfg-type object to which 'g'
        // is also pointing.
        SoftReference<Gfg> softref = new SoftReference<Gfg>(h);

        // Now, Gfg-type object to which 'g' was pointing
        // earlier is available for garbage collection.
        h = null;

        System.gc();//不会回收softref
        // You can retrieve back the object which
        // has been weakly referenced.
        // It successfully calls the method.
        h = softref.get();

        h.x();
    }
}

//Java Code to illustrate Weak reference
class Gfg
{
    //code
    public void x()
    {
        System.out.println("GeeksforGeeks");
    }
}