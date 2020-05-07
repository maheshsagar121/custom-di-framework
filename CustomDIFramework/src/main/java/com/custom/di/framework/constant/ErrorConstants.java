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
	BEANS_LIST_EMPTY("Error: Bean list is empty for register."),
	BEAN_INIT_ERROR("Error: Bean can not initialise"),
	INPUT_PARAMETER_IS_NULL("Error: Input parameter is null"),
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
