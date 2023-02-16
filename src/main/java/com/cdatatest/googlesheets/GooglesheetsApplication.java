package com.cdatatest.googlesheets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

import static com.cdatatest.googlesheets.DriverManagerDataSource.GoogleSheetsDataSource;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class GooglesheetsApplication {

	public static void main(String[] args) throws Exception {
			SpringApplication.run(GooglesheetsApplication.class, args);
			Connection conn = GoogleSheetsDataSource().getConnection();
			System.out.println("Catalog: "+ conn.getCatalog());


		Statement stat = conn.createStatement();
		boolean ret = stat.execute("SELECT * from sys_tables");
		if (ret) {
			ResultSet rs=stat.getResultSet();
			while(rs.next()) {
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++) {
					System.out.println(rs.getMetaData().getColumnLabel(i) +"="+rs.getString(i));
				}
			}
		}
	}

}
