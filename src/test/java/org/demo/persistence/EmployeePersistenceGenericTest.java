/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:46 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence;


import org.demo.data.record.EmployeeRecord ;
import static org.junit.Assert.*;
import java.util.logging.*;

/**
 * JUnit tests for EmployeePersistence
 * 
 * @author Telosys Tools
 *
 */
public class EmployeePersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(EmployeePersistenceGenericTest.class.getName());

	public void testPersistenceService(EmployeePersistence persistenceService) throws Exception {
    	LOGGER.info("test EmployeePersistence ");


    	assertTrue( persistenceService.countAll() == 0 );

    	EmployeeRecord employee = new EmployeeRecord();
		//--- Key values
		employee.setCode("AAAA"); // "CODE" : java.lang.String
		//--- Other values
		employee.setShopCode("AAA"); // "SHOP_CODE" : java.lang.String
		employee.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "FIRST_NAME" : java.lang.String
		employee.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "LAST_NAME" : java.lang.String
		employee.setManager(Short.valueOf((short)1)); // "MANAGER" : java.lang.Short
		employee.setBadgeNumber(Integer.valueOf(100)); // "BADGE_NUMBER" : java.lang.Integer
		employee.setEmail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "EMAIL" : java.lang.String

    	//--- INSERT
    	LOGGER.info("Insert : " + employee);
    	persistenceService.create(employee);
    	assertTrue( persistenceService.exists("AAAA") );
    	assertTrue( persistenceService.countAll() == 1 );
    	assertTrue( persistenceService.exists(employee) );
    	
    	//--- FIND
    	LOGGER.info("Find..." );
    	EmployeeRecord employee2 = persistenceService.findById("AAAA");
    	assertNotNull(employee2);
		assertTrue( employee2.getCode().equals("AAAA") ) ;
    	assertTrue( persistenceService.exists(employee2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		employee2.setShopCode("BBB"); // "SHOP_CODE" : java.lang.String
		employee2.setFirstName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "FIRST_NAME" : java.lang.String
		employee2.setLastName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "LAST_NAME" : java.lang.String
		employee2.setManager(Short.valueOf((short)2)); // "MANAGER" : java.lang.Short
		employee2.setBadgeNumber(Integer.valueOf(200)); // "BADGE_NUMBER" : java.lang.Integer
		employee2.setEmail("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "EMAIL" : java.lang.String
    	LOGGER.info("Update : " + employee2 );
    	assertTrue( persistenceService.update(employee2) );
    	
    	//--- LOAD
    	EmployeeRecord employee3 = new EmployeeRecord();
    	employee3.setCode("AAAA");
		employee3 = persistenceService.load(employee3);
    	assertNotNull( persistenceService.load(employee3) );
    	LOGGER.info("Loaded : " + employee3 );
	assertEquals(employee2.getShopCode(), employee3.getShopCode() ); 
	assertEquals(employee2.getFirstName(), employee3.getFirstName() ); 
	assertEquals(employee2.getLastName(), employee3.getLastName() ); 
	assertEquals(employee2.getManager(), employee3.getManager() ); 
	assertEquals(employee2.getBadgeNumber(), employee3.getBadgeNumber() ); 
	assertEquals(employee2.getEmail(), employee3.getEmail() ); 


    	employee3.setCode("CCCC");
    	assertNull( persistenceService.load(employee3) );
    	
    	//--- DELETE
    	LOGGER.info("Delete : " + employee2 );
    	assertTrue( persistenceService.delete(employee2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(employee2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById("AAAA") ); // Nothing (already deleted)

    	assertTrue( persistenceService.countAll() == 0 );
    	assertFalse( persistenceService.exists("AAAA") ) ;
    	assertFalse( persistenceService.exists(employee2) ) ;
    	employee2 = persistenceService.findById("AAAA");
    	assertNull( employee2 );
    	
    	LOGGER.info("Normal end of persistence service test." );
	}

}
