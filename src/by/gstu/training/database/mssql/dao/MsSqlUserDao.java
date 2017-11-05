package by.gstu.training.database.mssql.dao;

import by.gstu.training.database.common.dao.UserDao;
import by.gstu.training.database.mssql.AbstractMsSqlDao;
import by.gstu.training.database.common.queries.SqlPreparedQuery;
import by.gstu.training.model.User;
import by.gstu.training.database.common.utils.DbDataConverter;

import javax.sql.DataSource;
import java.sql.ResultSet;


public class MsSqlUserDao  extends AbstractMsSqlDao<User> implements UserDao {

    public MsSqlUserDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) {
        return DbDataConverter.getUserFromResultSet(resultSet);
    }

    @Override
    protected SqlPreparedQuery getSqlPreparedQuery() {
        return SqlPreparedQuery.USERS;
    }
}
