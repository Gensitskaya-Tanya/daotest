import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlGroupDao implements GroupDao {
	private final Connection connection;

	@Override
	public Group create() {
		return null;
	}

	@Override
	public Group read(int key) throws SQLException {
		String sql = "SELECT * FROM daotalk.Group WHERE id = ?;";
		PreparedStatement stm = connection.prepareStatement(sql);

		stm.setInt(1, key);

		ResultSet rs = stm.executeQuery();
		rs.next();
		Group g = new Group();
		g.setId(rs.getInt("id"));
		g.setNumber(rs.getInt("number"));
		g.setDepartment(rs.getString("department"));
		return g;
	}

	@Override
	public void update(Group group) {

	}

	@Override
	public void delete(Group group) {

	}

	@Override
	public List<Group> getAll() throws SQLException {
		String sql = "SELECT * FROM daotalk.Group;";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Group> list = new ArrayList<Group>();
		while (rs.next()) {
			Group g = new Group();
			g.setId(rs.getInt("id"));
			g.setNumber(rs.getInt("number"));
			g.setDepartment(rs.getString("department"));
			list.add(g);
		}
		return list;
	}

	public MySqlGroupDao(Connection connection) {
		this.connection = connection;
	}
}
