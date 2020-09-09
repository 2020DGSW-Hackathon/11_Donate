package bean;

public class TagBean {
	private String tag;
	private int idx;

	public TagBean() {
	}

	public TagBean(String tag) {
		this.tag = tag;
	}
	
	public TagBean(int idx) {
		this.idx = idx;
	}

	public TagBean(int idx, String tag) {
		this.idx = idx;
		this.tag = tag;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
