/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:31 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;

/**
 * JUnit test case for bean CarRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class CarRecordTest 
{
	private static final Logger LOGGER = Logger.getLogger(CarRecordTest.class.getName());
	@Test
	public void testSettersAndGetters() {
		
		LOGGER.info("Checking class CarRecord getters and setters ..." );
		
		CarRecord carRecord = new CarRecord();


		//--- Test setter/getter for attribute "id"  ( model type : int / wrapperType : Integer )
		carRecord.setId( 100 ) ;
		Assert.assertTrue(  100 == carRecord.getId()  ) ; // Primitive type in model


		//--- Test setter/getter for attribute "lastname"  ( model type : String / wrapperType : String )
		carRecord.setLastname( "A" ) ;
		Assert.assertEquals( "A", carRecord.getLastname() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "firstname"  ( model type : String / wrapperType : String )
		carRecord.setFirstname( "A" ) ;
		Assert.assertEquals( "A", carRecord.getFirstname() ) ; // Not primitive type in model


	}

}
