package com.shopping.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.shopping.service.PointOfSaleServiceImpl;

/**
 * PointOfSaleTerminal - Terminal  Interface to call 
 * the Point of sale service API
 * @author 91859
 *
 */
public class PointOfSaleTerminal {
	
	private PointOfSaleServiceImpl pointOfService = new PointOfSaleServiceImpl();
	
	private List<String> scannedProducts = new ArrayList<>();
	
	public void scanProduct(String prodCode) {
		scannedProducts.add(prodCode);
	}
	
	public BigDecimal calculateTotal() throws Exception {
		return pointOfService.calculateTotal(scannedProducts);
	}

}
