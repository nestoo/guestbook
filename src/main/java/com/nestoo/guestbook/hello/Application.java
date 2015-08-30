package com.nestoo.guestbook.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootApplication
public class Application {
	 public static void main(String[] args) {
	        ApplicationContext ctx = SpringApplication.run(Application.class, args);

	        System.out.println("Guest book");
	        
	        try {
				Class.forName("org.h2.Driver");
				 Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
			        Statement stat = conn.createStatement();

			        // this line would initialize the database
			        // from the SQL script file 'init.sql'
			        // stat.execute("runscript from 'init.sql'");

			        stat.execute("create table test(id int primary key, name varchar(255))");
			        stat.execute("insert into test values(1, 'Hello')");
			        ResultSet rs;
			        rs = stat.executeQuery("select * from test");
			        while (rs.next()) {
			            System.out.println(rs.getString("name"));
			        }
			        stat.close();
			        conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       

	    }
}
