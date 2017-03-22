/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:31 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.mongo;

import java.util.List;
import javax.inject.Named;
import org.bson.conversions.Bson;
import org.demo.persistence.impl.mongo.commons.GenericMongoDAO;
import org.bson.Document;
import org.demo.persistence.impl.mongo.commons.DocumentWrapper;



import org.demo.data.record.CarRecord;
import org.demo.persistence.CarPersistence;

@Named("CarPersistence")
public class CarPersistenceImplMongo extends GenericMongoDAO<CarRecord> implements CarPersistence {

	/**
	 * DAO constructor
	 */
	public CarPersistenceImplMongo() {
		super("car");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private CarRecord newInstanceWithPrimaryKey(Integer id) {
		CarRecord car = new CarRecord ();
        car.setId(id); 
		return car;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public CarRecord findById(Integer id){
        CarRecord  car = newInstanceWithPrimaryKey(id);
		return super.doSelect(car);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<CarRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public CarRecord load(CarRecord car) {
		 return super.doSelect(car);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   long   insert(CarRecord car){
		 return super.doInsertIncr(car);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(CarRecord car){
		if (super.doExists(car)) {
			super.doUpdate(car);
		} else {
			insert(car);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(CarRecord car){
		long result= super.doUpdate(car);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public  long  create(CarRecord car){
		return insert(car);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(Integer id) {
		CarRecord car = newInstanceWithPrimaryKey(id);
		long r = super.doDelete(car);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(CarRecord car) {
		long r = super.doDelete(car);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(Integer id) {
		CarRecord car = newInstanceWithPrimaryKey(id);
		return super.doExists(car);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(CarRecord car) {
		return super.doExists(car);
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
	protected CarRecord docTobean(Document doc) {
		CarRecord car = new CarRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		car.setId(mongoDoc.getInteger("id"));
		car.setLastname(mongoDoc.getString("lastname"));
		car.setFirstname(mongoDoc.getString("firstname"));
		return car ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(CarRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("id", bean.getId());
		doc.append("lastname", bean.getLastname());
		doc.append("firstname", bean.getFirstname());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(CarRecord  bean, long id) {
		bean.setId((int) id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(CarRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("id", bean.getId());
		return	mongoDoc.getDocument();
	}

}
