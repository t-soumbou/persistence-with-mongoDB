/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:47 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence;


import org.demo.data.record.PublisherRecord ;
import static org.junit.Assert.*;
import java.util.logging.*;

/**
 * JUnit tests for PublisherPersistence
 * 
 * @author Telosys Tools
 *
 */
public class PublisherPersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(PublisherPersistenceGenericTest.class.getName());

	public void testPersistenceService(PublisherPersistence persistenceService) throws Exception {
    	LOGGER.info("test PublisherPersistence ");


    	assertTrue( persistenceService.countAll() == 0 );

    	PublisherRecord publisher = new PublisherRecord();
		//--- Key values
		publisher.setCode(Integer.valueOf(100)); // "CODE" : java.lang.Integer
		//--- Other values
		publisher.setCountryCode("AA"); // "COUNTRY_CODE" : java.lang.String
		publisher.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "NAME" : java.lang.String
		publisher.setEmail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "EMAIL" : java.lang.String
		publisher.setContact("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "CONTACT" : java.lang.String
		publisher.setCity("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "CITY" : java.lang.String
		publisher.setZipCode(Integer.valueOf(100)); // "ZIP_CODE" : java.lang.Integer
		publisher.setPhone("AAAAAAAAAAAAAA"); // "PHONE" : java.lang.String

    	//--- INSERT
    	LOGGER.info("Insert : " + publisher);
    	persistenceService.create(publisher);
    	assertTrue( persistenceService.exists(Integer.valueOf(100)) );
    	assertTrue( persistenceService.countAll() == 1 );
    	assertTrue( persistenceService.exists(publisher) );
    	
    	//--- FIND
    	LOGGER.info("Find..." );
    	PublisherRecord publisher2 = persistenceService.findById(Integer.valueOf(100));
    	assertNotNull(publisher2);
		assertTrue( publisher2.getCode().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(publisher2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		publisher2.setCountryCode("BB"); // "COUNTRY_CODE" : java.lang.String
		publisher2.setName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "NAME" : java.lang.String
		publisher2.setEmail("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "EMAIL" : java.lang.String
		publisher2.setContact("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "CONTACT" : java.lang.String
		publisher2.setCity("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "CITY" : java.lang.String
		publisher2.setZipCode(Integer.valueOf(200)); // "ZIP_CODE" : java.lang.Integer
		publisher2.setPhone("BBBBBBBBBBBBBB"); // "PHONE" : java.lang.String
    	LOGGER.info("Update : " + publisher2 );
    	assertTrue( persistenceService.update(publisher2) );
    	
    	//--- LOAD
    	PublisherRecord publisher3 = new PublisherRecord();
    	publisher3.setCode(Integer.valueOf(100));
		publisher3 = persistenceService.load(publisher3);
    	assertNotNull( persistenceService.load(publisher3) );
    	LOGGER.info("Loaded : " + publisher3 );
	assertEquals(publisher2.getCountryCode(), publisher3.getCountryCode() ); 
	assertEquals(publisher2.getName(), publisher3.getName() ); 
	assertEquals(publisher2.getEmail(), publisher3.getEmail() ); 
	assertEquals(publisher2.getContact(), publisher3.getContact() ); 
	assertEquals(publisher2.getCity(), publisher3.getCity() ); 
	assertEquals(publisher2.getZipCode(), publisher3.getZipCode() ); 
	assertEquals(publisher2.getPhone(), publisher3.getPhone() ); 


    	publisher3.setCode(Integer.valueOf(300));
    	assertNull( persistenceService.load(publisher3) );
    	
    	//--- DELETE
    	LOGGER.info("Delete : " + publisher2 );
    	assertTrue( persistenceService.delete(publisher2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(publisher2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100)) ); // Nothing (already deleted)

    	assertTrue( persistenceService.countAll() == 0 );
    	assertFalse( persistenceService.exists(Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(publisher2) ) ;
    	publisher2 = persistenceService.findById(Integer.valueOf(100));
    	assertNull( publisher2 );
    	
    	LOGGER.info("Normal end of persistence service test." );
	}

}
