package beans;

import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("serial")
public class SiteSettings implements Serializable {
	private String deliveryUrl;
	private String name;
	private byte[] logo;

	public SiteSettings() {
		/* default constructor */
	}

	public String getDeliveryUrl() {
		return deliveryUrl;
	}

	public void setDeliveryUrl(String deliveryUrl) {
		this.deliveryUrl = deliveryUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "SiteSettings [deliveryUrl=" + deliveryUrl + ", name=" + name + ", logo=" + Arrays.toString(logo) + "]";
	}
}
