import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;


public class Tfdf {
	@Test
	public void testGetAll() throws Exception {
		DaoFactory daoFactory = new MySqlDaoFactory();
		List<Group> list;
		try (Connection con = daoFactory.getConnection()) {
			GroupDao dao = daoFactory.getGroupDao(con);
			list = dao.getAll();
			for (Group e: list){
				System.out.println(e.getDepartment());
			}
		}
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
	}
}
