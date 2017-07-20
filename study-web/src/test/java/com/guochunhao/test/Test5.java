package com.guochunhao.test;

/**
 * Created by count on 17/6/4.
 */
public class Test5
{
    public static void main(String[] args)
    {
        Apple apple = new Apple();

        Orange orange = new Orange();

        Apple apple1 = apple;

        System.out.println(apple.hashCode());

        System.out.println(apple1.hashCode());

        System.out.println(apple1.equals(apple));


    }

}

class Apple{}

class Orange{}
