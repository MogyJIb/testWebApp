package by.gstu.training;

import by.gstu.training.database.common.queries.SqlPreparedQuery;
import by.gstu.training.model.Account;
import by.gstu.training.database.common.utils.DbConnectionUtil;
import by.gstu.training.database.common.utils.DbDataConverter;
import by.gstu.training.model.Agency;
import by.gstu.training.model.Tour;
import by.gstu.training.model.TravelAgent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static by.gstu.training.logers.MyLoger.LOGER;


public class TestRunner {
    public final static SqlPreparedQuery PREPARED_QUERIES = SqlPreparedQuery.TOURS;

    public static final String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DbUrl = "jdbc:sqlserver://DESKTOP-QUKU3SI\\SQLEXPRESS;database=touristAgency";
    public static final String username="zhecka";
    public static final String password="zhecka";

    static Logger logger = LogManager.getLogger(TestRunner.class.getName());
    public static void main(String[] args){
        try {
            Class.forName(DriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DbUrl,username,password);
            PreparedStatement prSt = DbConnectionUtil.getPrepareStatement(connection,PREPARED_QUERIES.SELECT_ALL);
            ResultSet rs = null;
            try {


                rs = prSt.executeQuery();
                rs.next();
                Tour user = (DbDataConverter.getTourFromResultSet(rs));
                System.out.println(user);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                LOGER.error("Can't create ResultSet. \n Exception message: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
