package com.dynamicpdf.api;

/**
 * Represents the exception that occurs in case of any issues with sending the request.
 */

public class EndpointException extends RuntimeException {

	/**
	 * Initializes a new instance of the <code>EndpointException</code> class.
	 * @param message Message of end point exception.
	 */
	public EndpointException(String message) {
		super(message);
	}
}
