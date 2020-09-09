package donate.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.DonateSiteDBBean;
import bean.SiteBean;
import donate.action.Action;

public class DonateSiteJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Gson gson = new Gson();
		ArrayList<SiteBean> site = DonateSiteDBBean.getInstance().show();
		
		return gson.toJson(site).toString();
	}
}
