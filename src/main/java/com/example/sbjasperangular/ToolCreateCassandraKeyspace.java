package com.example.sbjasperangular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ToolCreateCassandraKeyspace {

	/**
	 * CassandraでKeyspaceの作成するツール
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		initCreateCassandraKeyspace("keyspaceC","localhost","9160");
	}

	/**
	 * CassandraでKeyspaceの作成
	 * keyspaceC
	 *
	 * @param keyspace
	 * @param host
	 * @param port
	 */
	private static void initCreateCassandraKeyspace(String keyspace,String host,String port) {
		// TODO 自動生成されたメソッド・スタブ
		try {

			Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");

			Connection con = DriverManager.getConnection("jdbc:cassandra://" + host + ":" + port);// jdbc:cassandra://localhost:9160
			String query = "CREATE KEYSPACE " + keyspace + " WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };";
			Statement statement = con.createStatement();

			boolean success = statement.execute(query);// [error]Invalid method
														// name:
														// 'execute_cql3_query'
			System.out.println("created keyspace " + success);
			statement.close();

			con.close();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
