/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:46 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.mongo;

import java.util.List;
import javax.inject.Named;
import org.bson.conversions.Bson;
import org.demo.persistence.impl.mongo.commons.GenericMongoDAO;
import org.bson.Document;
import org.demo.persistence.impl.mongo.commons.DocumentWrapper;



import org.demo.data.record.BookOrderItemRecord;
import org.demo.persistence.BookOrderItemPersistence;

@Named("BookOrderItemPersistence")
public class BookOrderItemPersistenceImplMongo extends GenericMongoDAO<BookOrderItemRecord> implements BookOrderItemPersistence {

	/**
	 * DAO constructor
	 */
	public BookOrderItemPersistenceImplMongo() {
		super("bookOrderItem");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private BookOrderItemRecord newInstanceWithPrimaryKey(Integer bookOrderId, Integer bookId) {
		BookOrderItemRecord bookOrderItem = new BookOrderItemRecord ();
        bookOrderItem.setBookOrderId(bookOrderId); 
        bookOrderItem.setBookId(bookId); 
		return bookOrderItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public BookOrderItemRecord findById(Integer bookOrderId, Integer bookId){
        BookOrderItemRecord  bookOrderItem = newInstanceWithPrimaryKey(bookOrderId, bookId);
		return super.doSelect(bookOrderItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<BookOrderItemRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public BookOrderItemRecord load(BookOrderItemRecord bookOrderItem) {
		 return super.doSelect(bookOrderItem);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   void   insert(BookOrderItemRecord bookOrderItem){
		 super.doInsert(bookOrderItem);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(BookOrderItemRecord bookOrderItem){
		if (super.doExists(bookOrderItem)) {
			super.doUpdate(bookOrderItem);
		} else {
			insert(bookOrderItem);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(BookOrderItemRecord bookOrderItem){
		long result= super.doUpdate(bookOrderItem);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public 	BookOrderItemRecord   create(BookOrderItemRecord bookOrderItem){
		insert(bookOrderItem);
        return bookOrderItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(Integer bookOrderId, Integer bookId) {
		BookOrderItemRecord bookOrderItem = newInstanceWithPrimaryKey(bookOrderId, bookId);
		long r = super.doDelete(bookOrderItem);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(BookOrderItemRecord bookOrderItem) {
		long r = super.doDelete(bookOrderItem);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(Integer bookOrderId, Integer bookId) {
		BookOrderItemRecord bookOrderItem = newInstanceWithPrimaryKey(bookOrderId, bookId);
		return super.doExists(bookOrderItem);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(BookOrderItemRecord bookOrderItem) {
		return super.doExists(bookOrderItem);
	}

	/**
	 * Counts all the records present in the database
	 * 
	 * @return
	 */
	public long countAll() {
		return super.doCountAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected BookOrderItemRecord docTobean(Document doc) {
		BookOrderItemRecord bookOrderItem = new BookOrderItemRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		bookOrderItem.setBookOrderId(mongoDoc.getInteger("bookOrderId"));
		bookOrderItem.setBookId(mongoDoc.getInteger("bookId"));
		bookOrderItem.setQuantity(mongoDoc.getInteger("quantity"));
		bookOrderItem.setPrice(mongoDoc.getBigDecimal("price"));
		return bookOrderItem ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(BookOrderItemRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("bookOrderId", bean.getBookOrderId());
		doc.append("bookId", bean.getBookId());
		doc.append("quantity", bean.getQuantity());
		doc.append("price", bean.getPrice());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(BookOrderItemRecord  bean, long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(BookOrderItemRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("bookOrderId", bean.getBookOrderId());
		mongoDoc.append("bookId", bean.getBookId());
		return	mongoDoc.getDocument();
	}

}
