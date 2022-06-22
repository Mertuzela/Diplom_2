package User;

import Users.RestAssuredUser;
import Users.UserClient;
import Users.UsersCredentials;
import Users.UsersData;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserTest extends RestAssuredUser {
    private UsersData usersData;
    private UserClient userClient;

    @Before
    public void setUp() {
        userClient = new UserClient();
    }


    @Test
    public void loginUserWithIncorrectPassword() {
        usersData = new UsersData("call@soul.ru","123");
        UsersCredentials credentials = UsersCredentials.from(usersData);
        userClient.loginUser(credentials)
                .assertThat()
                .statusCode(SC_UNAUTHORIZED)
                .and()
                .body(equalTo(BODY_401));
    }

    @Test
    public void loginUserWithIncorrectEmail() {
        usersData = new UsersData("all@soul.com","123123");
        UsersCredentials credentials = UsersCredentials.from(usersData);
        userClient.loginUser(credentials)
                .assertThat()
                .statusCode(SC_UNAUTHORIZED)
                .and()
                .body(equalTo(BODY_401));
    }
}
