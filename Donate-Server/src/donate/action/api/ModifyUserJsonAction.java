package donate.action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.ModifyUserDBBean;
import bean.ResultBean;
import bean.UserBean;
import donate.action.Action;

public class ModifyUserJsonAction implements Action {
	
	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Gson gson = new Gson();
		ResultBean result = new ResultBean(); // return�뿉 �뵲�씪 �떖�씪吏��뒗 遺�遺� 
		
		// input
		String str = IOUtils.toString(request.getReader());
		UserBean requestUser = gson.fromJson(str, UserBean.class); // input�뿉 �뵲�씪 �떖�씪吏��뒗 遺�遺� 
		
		System.out.println(requestUser.getUserId() + requestUser.getName() + requestUser.getEmail());
		int count = ModifyUserDBBean.getInstance().modifyUser(requestUser);
		if(count==1)
			result.result="ok";
		
		return gson.toJson(result, ResultBean.class);
	}

	
}
