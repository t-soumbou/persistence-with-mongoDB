/*
 * Created on 2017-03-22 ( Time 17:28:47 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.persistence.impl.mongo.commons;


import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongoCmdOptionsBuilder;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import java.util.logging.*;

/**
 * Classe  utilise pour les tests des DAO 
 * @author telosys
 *
 */
public class MongoUtil {
	private static MongodProcess mongodProcess;
	private static MongodExecutable mongodExecutable;
	private static final String IP = "127.0.0.1";
	private static final int PORT = 27017;
	private static final Logger LOGGER = Logger.getLogger(MongoUtil.class.getName());
	
	public static void init() throws Exception {
		if(mongodProcess == null){
		MongodStarter starter = MongodStarter.getDefaultInstance();
		IMongodConfig mongodConfig = new MongodConfigBuilder()
			.version(Version.Main.PRODUCTION)
			.net(new Net(IP, PORT, false))
			.cmdOptions(new MongoCmdOptionsBuilder()
			.useSmallFiles(true)
			.useNoJournal(true)
			.useNoPrealloc(true)
			.build()).build();
		LOGGER.info("Recuperation de l'executable");
		mongodExecutable = starter.prepare(mongodConfig);
		System.out.println("Lancement a la volee du serveur MongoDB");
		mongodProcess= mongodExecutable.start();
		LOGGER.info("Serveur MongoDB lance avec succes");
		}
	}
}