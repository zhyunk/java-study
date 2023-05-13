package mockito;

import org.junit.jupiter.api.*;
import java.sql.*;

@DisplayName("DB Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DBTest {
    Connection conn;
    Statement stmt;

    @Test
    void data() throws SQLException {
        stmt.execute("INSERT INTO USERS(NAME, EMAIL) VALUES('몽키', 'monkey@zh.kim');");
        stmt.execute("INSERT INTO USERS(NAME, EMAIL) VALUES('코알라', 'native.bear@zh.kim');");

        // 데이터 조회
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("ID") + ", " +
                    rs.getString("NAME") + ", " +
                    rs.getString("EMAIL")
            );
        }
    }

    @BeforeAll
    void init() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:h2:mem:test2",
                    "sa",
                    ""
            );
            stmt = conn.createStatement();
            stmt.execute(
                    "CREATE TABLE USERS(" +
                            "    ID INT PRIMARY KEY AUTO_INCREMENT," +
                            "    NAME VARCHAR(100)," +
                            "    EMAIL VARCHAR(100)" +
                            ");"
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    void destroy() {
        try {
            stmt.execute(
                    "DROP TABLE USERS;"
            );
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
