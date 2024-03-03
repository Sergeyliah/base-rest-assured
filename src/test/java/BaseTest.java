import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdbc.JdbcConnection;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.RestAssuredUtil;
import utils.Utility;

import java.sql.SQLException;

public class BaseTest {
    public Response res = null; //Response
    public JsonPath jp  = null; //JsonPath

    //Instantiate a Helper Test Methods (testUtils) Object
    Utility testUtil = new Utility();
    protected static final String MAIL = "mailfortest@gmail.com";
    protected static String sqlQuery;

    @BeforeClass
    public void setup() {
        //Test Setup
        RestAssuredUtil.setBaseURI(); //Setup Base URI
        RestAssuredUtil.setBasePath("api"); //Setup Base Path
        RestAssuredUtil.setContentType(ContentType.JSON); //Setup Content Type
    }

    @AfterClass
    public void afterTest() {
        //Reset Values
        RestAssuredUtil.resetBaseURI();
        RestAssuredUtil.resetBasePath();
    }

    public void deleteUser(){
        sqlQuery = String.format("DELETE FROM user WHERE email = '%1$s'", MAIL);
        try {
            JdbcConnection.establishConnectionForDelete(sqlQuery);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
