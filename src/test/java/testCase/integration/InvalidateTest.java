package testCase.integration;

import core.BaseRest;
import core.resultMainPage.PostCodesResult;
import core.resultMainPage.PostValidate;
import core.resultNarby.PostCodesResultNarby;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class InvalidateTest {
    static Logger logger = LoggerFactory.getLogger(InvalidateTest.class);

    @Test(priority = 1,description = "Import Invalid city code - Response")
    public void checkRespons()throws IOException{
       // logger.info("Start cheak valid - Response");
        BaseRest baseRest = new BaseRest();
        PostCodesResult postCodesResult =  baseRest.getResponse("CB3 0FB"); //CB3 0FA
        //String country= postCodesResult.getResult().getCountry();

        Assert.assertEquals(postCodesResult.getStatus().toString(),"404");
       // logger.info("Response - Pass");
    }
    @Test(priority = 2,description = "Import Invalid city code - Validate code")
    public void checkValidateRequest()throws IOException{
      //  logger.info("Start cheak valid - valid city code");
        BaseRest baseRest = new BaseRest();
        PostValidate postValidate = baseRest.getvalidateRequest("CB3 0FB");
        Boolean validIsTrue = postValidate.getResult();
        Assert.assertFalse(postValidate.getResult());

       // logger.info("valid city code - Pass");
    }
    @Test(priority = 3,description = "Import Invalid city code - Nearest Post Codes")
    public void checkNearestPostCodes()throws IOException {
      //  logger.info("Start cheak valid - Nearest Post Codes");
        BaseRest baseRest = new BaseRest();
        PostCodesResult postCodesResult = baseRest.getResponse("CB3 0FA");
        postCodesResult.getResult().setLatitude(1.2345);
        postCodesResult.getResult().setLongitude(1.2345);

        PostCodesResultNarby postCodesResultNarby = baseRest.getNearestPostCodes(postCodesResult);

        Assert.assertNull(postCodesResultNarby.getResult());

      //  logger.info("Nearest Post Codes");
    }
}

/* @BeforeTest
    public void generateTestReport() {
        if (SuiteListener.reports != null) {
            SuiteListener.test = SuiteListener.reports.startTest("Positive login test");
            SuiteListener.test.log(LogStatus.INFO, "Positive login test" + " is started");
            SuiteListener.test.setDescription("We input the right username and password.");
        }
    }
    @AfterTest
    public void closeTestReport() {
        if (SuiteListener.test != null)
            SuiteListener.reports.endTest(SuiteListener.test);
    }*/
