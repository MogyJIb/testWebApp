package by.gstu.training.database.common.queries;

public class SqlPreparedQuery {
    public final static SqlPreparedQuery USERS =
            new SqlPreparedQuery("Users","(?,?,?,?,?,?)","UserId");
    public final static SqlPreparedQuery ACCOUNTS =
            new SqlPreparedQuery("Accounts","(?,?,?,?,?)","AccountId");
    public final static SqlPreparedQuery TOURS =
            new SqlPreparedQuery("Tours","(?,?,?,?,?,?,?)","TourId");
    public final static SqlPreparedQuery AGENCIES =
            new SqlPreparedQuery("Agencies","(?,?,?)","AgencyId");
    public final static SqlPreparedQuery TRAVELAGENTS =
            new SqlPreparedQuery("TravelAgents","(?,?,?,?)","TravelAgentId");


    private String tableName;
    private String values;
    private String idColumnName;

    public String SELECT_ALL;
    public String SELECT_BY_ID;

    public SqlPreparedQuery(String tableName, String values,String idColumnName) {
        this.tableName = tableName;
        this.values = values;
        this.idColumnName = idColumnName;
        makeQueries();

    }

    public void makeQueries(){
        SELECT_ALL = "SELECT * FROM "+tableName;
        SELECT_BY_ID = "SELECT * FROM "+tableName+" WHERE "+idColumnName+" = ?";
    }

    public String getTableName() {
        return tableName;
    }

    public String getValues() {
        return values;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getIdColumnName() {
        return idColumnName;
    }

    public void setIdColumnName(String idColumnName) {
        this.idColumnName = idColumnName;
    }

}
