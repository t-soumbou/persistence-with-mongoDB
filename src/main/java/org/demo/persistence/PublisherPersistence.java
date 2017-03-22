/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:47 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence;

import java.util.List;

import org.demo.data.record.PublisherRecord;

/**
 * Persistence Interface for PublisherRecord.
 */
public interface PublisherPersistence { 

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * @param code
	 * @return entity
	 */
	PublisherRecord findById( Integer code  ) ;

	/**
	 * Finds all entities.
	 * @return all entities
	 */
	List<PublisherRecord> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	void save(PublisherRecord entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not updated
	 */
	boolean update(PublisherRecord entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	PublisherRecord   create(PublisherRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * @param code
	 * @return true if the entity has been deleted, false if not found and not deleted
	 */
	boolean deleteById( Integer code );

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * @param the entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not deleted
	 */
	boolean delete( PublisherRecord entity );

   /**
	 * Counts all the records present in the database
	 * @return
	 */
	public long countAll() ;
	/**
	 * Returns true if an entity exists with the given Id / Primary Key 
	 * @param id
	 *  @param name
	 * @return
	 */
	public boolean exists(  Integer code ) ;

	/**
	 * Returns true if the given entity exists
	 * @param entity
	 * @return
	 */
	public boolean exists( PublisherRecord entity) ;
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public PublisherRecord load( PublisherRecord entity) ;
}
