package by.gstu.training.database.mssql;

import by.gstu.training.database.common.AbstractDao;
import by.gstu.training.database.common.queries.SqlPreparedQuery;
import by.gstu.training.model.Entity;
import by.gstu.training.database.common.utils.DbConnectionUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.gstu.training.logers.MyLoger.LOGER;

public abstract class AbstractMsSqlDao<T extends Entity> implements AbstractDao<Integer,T> {
    private SqlPreparedQuery PREPARED_QUERIES ;
    private DataSource dataSource;

    public AbstractMsSqlDao(DataSource dataSource ) {
        this.dataSource = dataSource;
        PREPARED_QUERIES = getSqlPreparedQuery();
    }

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();


        Connection cn = DbConnectionUtil.getConnection(dataSource);
        PreparedStatement pst = DbConnectionUtil.getPrepareStatement(cn,PREPARED_QUERIES.SELECT_ALL);
        ResultSet rs = null;
        try {

            rs = pst.executeQuery();
            while (rs.next())
                entities.add(getEntityFromResultSet(rs));

        } catch (SQLException e) {
            LOGER.error("Can't create ResultSet. \n Exception message: " + e.getMessage());
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    LOGER.error("Can't close ResultSet.\n Exception message: " + e.getMessage());
                }
        }

        DbConnectionUtil.closePrepareStatement(pst);
        DbConnectionUtil.closeConnection(cn);

        return entities;
    }

    @Override
    public T find(Integer id) {
        T entity = null;


        Connection cn = DbConnectionUtil.getConnection(dataSource);
        PreparedStatement pst = DbConnectionUtil.getPrepareStatement(cn,PREPARED_QUERIES.SELECT_ALL);
        ResultSet rs = null;
        try {
            pst.setInt(1,id);
            rs = pst.executeQuery();
            rs.next();
            entity = getEntityFromResultSet(rs);

        } catch (SQLException e) {
            LOGER.error("Can't create ResultSet. \n Exception message: " + e.getMessage());
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    LOGER.error("Can't close ResultSet.\n Exception message: " + e.getMessage());
                }
        }

        DbConnectionUtil.closePrepareStatement(pst);
        DbConnectionUtil.closeConnection(cn);

        return entity;
    }

    protected abstract T getEntityFromResultSet(ResultSet resultSet);
    protected abstract SqlPreparedQuery getSqlPreparedQuery();
}
