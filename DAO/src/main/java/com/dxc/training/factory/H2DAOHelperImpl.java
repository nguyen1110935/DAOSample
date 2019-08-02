package com.dxc.training.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.h2.*;

public class H2DAOHelperImpl implements SQLHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(H2DAOHelperImpl.class);
	  public Connection getConnection() {
		  Config config = new Config();
		   Connection conn =null;
		   try {
	        	String h2Driver = config.getDriver();
	        	String database = config.getDatabase();
	        	String userName = config.getUserId();
	        	String password = config.getPassword();
	        	String h2String = "jdbc:h2:~/"+ database;
			Class.forName(h2Driver); 
			conn = DriverManager.getConnection(h2String, userName, password);
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			   LOGGER.info("Error: " + e.getMessage());
		   } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			   LOGGER.info("Error: " + e.getMessage());
		}
        return conn;
	  }

}
