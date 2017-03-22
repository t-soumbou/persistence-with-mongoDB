/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:46 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence;


import org.demo.data.record.CountryRecord ;
import static org.junit.Assert.*;
import java.util.logging.*;

/**
 * JUnit tests for CountryPersistence
 * 
 * @author Telosys Tools
 *
 */
public class CountryPersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(CountryPersistenceGenericTest.class.getName());

	public void testPersistenceService(CountryPersistence persistenceService) throws Exception {
    	LOGGER.info("test CountryPersistence ");


    	assertTrue( persistenceService.countAll() == 0 );

    	CountryRecord country = new CountryRecord();
		//--- Key values
		country.setCode("AA"); // "CODE" : java.lang.String
		//--- Other values
		country.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "NAME" : java.lang.String

    	//--- INSERT
    	LOGGER.info("Insert : " + country);
    	persistenceService.create(country);
    	assertTrue( persistenceService.exists("AA") );
    	assertTrue( persistenceService.countAll() == 1 );
    	assertTrue( persistenceService.exists(country) );
    	
    	//--- FIND
    	LOGGER.info("Find..." );
    	CountryRecord country2 = persistenceService.findById("AA");
    	assertNotNull(country2);
		assertTrue( country2.getCode().equals("AA") ) ;
    	assertTrue( persistenceService.exists(country2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		country2.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "NAME" : java.lang.String
    	LOGGER.info("Update : " + country2 );
    	assertTrue( persistenceService.update(country2) );
    	
    	//--- LOAD
    	CountryRecord country3 = new CountryRecord();
    	country3.setCode("AA");
		country3 = persistenceService.load(country3);
    	assertNotNull( persistenceService.load(country3) );
    	LOGGER.info("Loaded : " + country3 );
	assertEquals(country2.getName(), country3.getName() ); 


    	country3.setCode("CC");
    	assertNull( persistenceService.load(country3) );
    	
    	//--- DELETE
    	LOGGER.info("Delete : " + country2 );
    	assertTrue( persistenceService.delete(country2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(country2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AA") ); // Nothing (already deleted)

    	assertTrue( persistenceService.countAll() == 0 );
    	assertFalse( persistenceService.exists("AA") ) ;
    	assertFalse( persistenceService.exists(country2) ) ;
    	country2 = persistenceService.findById("AA");
    	assertNull( country2 );
    	
    	LOGGER.info("Normal end of persistence service test." );
	}

}