/*
 * cloudstore - mozanta
 *
 * Copyright 2015 Mozanta Technologies All Rights Reserved.
 */
package com.mozanta.store.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sites")
public class Site {

	public Site() {

	}

	public Site(String id, String name) {
		siteId = id;
		siteName = name;
	}

	@Id
	private String siteId;

	private String siteName;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
}
