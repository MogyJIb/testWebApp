package by.gstu.training.database.mssql.dao;

import by.gstu.training.database.common.dao.TourDao;
import by.gstu.training.database.mssql.AbstractMsSqlDao;
import by.gstu.training.database.common.queries.SqlPreparedQuery;
import by.gstu.training.model.Tour;
import by.gstu.training.database.common.utils.DbDataConverter;

import javax.sql.DataSource;
import java.sql.ResultSet;

public class MsSqlTourDao  extends AbstractMsSqlDao<Tour> implements TourDao {

    public MsSqlTourDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected Tour getEntityFromResultSet(ResultSet resultSet) {
        return DbDataConverter.getTourFromResultSet(resultSet);
    }

    @Override
    protected SqlPreparedQuery getSqlPreparedQuery() {
        return SqlPreparedQuery.TOURS;
    }
}
