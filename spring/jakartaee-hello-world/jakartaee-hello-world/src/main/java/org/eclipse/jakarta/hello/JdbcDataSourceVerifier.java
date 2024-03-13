package org.eclipse.jakarta.hello;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;

import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class JdbcDataSourceVerifier {
        
    @Resource(lookup = "jdbc/postgresql")
    private javax.sql.DataSource dataSource;

    
    public Connection getConnection() throws NamingException, SQLException{
        InitialContext ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/postgresql");
        return dataSource.getConnection();
    }

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) throws SQLException, NamingException {
        System.out.println("Verifying connection to PostgreSQL");

        // Context iniContext = new InitialContext();
        // Context envContext = (Context) iniContext.lookup("java:comp/env");
        // DataSource ds = (DataSource) envContext.lookup("jdbc/postgresql");
        var connection = getConnection();
        System.out.println("Version: " + connection.getMetaData().getDatabaseMajorVersion() + "." + connection.getMetaData().getDatabaseMinorVersion());

        // var metaData = dataSource.getConnection().getMetaData();

        // System.out.println(metaData.getDatabaseProductName());
        // System.out.println("Version: " + metaData.getDatabaseMajorVersion() + "." + metaData.getDatabaseMinorVersion());
    }
}
