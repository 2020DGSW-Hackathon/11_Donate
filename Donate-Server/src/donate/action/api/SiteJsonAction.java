package donate.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.SiteBean;
import bean.SiteDBBean;
import donate.action.Action;

public class SiteJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Gson gson = new Gson();
		ArrayList<SiteBean> site = SiteDBBean.getInstance().show();
		
		return gson.toJson(site).toString();
	}

}
