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



import org.demo.data.record.WorkgroupRecord;
import org.demo.persistence.WorkgroupPersistence;

@Named("WorkgroupPersistence")
public class WorkgroupPersistenceImplMongo extends GenericMongoDAO<WorkgroupRecord> implements WorkgroupPersistence {

	/**
	 * DAO constructor
	 */
	public WorkgroupPersistenceImplMongo() {
		super("workgroup");
	}

	/**
	 * Creates a new instance of the bean
	 * primary value(s)
	 * 
	 * @param key;
	 * @return the new instance
	 */
	private WorkgroupRecord newInstanceWithPrimaryKey(Short id) {
		WorkgroupRecord workgroup = new WorkgroupRecord ();
        workgroup.setId(id); 
		return workgroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public WorkgroupRecord findById(Short id){
        WorkgroupRecord  workgroup = newInstanceWithPrimaryKey(id);
		return super.doSelect(workgroup);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public List<WorkgroupRecord> findAll() {
		return super.doSelectAll();
	}

	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s)
	 * in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from
	 * the database<br>
	 * If not found, the given instance remains unchanged
	 */
	public WorkgroupRecord load(WorkgroupRecord workgroup) {
		 return super.doSelect(workgroup);
	}

	/**
	 * Inserts the given bean in the database
	 * 
	 */
	public   void   insert(WorkgroupRecord workgroup){
		 super.doInsert(workgroup);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public void save(WorkgroupRecord workgroup){
		if (super.doExists(workgroup)) {
			super.doUpdate(workgroup);
		} else {
			insert(workgroup);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean update(WorkgroupRecord workgroup){
		long result= super.doUpdate(workgroup);	
		return result > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
public 	WorkgroupRecord   create(WorkgroupRecord workgroup){
		insert(workgroup);
        return workgroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean deleteById(Short id) {
		WorkgroupRecord workgroup = newInstanceWithPrimaryKey(id);
		long r = super.doDelete(workgroup);
		return r > 0L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	public boolean delete(WorkgroupRecord workgroup) {
		long r = super.doDelete(workgroup);
		return r > 0L;
	}

	/**
	 * Checks the existence of a record in the database using the given primary
	 * key value(s)
	 * @return
	 */
	public boolean exists(Short id) {
		WorkgroupRecord workgroup = newInstanceWithPrimaryKey(id);
		return super.doExists(workgroup);
	}

	/**
	 * Checks the existence of the given bean in the database
	 * @return
	 */
	public boolean exists(WorkgroupRecord workgroup) {
		return super.doExists(workgroup);
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
	protected WorkgroupRecord docTobean(Document doc) {
		WorkgroupRecord workgroup = new WorkgroupRecord ();
		DocumentWrapper mongoDoc = new DocumentWrapper(doc);
		//--- Set data from document to Bean attributes
		workgroup.setId(mongoDoc.getShort("id"));
		workgroup.setName(mongoDoc.getString("name"));
		workgroup.setDescription(mongoDoc.getString("description"));
		workgroup.setCreationDate(mongoDoc.getDate("creationDate"));
		return workgroup ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected DocumentWrapper beanToDoc(WorkgroupRecord  bean) {
		//--- Set data from bean to Document attributes
		DocumentWrapper doc = new DocumentWrapper();	
		doc.append("id", bean.getId());
		doc.append("name", bean.getName());
		doc.append("description", bean.getDescription());
		doc.append("creationDate", bean.getCreationDate());
		return doc; 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected void setAutoIncrementedKey(WorkgroupRecord  bean, long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Abstract Class
	 */
	@Override
	protected Bson bsonForIdentifyBean(WorkgroupRecord  bean) {
		DocumentWrapper mongoDoc = new DocumentWrapper();
		mongoDoc.append("id", bean.getId());
		return	mongoDoc.getDocument();
	}

}
