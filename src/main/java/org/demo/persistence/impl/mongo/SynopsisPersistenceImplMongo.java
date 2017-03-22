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



import org.demo.data.record.SynopsisRecord;
import org.demo.persistence.SynopsisPersistence;

@Named("SynopsisPersistence")
public class SynopsisPersistenceImplMongo extends GenericMongoDAO<SynopsisRecord> implements SynopsisPersistence {

	/**
	 * DAO constructor
	 */
	public SynopsisPersistenceImplMongo() {
		super("synopsis");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private SynopsisRecord newInstanceWithPrimaryKey(Integer bookId) {
		SynopsisRecord synopsis = new SynopsisRecord ();
        synopsis.setBookId(bookId); 
		return synopsis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public SynopsisRecord findById(Integer bookId){
        SynopsisRecord  synopsis = newInstanceWithPrimaryKey(bookId);
		return super.doSelect(synopsis);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<SynopsisRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public SynopsisRecord load(SynopsisRecord synopsis) {
		 return super.doSelect(synopsis);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   void   insert(SynopsisRecord synopsis){
		 super.doInsert(synopsis);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(SynopsisRecord synopsis){
		if (super.doExists(synopsis)) {
			super.doUpdate(synopsis);
		} else {
			insert(synopsis);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(SynopsisRecord synopsis){
		long result= super.doUpdate(synopsis);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public 	SynopsisRecord   create(SynopsisRecord synopsis){
		insert(synopsis);
        return synopsis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(Integer bookId) {
		SynopsisRecord synopsis = newInstanceWithPrimaryKey(bookId);
		long r = super.doDelete(synopsis);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(SynopsisRecord synopsis) {
		long r = super.doDelete(synopsis);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(Integer bookId) {
		SynopsisRecord synopsis = newInstanceWithPrimaryKey(bookId);
		return super.doExists(synopsis);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(SynopsisRecord synopsis) {
		return super.doExists(synopsis);
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
	protected SynopsisRecord docTobean(Document doc) {
		SynopsisRecord synopsis = new SynopsisRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		synopsis.setBookId(mongoDoc.getInteger("bookId"));
		synopsis.setSynopsis(mongoDoc.getString("synopsis"));
		return synopsis ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(SynopsisRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("bookId", bean.getBookId());
		doc.append("synopsis", bean.getSynopsis());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(SynopsisRecord  bean, long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(SynopsisRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("bookId", bean.getBookId());
		return	mongoDoc.getDocument();
	}

}
