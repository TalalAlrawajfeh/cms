package beans;

import java.io.Serializable;
import java.util.Optional;

@SuppressWarnings("serial")
public class Page implements Serializable {
	private String uri;
	private String title;
	private Boolean isHtml;
	private String seo;
	private String content;
	private Site site;

	public Page() {
		/* default constructor */
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsHtml() {
		return isHtml;
	}

	public void setIsHtml(Boolean isHtml) {
		this.isHtml = isHtml;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Page [uri=" + uri + ", title=" + title + ", isHtml=" + isHtml + ", seo=" + seo + ", content=" + content
				+ ", site=" + Optional.ofNullable(site).map(s -> s.getUri()).orElse("none") + "]";
	}
}
