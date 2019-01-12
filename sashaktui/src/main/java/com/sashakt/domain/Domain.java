package com.sashakt.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class Domain {

    @Id
    private long id;

    private String domain;

    private boolean displayAds;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public boolean isDisplayAds() {
		return displayAds;
	}

	public void setDisplayAds(boolean displayAds) {
		this.displayAds = displayAds;
	}

 
}
