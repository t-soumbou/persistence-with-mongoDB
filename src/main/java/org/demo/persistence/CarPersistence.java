/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:31 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence;

import java.util.List;

import org.demo.data.record.CarRecord;

/**
 * Persistence Interface for CarRecord.
 */
public interface CarPersistence { 

	/**
	 * Tries to find an entity using its Id / Primary Key
	 * @param id
	 * @return entity
	 */
	CarRecord findById( Integer id  ) ;

	/**
	 * Finds all entities.
	 * @return all entities
	 */
	List<CarRecord> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	void save(CarRecord entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return true if the entity has been updated, false if not found and not updated
	 */
	boolean update(CarRecord entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
 long  create(CarRecord entity);

	/**
	 * Deletes an entity using its Id / Primary Key
	 * @param id
	 * @return true if the entity has been deleted, false if not found and not deleted
	 */
	boolean deleteById( Integer id );

	/**
	 * Deletes an entity using the Id / Primary Key stored in the given object
	 * @param the entity to be deleted (supposed to have a valid Id/PK )
	 * @return true if the entity has been deleted, false if not found and not deleted
	 */
	boolean delete( CarRecord entity );

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
	public boolean exists(  Integer id ) ;

	/**
	 * Returns true if the given entity exists
	 * @param entity
	 * @return
	 */
	public boolean exists( CarRecord entity) ;
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public CarRecord load( CarRecord entity) ;
}
