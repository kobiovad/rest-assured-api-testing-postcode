package testCase.integration;

import core.BaseRest;
import core.resultMainPage.PostCodesResult;
import core.resultMainPage.PostValidate;
import core.resultNarby.PostCodesResultNarby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateTest {
    static Logger logger = LoggerFactory.getLogger(ValidateTest.class);

    @Test(priority = 1,description = "Import valid city code - Response")
    public void checkRespons()throws IOException {
       // logger.info("Start cheak valid - Response");
        BaseRest baseRest = new BaseRest();
        PostCodesResult postCodesResult =  baseRest.getResponse("CB3 0FA");
        String country= postCodesResult.getResult().getCountry();

        Assert.assertEquals(country,"England");
       // logger.info("Response - Pass");
    }
    @Test(priority = 2,description = "Import valid city code - Validate code")
    public void checkValidateRequest()throws IOException{
      //  logger.info("Start cheak valid - valid city code");
        BaseRest baseRest = new BaseRest();
        PostValidate postValidate = baseRest.getvalidateRequest("CB3 0FA");

        Assert.assertTrue(postValidate.getResult());
       // logger.info("valid city code - Pass");
    }
    @Test(priority = 3,description = "Import valid city code - Nearest Post Codes")
    public void checkNearestPostCodes()throws IOException{
      //  logger.info("Start cheak valid - Nearest Post Codes");
        BaseRest baseRest = new BaseRest();
        PostCodesResult postCodesResult = baseRest.getResponse("CB3 0FA");
        PostCodesResultNarby postCodesResultNarby = baseRest.getNearestPostCodes(postCodesResult);
        int statusCode = postCodesResultNarby.getStatus();
        String postCode = postCodesResultNarby.getResult().get(0).getPostcode();

        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(postCode,"CB3 0FA");
      //  logger.info("Nearest Post Codes");
    }
}

