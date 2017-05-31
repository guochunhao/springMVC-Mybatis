package com.guochunhao.test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * Created by guochunhao on 17/4/13.
 */
public class Test
{
    public static void main(String[] args)
    {
        // 声明 connection 对象
        Connection connection;

        // 驱动名称
        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";

        String username = "ssm";

        String password = "123456";

        // 加载驱动类
        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

            if (!connection.isClosed())
            {
                Statement statement = connection.createStatement();
                String sql = "select * from user";

                ResultSet resultSet = statement.executeQuery(sql);

                while(resultSet.next())
                {
                    Field[] declaredFields = com.chunhao.study.model.user.User.class.getDeclaredFields();
                    for (Field field : declaredFields)
                    {
                        resultSet.getString(field.getName());

                        System.out.println(field.getName() + "：" + resultSet.getString(field.getName()));
                    }
                    
                    /*String id = resultSet.getString("id");
                    String name = resultSet.getString("username");
                    String birthday = resultSet.getString("birthday");
                    String sex = resultSet.getString("sex");
                    String address = resultSet.getString("address");

                    System.out.println(id + " " + name + " " + birthday + " " + sex + " " + address);*/

                }

                resultSet.close();
                connection.close();

            }

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    class User
    {
        String id;
        String username;
        String birthday;
        String sex;
        String address;

        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public String getUsername()
        {
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }

        public String getBirthday()
        {
            return birthday;
        }

        public void setBirthday(String birthday)
        {
            this.birthday = birthday;
        }

        public String getSex()
        {
            return sex;
        }

        public void setSex(String sex)
        {
            this.sex = sex;
        }

        public String getAddress()
        {
            return address;
        }

        public void setAddress(String address)
        {
            this.address = address;
        }
    }
}
