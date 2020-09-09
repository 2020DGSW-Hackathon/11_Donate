package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowDBBean extends CommonDBBean {
	// Singleton
	private static ShowDBBean instance = new ShowDBBean();

	private ShowDBBean() {
	}

	public static ShowDBBean getInstance() {
		return instance;
	}

	public ArrayList<TagBean> list(String tag) {
		ArrayList<TagBean> lists = new ArrayList<>();
		TagBean idx;
		Connection conn = getConnection();
		if (conn == null)
			return null;

		String sql = "select * from webSiteTag where tag=?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				idx = new TagBean(rs.getInt("idx"), rs.getString("tag"));
				lists.add(idx);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection(conn);
		return lists;
	}
}
