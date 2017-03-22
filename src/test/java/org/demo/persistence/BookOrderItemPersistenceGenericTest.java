/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:46 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence;


import org.demo.data.record.BookOrderItemRecord ;
import static org.junit.Assert.*;
import java.util.logging.*;

/**
 * JUnit tests for BookOrderItemPersistence
 * 
 * @author Telosys Tools
 *
 */
public class BookOrderItemPersistenceGenericTest {
	private static final Logger LOGGER = Logger.getLogger(BookOrderItemPersistenceGenericTest.class.getName());

	public void testPersistenceService(BookOrderItemPersistence persistenceService) throws Exception {
    	LOGGER.info("test BookOrderItemPersistence ");


    	assertTrue( persistenceService.countAll() == 0 );

    	BookOrderItemRecord bookOrderItem = new BookOrderItemRecord();
		//--- Key values
		bookOrderItem.setBookOrderId(Integer.valueOf(100)); // "BOOK_ORDER_ID" : java.lang.Integer
		bookOrderItem.setBookId(Integer.valueOf(100)); // "BOOK_ID" : java.lang.Integer
		//--- Other values
		bookOrderItem.setQuantity(Integer.valueOf(100)); // "QUANTITY" : java.lang.Integer
		bookOrderItem.setPrice(java.math.BigDecimal.valueOf(10000)); // "PRICE" : java.math.BigDecimal

    	//--- INSERT
    	LOGGER.info("Insert : " + bookOrderItem);
    	persistenceService.create(bookOrderItem);
    	assertTrue( persistenceService.exists(Integer.valueOf(100), Integer.valueOf(100)) );
    	assertTrue( persistenceService.countAll() == 1 );
    	assertTrue( persistenceService.exists(bookOrderItem) );
    	
    	//--- FIND
    	LOGGER.info("Find..." );
    	BookOrderItemRecord bookOrderItem2 = persistenceService.findById(Integer.valueOf(100), Integer.valueOf(100));
    	assertNotNull(bookOrderItem2);
		assertTrue( bookOrderItem2.getBookOrderId().equals(Integer.valueOf(100)) ) ;
		assertTrue( bookOrderItem2.getBookId().equals(Integer.valueOf(100)) ) ;
    	assertTrue( persistenceService.exists(bookOrderItem2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		bookOrderItem2.setQuantity(Integer.valueOf(200)); // "QUANTITY" : java.lang.Integer
		bookOrderItem2.setPrice(java.math.BigDecimal.valueOf(20000)); // "PRICE" : java.math.BigDecimal
    	LOGGER.info("Update : " + bookOrderItem2 );
    	assertTrue( persistenceService.update(bookOrderItem2) );
    	
    	//--- LOAD
    	BookOrderItemRecord bookOrderItem3 = new BookOrderItemRecord();
    	bookOrderItem3.setBookOrderId(Integer.valueOf(100));
    	bookOrderItem3.setBookId(Integer.valueOf(100));
		bookOrderItem3 = persistenceService.load(bookOrderItem3);
    	assertNotNull( persistenceService.load(bookOrderItem3) );
    	LOGGER.info("Loaded : " + bookOrderItem3 );
	assertEquals(bookOrderItem2.getQuantity(), bookOrderItem3.getQuantity() ); 
	assertEquals(bookOrderItem2.getPrice(), bookOrderItem3.getPrice() ); 


    	bookOrderItem3.setBookOrderId(Integer.valueOf(300));
    	bookOrderItem3.setBookId(Integer.valueOf(300));
    	assertNull( persistenceService.load(bookOrderItem3) );
    	
    	//--- DELETE
    	LOGGER.info("Delete : " + bookOrderItem2 );
    	assertTrue( persistenceService.delete(bookOrderItem2) ); // Delete #1 : OK
    	assertFalse( persistenceService.delete(bookOrderItem2) ); // Nothing (already deleted)
    	assertFalse( persistenceService.deleteById(Integer.valueOf(100), Integer.valueOf(100)) ); // Nothing (already deleted)

    	assertTrue( persistenceService.countAll() == 0 );
    	assertFalse( persistenceService.exists(Integer.valueOf(100), Integer.valueOf(100)) ) ;
    	assertFalse( persistenceService.exists(bookOrderItem2) ) ;
    	bookOrderItem2 = persistenceService.findById(Integer.valueOf(100), Integer.valueOf(100));
    	assertNull( bookOrderItem2 );
    	
    	LOGGER.info("Normal end of persistence service test." );
	}

}
