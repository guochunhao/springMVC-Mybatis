package com.guochunhao.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by count on 17/6/16.
 */
public class TestLock
{
    private Map<Integer, Integer> lockMap = new HashMap<Integer, Integer>();

    public TestLock()
    {
        Thread thread1 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread1 over");
            }
        };

        Thread thread2 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread2 over");
            }
        };

        Thread thread3 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread3 over");
            }
        };

        Thread thread4 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread3 over");
            }
        };

        Thread thread5 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread5 over");
            }
        };

        Thread thread6 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread6 over");
            }
        };

        Thread thread7 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread7 over");
            }
        };

        Thread thread8 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread8 over");
            }
        };

        Thread thread9 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread9 over");
            }
        };

        Thread thread10 = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5000; i++)
                {
                    lockMap.put(new Integer(i), i);
                }

                System.out.println("thread10 over");
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }

    public static void main(String[] args) {
        new TestLock();

        System.out.println(1 << 4);
    }
}
