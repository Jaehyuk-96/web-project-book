package kr.co.chunjae1.persistence;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try {
			try (Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
				log.info(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
