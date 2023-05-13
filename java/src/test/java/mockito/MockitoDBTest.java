package mockito;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("DB Test")
@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MockitoDBTest {
    Connection conn;
    Statement stmt;

    @Mock // UserRepository 타입의 모의 객체 생성
    UserRepository userRepository;

    @InjectMocks // 모의 객체 주입
    UserService userService;

    @Test
    void insert() {
        User user = new User(1, "몽키", "monkey@zh.kim");

        given( userRepository.findById(1) ).willReturn( Optional.of(user) );

        User result = userService.getUserById(1);

        assertEquals( user, result );
        verify( userRepository, times(1) ).findById(1);

        System.out.println(result.toString());
    }
    @Test
    void insert2() throws SQLException {
        User user = new User(2, "코알라", "native.bear@zh.kim");

        given( userRepository.findById(1) ).willReturn( Optional.of(user) );

        User result = userService.getUserById(1);

        assertEquals(user, result);
        verify( userRepository, times(1) ).findById(1);

        System.out.println(result.toString());
    }


    // 아래 2개의 메서드는 실제 값 넣어보는 용도로만 확인! 확인 시 class 위에 @TestInstance 주석 해제
    // @BeforeAll
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

    // @AfterAll
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
