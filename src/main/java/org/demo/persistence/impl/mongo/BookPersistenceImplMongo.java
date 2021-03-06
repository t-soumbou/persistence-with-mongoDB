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



import org.demo.data.record.BookRecord;
import org.demo.persistence.BookPersistence;

@Named("BookPersistence")
public class BookPersistenceImplMongo extends GenericMongoDAO<BookRecord> implements BookPersistence {

	/**
	 * DAO constructor
	 */
	public BookPersistenceImplMongo() {
		super("book");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private BookRecord newInstanceWithPrimaryKey(Integer id) {
		BookRecord book = new BookRecord ();
        book.setId(id); 
		return book;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public BookRecord findById(Integer id){
        BookRecord  book = newInstanceWithPrimaryKey(id);
		return super.doSelect(book);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<BookRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public BookRecord load(BookRecord book) {
		 return super.doSelect(book);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   void   insert(BookRecord book){
		 super.doInsert(book);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(BookRecord book){
		if (super.doExists(book)) {
			super.doUpdate(book);
		} else {
			insert(book);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(BookRecord book){
		long result= super.doUpdate(book);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public 	BookRecord   create(BookRecord book){
		insert(book);
        return book;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(Integer id) {
		BookRecord book = newInstanceWithPrimaryKey(id);
		long r = super.doDelete(book);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(BookRecord book) {
		long r = super.doDelete(book);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(Integer id) {
		BookRecord book = newInstanceWithPrimaryKey(id);
		return super.doExists(book);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(BookRecord book) {
		return super.doExists(book);
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
	protected BookRecord docTobean(Document doc) {
		BookRecord book = new BookRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		book.setId(mongoDoc.getInteger("id"));
		book.setPublisherId(mongoDoc.getInteger("publisherId"));
		book.setAuthorId(mongoDoc.getInteger("authorId"));
		book.setIsbn(mongoDoc.getString("isbn"));
		book.setTitle(mongoDoc.getString("title"));
		book.setPrice(mongoDoc.getBigDecimal("price"));
		book.setQuantity(mongoDoc.getInteger("quantity"));
		book.setDiscount(mongoDoc.getInteger("discount"));
		book.setAvailability(mongoDoc.getShort("availability"));
		book.setBestSeller(mongoDoc.getShort("bestSeller"));
		return book ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(BookRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("id", bean.getId());
		doc.append("publisherId", bean.getPublisherId());
		doc.append("authorId", bean.getAuthorId());
		doc.append("isbn", bean.getIsbn());
		doc.append("title", bean.getTitle());
		doc.append("price", bean.getPrice());
		doc.append("quantity", bean.getQuantity());
		doc.append("discount", bean.getDiscount());
		doc.append("availability", bean.getAvailability());
		doc.append("bestSeller", bean.getBestSeller());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(BookRecord  bean, long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(BookRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("id", bean.getId());
		return	mongoDoc.getDocument();
	}

}
