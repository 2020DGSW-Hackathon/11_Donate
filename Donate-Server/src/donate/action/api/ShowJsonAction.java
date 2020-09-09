package donate.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.TagBean;
import bean.ShowDBBean;
import donate.action.Action;

public class ShowJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		ArrayList<TagBean> list = new ArrayList<>();
		
		// input
		String str = IOUtils.toString(request.getReader());
		TagBean requestTag = gson.fromJson(str, TagBean.class);
		
		ShowDBBean db = ShowDBBean.getInstance();
		ArrayList<TagBean> check = db.list(requestTag.getTag());
		
		if (check != null)
			list = check;

		return gson.toJson(list).toString();
	}

}
