package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TagDBBean extends CommonDBBean {
	// Singleton
	private static TagDBBean instance = new TagDBBean();

	private TagDBBean() {
		}

	public static TagDBBean getInstance() {
		return instance;
	}

	public ArrayList<TagBean> tag(int idx) {
		ArrayList<TagBean> lists = new ArrayList<TagBean>();
		TagBean tag;
		Connection conn = getConnection();
		
		if (conn == null)
			return null;

		String sql = "select * from webSiteTag where idx=?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				tag = new TagBean(rs.getInt("idx"), rs.getString("tag"));
				lists.add(tag);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(conn);
		return lists;
	}
}
