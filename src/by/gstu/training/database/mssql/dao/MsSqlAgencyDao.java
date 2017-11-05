package by.gstu.training.database.mssql.dao;

import by.gstu.training.database.common.dao.AgencyDao;
import by.gstu.training.database.mssql.AbstractMsSqlDao;
import by.gstu.training.database.common.queries.SqlPreparedQuery;
import by.gstu.training.model.Agency;
import by.gstu.training.database.common.utils.DbDataConverter;

import javax.sql.DataSource;
import java.sql.ResultSet;

public class MsSqlAgencyDao extends AbstractMsSqlDao<Agency> implements AgencyDao {

    public MsSqlAgencyDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected Agency getEntityFromResultSet(ResultSet resultSet) {
        return DbDataConverter.getAgencyFromResultSet(resultSet);
    }

    @Override
    protected SqlPreparedQuery getSqlPreparedQuery() {
        return SqlPreparedQuery.AGENCIES;
    }
}
