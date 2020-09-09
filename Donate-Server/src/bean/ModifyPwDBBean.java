package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyPwDBBean extends CommonDBBean{

	private static ModifyPwDBBean instance = new ModifyPwDBBean();
	
	private ModifyPwDBBean() {
		
	}
	
	public static ModifyPwDBBean getInstance() {
		return instance;
	}
	
	public int modifyPw(UserBean user) {
		int result = 0;
		Connection conn = getConnection();
		if(conn == null)
			return 0;
		
		String sql = "update user Set password =? where userid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, user.getUserId());
			pstmt.setString(1, user.getPassword());
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
