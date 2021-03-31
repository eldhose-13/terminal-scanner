/**
 * 
 */
package com.shopping.service;

import java.math.BigDecimal;
import java.util.List;

/**
 * PointOfSaleService Interface
 * @author 91859
 * 
 */
public interface PointOfSaleService {

	/**
	 * Calculates total price for
	 * the scanned items
	 * @param List of String with
	 * product codes
	 * @exception  Exception
	 * @return BigDecimal
	 */
	public BigDecimal calculateTotal(List<String> scannedProducts) throws Exception;
}
