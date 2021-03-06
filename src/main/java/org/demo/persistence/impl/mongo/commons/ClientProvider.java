/*
 * Created on 2017-03-22 ( Date ISO 2017-03-22 - Time 17:28:47 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
/*
 * Created on 2017-03-22 ( Time 17:28:47 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.persistence.impl.mongo.commons;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class ClientProvider {

	/**
	 * The properties file containing the mongo configuration
	 */
	private final static String MONGO_PROPERTIES_FILE_NAME = "/mongo.properties";
	private final static String PORT = "mongo.port";
	private final static String HOST = "mongo.hostname";
	private final static String DBNAME = "mongo.dbname";

	private final static  MongoClient mongoClient = createMongoClient();

	/**
	 * Returns the mongoClient instance
	 * 
	 * @return
	 */
	public  static MongoClient getMongoInstance() {
		return mongoClient;
	}
	
	/**
	 * Returns the default persistence dataBase
	 * 
	 * @return mongo dataBase
	 */
	public static MongoDatabase getDataBase() {
		Properties env = loadJdbcPropertiesFromClassPath();
		String dbname = env.getProperty(DBNAME);
		return mongoClient.getDatabase(dbname);
	}

	/**
	 * Returns the Mongo properties file name
	 * 
	 * @return name of properties file
	 */
	public static String getMongoPrpertiesFileName() {
		return MONGO_PROPERTIES_FILE_NAME;
	}

	/**
	 * Loads the REDIS properties using the class-path to find the file<br>
	 * 
	 * @throws RuntimeException
	 * @return properties file
	 */
	public static Properties loadJdbcPropertiesFromClassPath() {
		return loadPropertiesFromClassPath(MONGO_PROPERTIES_FILE_NAME);
	}
	
	/**
	 * 
	 * @return
	 */
	private static MongoClient createMongoClient() {
		Properties env = loadJdbcPropertiesFromClassPath();
		int port = env.getProperty(PORT).isEmpty() ? ServerAddress.defaultPort() : Integer.valueOf(env.getProperty(PORT));
		String host = env.getProperty(HOST).isEmpty() ? ServerAddress.defaultHost() : env.getProperty(HOST);
		return new MongoClient(host,port);
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	private static Properties loadPropertiesFromClassPath(String fileName) {
		Properties properties = new Properties();
		InputStream is = ClientProvider.class.getResourceAsStream(fileName);
		if (is != null) {
			try {
				properties.load(ClientProvider.class.getResourceAsStream(fileName));
			} catch (IOException e) {
				throw new RuntimeException("Cannot load '" + fileName + "'", e);
			}
			return properties;
		} else {
			throw new RuntimeException("Cannot found '" + fileName + "' (InputStream is null)");
		}
	}
}