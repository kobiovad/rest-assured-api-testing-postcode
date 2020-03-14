package testCase;

import core.BaseRest;
import org.testng.annotations.Test;

public class E2ETest {
    @Test
    public void checkNearestPostCodes(){
        BaseRest baseRest = new BaseRest();
        baseRest.getResponse("CB3 0FA");
        baseRest.getvalidateRequest("CB3 0FA");
    }
}
