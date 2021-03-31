/**
 * 
 */
package com.shopping.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * PointOfSaleServiceImplTest - Test class 
 * @author 91859
 *
 */
public class PointOfSaleServiceImplTest {

	@Test
	public void calculateTotaltest() {
		
		List<String> testProducts = new ArrayList<String>(); 
		testProducts.add("A1");
		testProducts.add("3-Q");
		testProducts.add("45K11");
		testProducts.add("X1");
		testProducts.add("A1");
		testProducts.add("3-Q");
		testProducts.add("A1");
		
		BigDecimal total = new BigDecimal(0);
		PointOfSaleServiceImpl testTerminal = new PointOfSaleServiceImpl();
		try {
			total = testTerminal.calculateTotal(testProducts);
		} catch (Exception e) {
			fail();
		}
		assertEquals(new BigDecimal(13.25), total);
	}
	
	@Test
	public void calculateInvalidTotaltest() {
		
		List<String> testProducts = new ArrayList<String>(); 
		testProducts.add("A1");
		testProducts.add("3-Q");
		testProducts.add("45K11");
		testProducts.add("X1");
		testProducts.add("A1");
		testProducts.add("3-Q");
		testProducts.add("QQQ");
		
		BigDecimal total = new BigDecimal(0);
		PointOfSaleServiceImpl testTerminal = new PointOfSaleServiceImpl();
		try {
			total = testTerminal.calculateTotal(testProducts);
		} catch (Exception e) {
			assertTrue("Error! Couldn't load price for Product with code QQQ".equals(e.getLocalizedMessage()));
		}
		
	}

}
