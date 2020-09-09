package bean;

public class SiteBean {
	private int idx;
	private String siteName;
	private String url;
	private String picture;
	
	public SiteBean() {}
	
	public SiteBean(int idx, String siteName, String url, String picture) {
		this.idx = idx;
		this.siteName = siteName;
		this.url = url;
		this.picture = picture;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
