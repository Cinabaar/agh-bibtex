package pl.edu.agh.toik.aghbibtex.persistence.contribution;

import java.sql.Types;

import org.hibernate.dialect.HSQLDialect;

public class MyHSQLDialect extends HSQLDialect{

	public MyHSQLDialect() {
		super();
		registerColumnType(Types.CLOB,"clob");
	}
	
}
