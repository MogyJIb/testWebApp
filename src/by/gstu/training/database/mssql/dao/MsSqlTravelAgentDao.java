package by.gstu.training.database.mssql.dao;

import by.gstu.training.database.common.dao.TravelAgentDao;
import by.gstu.training.database.mssql.AbstractMsSqlDao;
import by.gstu.training.database.common.queries.SqlPreparedQuery;
import by.gstu.training.model.TravelAgent;
import by.gstu.training.database.common.utils.DbDataConverter;

import javax.sql.DataSource;
import java.sql.ResultSet;

public class MsSqlTravelAgentDao  extends AbstractMsSqlDao<TravelAgent> implements TravelAgentDao{

    public MsSqlTravelAgentDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected TravelAgent getEntityFromResultSet(ResultSet resultSet) {
        return DbDataConverter.getTravelAgentFromResultSet(resultSet);
    }

    @Override
    protected SqlPreparedQuery getSqlPreparedQuery() {
        return SqlPreparedQuery.TRAVELAGENTS;
    }
}
