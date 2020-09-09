package donate.action.api;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.TagBean;
import bean.TagDBBean;
import donate.action.Action;

public class TagJsonAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Gson gson = new Gson();
		ArrayList<TagBean> list = new ArrayList<>();

		// input
		String str = IOUtils.toString(request.getReader());
		TagBean requestIdx = gson.fromJson(str, TagBean.class);

		TagDBBean db = TagDBBean.getInstance();
		ArrayList<TagBean> check = db.tag(requestIdx.getIdx());

		if (check != null) {
			list = check;
		}

		return gson.toJson(list).toString();
	}

}
