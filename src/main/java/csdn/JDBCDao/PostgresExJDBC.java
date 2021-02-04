package csdn.JDBCDao;


import csdn.model.PostgresObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresExJDBC {
    //private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String DB_URL = "jdbc:postgresql://localhost:8888/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "123456";

    public PostgresObject save(PostgresObject postgresObject){
        PostgresObject createObject = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String SQL_INSERT = "insert into test_use (name) values(?)";
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, postgresObject.getName());
            int row = preparedStatement.executeUpdate();
            if (row>0)
                createObject = postgresObject;
        }catch (SQLException e){
            e.getMessage();
        }finally {
            try {
                if (preparedStatement!=null)preparedStatement.close();
                if (conn!=null)conn.close();
            }catch (Exception e){
                e.getMessage();
            }
        }
        return createObject;
    }

    public static void main(String[] args) {
        PostgresObject object = new PostgresObject();
        object.setName("testUse");
        PostgresExJDBC postgresExJDBC = new PostgresExJDBC();
        postgresExJDBC.save(object);
    }

}
