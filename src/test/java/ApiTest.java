import core.GetRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestAssuredUtil;

public class ApiTest extends BaseTest {
    @Test
    public void getClientsTest() {
        res = GetRequest.getResponse("/gen/clients");
        jp = RestAssuredUtil.getJsonPath(res);
        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
    }
}
