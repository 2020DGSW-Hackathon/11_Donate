package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SiteDBBean extends CommonDBBean {
	// Singleton
	private static SiteDBBean instance = new SiteDBBean();

	private SiteDBBean() {
	}

	public static SiteDBBean getInstance() {
		return instance;
	}

	public ArrayList<SiteBean> show() {
		ArrayList<SiteBean> lists = new ArrayList<>();
		SiteBean site;
		Connection conn = getConnection();
		if (conn == null)
			return null;

		String sql = "select * from webSite;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				site = new SiteBean();
				site.setIdx(rs.getInt("idx"));
				site.setPicture(rs.getString("picture"));
				site.setSiteName(rs.getString("siteName"));
				site.setUrl(rs.getString("url"));
				
				lists.add(site);
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
