package csdn.JDBCDao;

import csdn.model.MySQLObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLExJDBC {
    private static final String DB_URL = "jdbc:mysql://localhost:5431/mysqldb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";

    public int save(MySQLObject mySQLObject){
        int result=0;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            String SQL_INSERT = "insert into users(name,password,email,birthday) values(?,?,?,?)";
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,mySQLObject.getName());
            preparedStatement.setString(2,mySQLObject.getPassword());
            preparedStatement.setString(3,mySQLObject.getEmail());
            preparedStatement.setDate(4,mySQLObject.getDate());

            result = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }finally {
            try {
                if (preparedStatement!=null)preparedStatement.close();
                if (conn!=null)conn.close();
            }catch (Exception e){
                e.getMessage();
            }
        }
        System.out.println(result);
        return result;
    }

    public List<MySQLObject> getAll(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MySQLObject> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            String SQL_GET = "select * from users";
            preparedStatement = conn.prepareStatement(SQL_GET);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");


                MySQLObject mySQLObject = new MySQLObject();
                mySQLObject.setId(id);
                mySQLObject.setName(name);
                mySQLObject.setPassword(password);
                mySQLObject.setEmail(email);
                mySQLObject.setDate(birthday);

                list.add(mySQLObject);
            }
        }catch (Exception e){
            e.getMessage();
        }finally {
            try {
                if (resultSet!=null){resultSet.close();}
                if (preparedStatement!=null){preparedStatement.close();}
                if (conn!=null){conn.close();}
            }catch (Exception e){
                e.getMessage();
            }
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        MySQLExJDBC mySQLExJDBC = new MySQLExJDBC();
        List<MySQLObject> list = mySQLExJDBC.getAll();

    }

}

