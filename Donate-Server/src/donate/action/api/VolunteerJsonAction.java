package donate.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.VolunteerBean;
import bean.VolunteerDBBean;
import donate.action.Action;

public class VolunteerJsonAction implements Action{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Gson gson = new Gson();
		ArrayList<VolunteerBean> volunteer = VolunteerDBBean.getInstance().show();
		
		return gson.toJson(volunteer).toString();
	}

}
