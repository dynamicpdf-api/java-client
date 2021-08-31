package com.dynamicpdf.api;

/**
 * Represents an action linking to an external URL.
 */
public class UrlAction extends Action {

	String url;

	/**
	 * Initializes a new instance of the <code>UrlAction</code> class.
	 * @param url URL the action launches.
	 */
	public UrlAction(String url) {
		this.url = url;
	}

	/**
	 * Gets the URL launched by the action.
	 * @return The URL launched by the action.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the URL launched by the action.
	 * @param url The URL launched by the action.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
