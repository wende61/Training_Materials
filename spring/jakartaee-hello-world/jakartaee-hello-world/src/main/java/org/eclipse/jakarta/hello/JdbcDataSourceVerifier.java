package org.eclipse.jakarta.hello;

import java.sql.SQLException;

import javax.activation.DataSource;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.jms.Connection;

@ApplicationScoped
public class JdbcDataSourceVerifier {
        
    @Resource(lookup = "jdbc/postgresql")
    private javax.sql.DataSource dataSource;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) throws SQLException {
        System.out.println("Verifying connection to PostgreSQL");

        var metaData = dataSource.getConnection().getMetaData();

        System.out.println(metaData.getDatabaseProductName());
        System.out.println("Version: " + metaData.getDatabaseMajorVersion() + "." + metaData.getDatabaseMinorVersion());
    }
}
