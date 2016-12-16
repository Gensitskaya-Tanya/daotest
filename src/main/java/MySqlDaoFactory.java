import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements DaoFactory {

	private String user = "root";//Логин пользователя
	private String password = "root";//Пароль пользователя
	private String url = "jdbc:mysql://localhost:3306/daotalk";//URL адрес
	private String driver = "com.mysql.jdbc.Driver";//Имя драйвера

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public GroupDao getGroupDao(Connection connection) {
		return new MySqlGroupDao(connection);
	}



	public MySqlDaoFactory() {
		try {
			Class.forName(driver);//Регистрируем драйвер
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
