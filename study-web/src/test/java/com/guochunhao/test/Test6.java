package com.guochunhao.test;

import java.util.ArrayList;

/**
 * Created by count on 17/6/4.
 */
public class Test6
{
    public static void main(String[] args)
    {
        ArrayList<A> list = new ArrayList<A>();
        list.add(new a());
        list.add(new b());
        list.add(new c());

        System.out.println(list);
    }
}

class A{}
class a extends A{}
class b extends A{}
class c extends A{}
