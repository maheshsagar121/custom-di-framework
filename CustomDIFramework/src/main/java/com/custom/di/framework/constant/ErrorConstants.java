/**
 * 
 */
package com.custom.di.framework.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mahesh
 *
 */
public enum ErrorConstants {

	DUPLICATE_BEAN_EXCEPTION("Error: Duplicate bean found while initialising bean."),
	CLASS_NOT_FOUND_EXCEPTION("Error: Class not found while registering the bean.");

	private String errorString;

	ErrorConstants(String errorString) {
		this.errorString = errorString;
	}

	public String getErrorString() {
		return errorString;
	}

	private static final Map<String, ErrorConstants> lookup = new HashMap<>();

	static {
		for (ErrorConstants errorConstants : ErrorConstants.values()) {
			lookup.put(errorConstants.getErrorString(), errorConstants);
		}
	}

	public static ErrorConstants get(String errorString) {
		return lookup.get(errorString);
	}

}
