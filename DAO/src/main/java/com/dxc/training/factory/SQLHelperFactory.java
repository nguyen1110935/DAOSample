package com.dxc.training.factory;

import java.sql.Connection;

public final class SQLHelperFactory {

	public static SQLHelper sqlHelper = null;
	public SQLHelperFactory() {

	}
	public static Connection connect() {
		Config config = new Config();
		
		String type = config.getType();
		if (type.equals("ORACLE"))
			sqlHelper = new OracleDAOHelperImpl();
		else if (type.equals("MSSQL"))
			sqlHelper = new MSSQLDAOHelperImpl();
		else if (type.equals("H2"))
			sqlHelper = new H2DAOHelperImpl();
		Connection connection = sqlHelper.getConnection();
		return connection;
	}
}
