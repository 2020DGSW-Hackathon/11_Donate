package bean;

public class VolunteerBean {
	private int idx;
	private String volunteerName;
	private String url;
	private String period;
	private String place;
	private String tag;
	
public VolunteerBean() {}
	
	public VolunteerBean(int idx, String volunteerName, String url, String period, String place, String tag) {
		this.idx = idx;
		this.volunteerName = volunteerName;
		this.url = url;
		this.period = period;
		this.place = place;
		this.tag = tag;
	}

	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getVolunteerName() {
		return volunteerName;
	}

	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
