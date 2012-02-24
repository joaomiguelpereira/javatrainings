package eu.jpereira.trainings.jee.persistence.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.impl.SessionImpl;
import org.junit.Ignore;

@Ignore
public class HSQLHelper extends PersistenceTest implements TestDBHelper{
	
	/**
	 * This will clear all tables from HSQLDB
	 * @throws SQLException
	 */
	public void clearDatabase() throws SQLException {
	    Connection c = ((SessionImpl) em.getDelegate()).connection();
	    Statement s = c.createStatement();
	    s.execute("SET DATABASE REFERENTIAL INTEGRITY FALSE");
	    Set<String> tables = new HashSet<String>();
	    ResultSet rs = s.executeQuery("select table_name " +
	        "from INFORMATION_SCHEMA.system_tables " +
	        "where table_type='TABLE' and table_schem='PUBLIC'");
	    while (rs.next()) {
	        if (!rs.getString(1).startsWith("DUAL_")) {
	            tables.add(rs.getString(1));
	        }
	    }
	    rs.close();
	    for (String table : tables) {
	        s.executeUpdate("DELETE FROM " + table);
	    }
	    s.execute("SET DATABASE REFERENTIAL INTEGRITY TRUE");
	    s.close();
	    beginTx();
	    em.flush();
	    commitTx();
	}
}
