package by.gstu.training.database.common.utils;

import by.gstu.training.model.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.gstu.training.logers.MyLoger.LOGER;


public class DbDataConverter {

    public static User getUserFromResultSet(ResultSet rs) {
        if(rs==null) {
            LOGER.error("ResultSet is null.");
            return null;
        }


        try {

            int  id= rs.getInt("UserId");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            String phoneNumber = rs.getString("PhoneNumber");
            int passportNumber = rs.getInt("PassportNumber");
            String passportSeries = rs.getString("PassportSeries");

            return  new User(id,firstName,lastName,phoneNumber,passportNumber,passportSeries);
        } catch (SQLException e) {
            LOGER.error("Can't get data of User from column of ResultSet. \n Exception message: " + e.getMessage());
            return null;
        }
    }

    public static Account getAccountFromResultSet(ResultSet rs) {
        if(rs==null) {
            LOGER.error("ResultSet is null.");
            return null;
        }

        try {
            int  id= rs.getInt("AccountId");
            String login = rs.getString("Login");
            String password = rs.getString("Password");
            int accessLevel = rs.getInt("AccessLevel");
            int userId = rs.getInt("UserId");
            return  new Account(id,login,password,accessLevel,userId);

        } catch (SQLException e) {
            LOGER.error("Can't get data of Account from column of ResultSet. \n Exception message: " + e.getMessage());
            return null;
        }
    }

    public static TravelAgent getTravelAgentFromResultSet(ResultSet rs) {
        if(rs==null) {
            LOGER.error("ResultSet is null.");
            return null;
        }

        try {
            int  id= rs.getInt("TravelAgentId");
            int agencyId = rs.getInt("AgencyId");
            int accountId = rs.getInt("AccountId");
            double salary = rs.getInt("Salary");

            return  new TravelAgent(id,accountId,agencyId,salary);

        } catch (SQLException e) {
            LOGER.error("Can't get data of TravelAgent from column of ResultSet. \n Exception message: " + e.getMessage());
            return null;
        }
    }

    public static Agency getAgencyFromResultSet(ResultSet rs) {
        if(rs==null) {
            LOGER.error("ResultSet is null.");
            return null;
        }


        try {

            int  id= rs.getInt("AgencyId");
            String title = rs.getString("Title");
            String phoneNumber = rs.getString("PhoneNumber");

            return  new Agency(id,title,phoneNumber);
        } catch (SQLException e) {
            LOGER.error("Can't get data of Agency from column of ResultSet. \n Exception message: " + e.getMessage());
            return null;
        }
    }

    public static Tour getTourFromResultSet(ResultSet rs) {
        if(rs==null) {
            LOGER.error("ResultSet is null.");
            return null;
        }


        try {

            int  id= rs.getInt("TourId");
            String startDate = rs.getString("StartDate");
            String endDate = rs.getString("EndDate");
            double price = rs.getDouble("Price");
            String type = rs.getString("Type");
            int clientAccountId = rs.getInt("ClientAccountId");
            int travelAgentId = rs.getInt("TravelAgentId");

            return  new Tour(id,startDate,endDate,price,type,clientAccountId,travelAgentId);
        } catch (SQLException e) {
            LOGER.error("Can't get data of Tour from column of ResultSet. \n Exception message: " + e.getMessage(),e);
            return null;
        }
    }
}
