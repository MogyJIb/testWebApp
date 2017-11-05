package by.gstu.training.database.mssql.dao;

import by.gstu.training.database.common.dao.AccountDao;
import by.gstu.training.database.mssql.AbstractMsSqlDao;
import by.gstu.training.database.common.queries.SqlPreparedQuery;
import by.gstu.training.model.Account;
import by.gstu.training.database.common.utils.DbDataConverter;

import javax.sql.DataSource;
import java.sql.ResultSet;

public class MsSqlAccountDao extends AbstractMsSqlDao<Account> implements AccountDao {
    public MsSqlAccountDao(DataSource dataSource) {
        super(dataSource);
    }


    @Override
    protected Account getEntityFromResultSet(ResultSet resultSet) {
        return DbDataConverter.getAccountFromResultSet(resultSet);
    }

    @Override
    protected SqlPreparedQuery getSqlPreparedQuery() {
        return SqlPreparedQuery.ACCOUNTS;
    }
}
