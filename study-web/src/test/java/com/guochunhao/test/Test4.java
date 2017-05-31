package com.guochunhao.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by count on 17/5/22.
 */
public class Test4
{

    public static String getName(Class<?> tClass)
    {

        char w = 'w';

        String s = "12";

        String guochunhao = "guochunhao";

        String method = "";
        try
        {
            Method getUsername = tClass.getMethod("getUsername");

            Method setUsername = tClass.getMethod("setUsername", String.class);

            Object object = tClass.newInstance();

            if (object instanceof Test3)
            {
                setUsername.invoke(object, "test3333333");
            }
            else
            {
                setUsername.invoke(object, "test2222222");
            }


            method = (String) getUsername.invoke(object);


        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        }

        return method;
    }


    public static void main(String[] args)
    {
        Test3 test3 = new Test3();
        test3.setSex("sex3333333");
        String name = getName(test3.getClass());

        System.out.println(name + ", " + test3.getSex());

        Test2 test2 = new Test2();
        test2.setSex("username");
        String name2 = getName(test2.getClass());
        System.out.println(name2 + ", " + test2.getSex());

        Test4 test4 = new Test4();





    }
    
}
