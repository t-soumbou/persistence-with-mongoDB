/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:47 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.mongo;

import java.util.List;
import javax.inject.Named;
import org.bson.conversions.Bson;
import org.demo.persistence.impl.mongo.commons.GenericMongoDAO;
import org.bson.Document;
import org.demo.persistence.impl.mongo.commons.DocumentWrapper;



import org.demo.data.record.ReviewRecord;
import org.demo.persistence.ReviewPersistence;

@Named("ReviewPersistence")
public class ReviewPersistenceImplMongo extends GenericMongoDAO<ReviewRecord> implements ReviewPersistence {

	/**
	 * DAO constructor
	 */
	public ReviewPersistenceImplMongo() {
		super("review");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private ReviewRecord newInstanceWithPrimaryKey(String customerCode, Integer bookId) {
		ReviewRecord review = new ReviewRecord ();
        review.setCustomerCode(customerCode); 
        review.setBookId(bookId); 
		return review;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public ReviewRecord findById(String customerCode, Integer bookId){
        ReviewRecord  review = newInstanceWithPrimaryKey(customerCode, bookId);
		return super.doSelect(review);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<ReviewRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public ReviewRecord load(ReviewRecord review) {
		 return super.doSelect(review);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   void   insert(ReviewRecord review){
		 super.doInsert(review);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(ReviewRecord review){
		if (super.doExists(review)) {
			super.doUpdate(review);
		} else {
			insert(review);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(ReviewRecord review){
		long result= super.doUpdate(review);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public 	ReviewRecord   create(ReviewRecord review){
		insert(review);
        return review;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(String customerCode, Integer bookId) {
		ReviewRecord review = newInstanceWithPrimaryKey(customerCode, bookId);
		long r = super.doDelete(review);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(ReviewRecord review) {
		long r = super.doDelete(review);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(String customerCode, Integer bookId) {
		ReviewRecord review = newInstanceWithPrimaryKey(customerCode, bookId);
		return super.doExists(review);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(ReviewRecord review) {
		return super.doExists(review);
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
	protected ReviewRecord docTobean(Document doc) {
		ReviewRecord review = new ReviewRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		review.setCustomerCode(mongoDoc.getString("customerCode"));
		review.setBookId(mongoDoc.getInteger("bookId"));
		review.setReviewText(mongoDoc.getString("reviewText"));
		review.setReviewNote(mongoDoc.getInteger("reviewNote"));
		review.setCreation(mongoDoc.getDate("creation"));
		review.setLastUpdate(mongoDoc.getDate("lastUpdate"));
		return review ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(ReviewRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("customerCode", bean.getCustomerCode());
		doc.append("bookId", bean.getBookId());
		doc.append("reviewText", bean.getReviewText());
		doc.append("reviewNote", bean.getReviewNote());
		doc.append("creation", bean.getCreation());
		doc.append("lastUpdate", bean.getLastUpdate());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(ReviewRecord  bean, long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(ReviewRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("customerCode", bean.getCustomerCode());
		mongoDoc.append("bookId", bean.getBookId());
		return	mongoDoc.getDocument();
	}

}
