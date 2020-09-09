package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VolunteerDBBean extends CommonDBBean{

	private static VolunteerDBBean instance = new VolunteerDBBean();
	
	private VolunteerDBBean() {
		
	}
	
	public static VolunteerDBBean getInstance() {
		return instance;
	}
	
	public ArrayList<VolunteerBean> show(){
		ArrayList<VolunteerBean> lists = new ArrayList<>();
		VolunteerBean volunteer;
		Connection conn = getConnection();
		if(conn== null)
			return null;
		
		String sql = "select * from volunteersite;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				volunteer = new VolunteerBean();
				
				volunteer.setIdx(rs.getInt("idx"));
				volunteer.setVolunteerName(rs.getString("volunteerName"));
				volunteer.setUrl(rs.getString("url"));
				volunteer.setPeriod(rs.getString("period"));
				volunteer.setPlace(rs.getString("place"));
				volunteer.setTag(rs.getString("tag"));
				
				lists.add(volunteer);
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
