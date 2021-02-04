package csdn.fruitmarket.DaoImpl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.sun.xml.internal.bind.v2.runtime.output.FastInfosetStreamWriterOutput;
import csdn.fruitmarket.Dao.FruitDao;
import csdn.fruitmarket.model.Fruit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FruitJDBCDaoImpl implements FruitDao {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final String DB_URL = "jdbc:mysql://localhost:5431/mysqldb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";

    @Override
    public int save(Fruit fruit) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int exe = 0;
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            String SQL_ADD = "insert into fruit (name,price,unit) values (?,?,?)";
            preparedStatement = conn.prepareStatement(SQL_ADD);
            preparedStatement.setString(1,fruit.getName());
            preparedStatement.setString(2,String.valueOf(fruit.getPrice()));
            preparedStatement.setString(3,fruit.getUnit());

            exe = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement!=null){preparedStatement.close();}
                if (conn!=null){conn.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return exe;
    }

    @Override
    public List<Fruit> getFruit() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        List<Fruit> fruits = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            stmt= conn.createStatement();
            String SQL_QUERY = "select * from fruit";
            res  = stmt.executeQuery(SQL_QUERY);
            while(res.next()){
                int id= res.getInt("id");
                String name = res.getString("name");
                String price =res.getString("price");
                String unit = res.getString("unit");

                Fruit fruit = new Fruit();
                fruit.setNumber(id);
                fruit.setName(name);
                fruit.setPrice(Double.parseDouble(price));
                fruit.setUnit(unit);
                fruits.add(fruit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (res!=null)res.close();
                if (stmt!=null){stmt.close();}
                if (conn!=null){conn.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return fruits;
    }

    @Override
    public int delete(Fruit fruit) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int exe =0;
        try {
            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            String SQL_DELETE= "delete from fruit where id=?";
            preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1,fruit.getNumber());
            exe=preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement!=null){preparedStatement.close();}
                if (conn!=null){conn.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return exe;
    }

    @Override
    public int update(Fruit fruit) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int exe =0;
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            String SQL_UPDATE = "update fruit set name=?, price=?, unit=? where id=?";
            preparedStatement = conn.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,fruit.getName());
            preparedStatement.setString(2,String.valueOf(fruit.getPrice()));
            preparedStatement.setString(3,fruit.getUnit());
            preparedStatement.setInt(4,fruit.getNumber());

            exe=preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement!=null){preparedStatement.close();}
                if(conn!=null){conn.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return exe;
    }

    @Override
    public Fruit getFruitById(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Fruit fruit = null;
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            stmt = conn.createStatement();
            String SQL_BYID = "select * from fruit";
            rs=stmt.executeQuery(SQL_BYID);
            while (rs.next()){
                if (rs.getInt("id")==id){
                    fruit = new Fruit(id,rs.getString("name"),Double.parseDouble(rs.getString("price")),rs.getString("unit"));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs!=null)rs.close();
                if (stmt!=null)stmt.close();
                if (conn!=null)conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return fruit;
    }

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitJDBCDaoImpl();
        Fruit fruit = fruitDao.getFruitById(7);
        fruit.setName("ifUpdate");

        fruitDao.update(fruit);

    }
}
