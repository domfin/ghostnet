package io.iu.ghostnet.setup;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@DataSourceDefinition(
        name = "java:app/jdbc/ghostnet",
        className = "org.h2.jdbcx.JdbcDataSource",
        url = "jdbc:h2:file:C:/work/ghostnet/db/ghostdb;MODE=LEGACY;AUTO_SERVER=TRUE",
        user = "sa",
        password = ""
)
@Singleton
@Startup
public class DbInit {

    @Resource(lookup = "java:app/jdbc/ghostnet")
    private DataSource ds;

    @PostConstruct
    public void init() {
        try (Connection c = ds.getConnection(); Statement st = c.createStatement()) {

            // PERSON: minimal (passt zu Person.java)
            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS PERSON (
                  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                  NAME VARCHAR(255),
                  PHONE VARCHAR(64),
                  BERGENDE BOOLEAN DEFAULT FALSE
                )
            """);

            // GEISTERNETZ: minimal (passt zu Geisternetz.java)
            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS GEISTERNETZ (
                  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                  BESCHREIBUNG VARCHAR(1024),
                  GROESSE INT,
                  LATITUDE DOUBLE,
                  LONGITUDE DOUBLE,
                  STATUS INT NOT NULL,
                  BERGENDEPERSON_ID BIGINT
                )
            """);

            // Einfache FK-Constraint zwischen GEISTERNETZ und PERSON
            st.executeUpdate("""
                ALTER TABLE GEISTERNETZ
                ADD CONSTRAINT IF NOT EXISTS FK_GN_PERSON
                FOREIGN KEY (BERGENDEPERSON_ID) REFERENCES PERSON(ID)
            """);

        } catch (SQLException e) {
            throw new RuntimeException("DB-Initialisierung fehlgeschlagen", e);
        }
    }
}
