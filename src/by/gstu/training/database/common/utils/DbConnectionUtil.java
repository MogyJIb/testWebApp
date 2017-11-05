package by.gstu.training.database.common.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.gstu.training.logers.MyLoger.LOGER;

public class DbConnectionUtil {
    public static PreparedStatement getPrepareStatement(Connection connection, String sqlQuery){
        try {
            return connection.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            LOGER.error("Can't create Statement. Exception message: " + e.getMessage(), e);
            return null;
        }
    }
    public static void closePrepareStatement(PreparedStatement st){
        if (st != null)
            try {
                st.close();
            } catch (SQLException e) {
                LOGER.error("Can't close PreparedStatement. Exception message: " + e.getMessage(), e);
            }
    }
    public static Connection getConnection(DataSource dataSource) {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGER.error("Can't get Connection. Exception message: " + e.getMessage(), e);
            return null;
        }
    }
    public static void closeConnection(Connection connection) {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                LOGER.error("Can't close Connection. Exception message: " + e.getMessage(), e);
            }
    }

}
