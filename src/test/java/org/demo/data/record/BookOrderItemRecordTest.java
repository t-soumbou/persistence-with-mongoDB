/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:46 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;

/**
 * JUnit test case for bean BookOrderItemRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class BookOrderItemRecordTest 
{
	private static final Logger LOGGER = Logger.getLogger(BookOrderItemRecordTest.class.getName());
	@Test
	public void testSettersAndGetters() {
		
		LOGGER.info("Checking class BookOrderItemRecord getters and setters ..." );
		
		BookOrderItemRecord bookOrderItemRecord = new BookOrderItemRecord();


		//--- Test setter/getter for attribute "bookOrderId"  ( model type : Integer / wrapperType : Integer )
		bookOrderItemRecord.setBookOrderId( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), bookOrderItemRecord.getBookOrderId() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "bookId"  ( model type : Integer / wrapperType : Integer )
		bookOrderItemRecord.setBookId( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), bookOrderItemRecord.getBookId() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "quantity"  ( model type : Integer / wrapperType : Integer )
		bookOrderItemRecord.setQuantity( Integer.valueOf(100) ) ;
		Assert.assertEquals( Integer.valueOf(100), bookOrderItemRecord.getQuantity() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "price"  ( model type : BigDecimal / wrapperType : BigDecimal )
		bookOrderItemRecord.setPrice( java.math.BigDecimal.valueOf(10000) ) ;
		Assert.assertEquals( java.math.BigDecimal.valueOf(10000), bookOrderItemRecord.getPrice() ) ; // Not primitive type in model


	}

}
