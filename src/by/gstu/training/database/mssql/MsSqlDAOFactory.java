package by.gstu.training.database.mssql;

import by.gstu.training.database.common.DaoFactory;
import by.gstu.training.database.common.dao.*;
import by.gstu.training.database.mssql.dao.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import static by.gstu.training.logers.MyLoger.LOGER;


public class MsSqlDAOFactory extends DaoFactory {
    public static final String DATA_SOURCE_NAME = "jdbc/touristAgency";
    private DataSource dataSource;


    public MsSqlDAOFactory(){
        super();
        dataSource = getDataSource(DATA_SOURCE_NAME);
    }


    private DataSource getDataSource(String dataSourceName ) {

            try {
                Context  context = new InitialContext();
                DataSource ds = (DataSource) context.lookup("java:comp/env/"+dataSourceName);

                return ds;
            } catch (NamingException e) {
                LOGER.error("Can't get context\n"+e.getMessage(),e);
                return null;
            }
    }

    @Override
    public AccountDao getAccountDao(){
        return new MsSqlAccountDao(dataSource);
    }

    @Override
    public AgencyDao getAgencyDao() {
        return new MsSqlAgencyDao(dataSource);
    }

    @Override
    public TourDao getTourDao() {
        return new MsSqlTourDao(dataSource);
    }

    @Override
    public TravelAgentDao getTravelAgentDao() {
        return new MsSqlTravelAgentDao(dataSource);
    }

    @Override
    public UserDao getUserDao() {
        return new MsSqlUserDao(dataSource);
    }


}

