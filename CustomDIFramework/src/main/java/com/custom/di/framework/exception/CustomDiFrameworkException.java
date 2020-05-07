/**
 * 
 */
package com.custom.di.framework.exception;

import com.custom.di.framework.constant.ErrorConstants;

/**
 * @author mahesh
 *
 */
public class CustomDiFrameworkException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomDiFrameworkException() {
		super();
	}

	public CustomDiFrameworkException(ErrorConstants errorConstants, Throwable cause) {
		super(errorConstants.getErrorString(), cause);
	}

	public CustomDiFrameworkException(ErrorConstants errorConstants) {
		super(errorConstants.getErrorString());
	}

}
