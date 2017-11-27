package connection;

public class SqlQuery {
	public static final String SELECT_All = "SELECT * FROM [dbo].JDBC";
	public static final String INSERT = "INSERT INTO [dbo].JDBC VALUES(?, ?, ?, ?)";
	public static final String UPDATE = "UPDATE [dbo].JDBC SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? WHERE ACCOUNT = ?";
	public static final String SELECT_BY_ACCOUNT = "SELECT * FROM [dbo].JDBC WHERE ACCOUNT = ?";
}
