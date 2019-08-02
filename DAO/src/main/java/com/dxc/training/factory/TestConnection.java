package com.dxc.training.factory;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = SQLHelperFactory.connect();
		
		System.out.println(connection.toString());
	}

}
