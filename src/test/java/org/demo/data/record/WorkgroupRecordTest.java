/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:47 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;


import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;

/**
 * JUnit test case for bean WorkgroupRecord
 * 
 * @author Telosys Tools Generator
 *
 */
public class WorkgroupRecordTest 
{
	private static final Logger LOGGER = Logger.getLogger(WorkgroupRecordTest.class.getName());
	@Test
	public void testSettersAndGetters() {
		
		LOGGER.info("Checking class WorkgroupRecord getters and setters ..." );
		
		WorkgroupRecord workgroupRecord = new WorkgroupRecord();


		//--- Test setter/getter for attribute "id"  ( model type : Short / wrapperType : Short )
		workgroupRecord.setId( Short.valueOf((short)1) ) ;
		Assert.assertEquals( Short.valueOf((short)1), workgroupRecord.getId() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "name"  ( model type : String / wrapperType : String )
		workgroupRecord.setName( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", workgroupRecord.getName() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "description"  ( model type : String / wrapperType : String )
		workgroupRecord.setDescription( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" ) ;
		Assert.assertEquals( "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", workgroupRecord.getDescription() ) ; // Not primitive type in model


		//--- Test setter/getter for attribute "creationDate"  ( model type : Date / wrapperType : Date )
		workgroupRecord.setCreationDate( java.sql.Date.valueOf("2001-06-22") ) ;
		Assert.assertEquals( java.sql.Date.valueOf("2001-06-22"), workgroupRecord.getCreationDate() ) ; // Not primitive type in model


	}

}
