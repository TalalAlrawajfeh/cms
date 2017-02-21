package beans;

import java.util.Optional;

public class Site {
	private String uri;
	private String name;
	private Site parentSite;
	private Page landingPage;

	public Site() {
		/* default constructor */
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Site getParentSite() {
		return parentSite;
	}

	public void setParentSite(Site parentSite) {
		this.parentSite = parentSite;
	}

	public Page getLandingPage() {
		return landingPage;
	}

	public void setLandingPage(Page landingPage) {
		this.landingPage = landingPage;
	}

	@Override
	public String toString() {
		return "Site [uri=" + uri + ", name=" + name + ", parentSite=" + parentSite + ", landingPage="
				+ Optional.ofNullable(landingPage).map(l -> l.getUri()).orElse("none") + "]";
	}
}