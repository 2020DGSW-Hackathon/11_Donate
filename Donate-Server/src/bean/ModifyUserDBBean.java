package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyUserDBBean extends CommonDBBean {

	private static ModifyUserDBBean instance = new ModifyUserDBBean();
	
	private ModifyUserDBBean() {
		
	}
	
	public static ModifyUserDBBean getInstance() {
		return instance;
	}
	
	public int modifyUser(UserBean user) {
		int result = 0;
		Connection conn = getConnection();
		if(conn == null)
			return 0;
		
		String sql = "update user Set name =?, email=? where userid = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getUserId());
			result = pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection(conn);
		return result;
	}
}
