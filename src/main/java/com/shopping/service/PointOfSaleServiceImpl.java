/**
 * 
 */
package com.shopping.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.shopping.dto.PriceData;

/**
 * PointOfSaleService Implementation
 * 
 * @author 91859
 * 
 */
public class PointOfSaleServiceImpl implements PointOfSaleService {

	/**
	 * Calculates total price for the scanned items
	 * @param List of String with product codes
	 * @exception Exception
	 * @return BigDecimal
	 */
	public BigDecimal calculateTotal(List<String> scannedProducts) throws Exception {

		/*<<<< Products and Pricing Structutre hardcoded >>>>> */
		/* PriceData (unitPrice, GroupCount,GroupPrice) */
		HashMap<String, PriceData> pricing = new HashMap<String, PriceData>();
		pricing.put("A1", new PriceData(1.25, 3, 3));
		pricing.put("3-Q", new PriceData(4.25, 1, 4.25));
		pricing.put("45K11", new PriceData(1, 6, 5));
		pricing.put("X1", new PriceData(0.755, 1, 0.75));
		/*<<<< Products and Pricing Structutre hardcoded >>>>> */
		
		PriceData curPriceData;
		BigDecimal totalPrice = new BigDecimal(0);

		Map<Object, Long> counts = scannedProducts.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		for (Entry<Object, Long> entry : counts.entrySet()) {
			curPriceData = pricing.get(entry.getKey());
			if (null == curPriceData)
				throw new Exception("Error! Couldn't load price for Product with code " + entry.getKey());
			totalPrice = totalPrice
					.add(new BigDecimal((entry.getValue() % curPriceData.getGroupCount()) * curPriceData.getUnitPrice()
							+ ((entry.getValue() / curPriceData.getGroupCount()) * curPriceData.getGroupPrice())));

		}
		totalPrice.setScale(2, RoundingMode.CEILING);
		return totalPrice;
	}

}
