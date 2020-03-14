package core.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SuiteListener implements ISuiteListener {
   // private Logger log = LoggerFactory.getLogger(main.dd.core.util.listeners.WebEventListener.class);
    public static ExtentReports reports =null;
    public static ExtentTest test=null;
    public static String nameReport ;
    public SuiteListener() throws IOException {
    }

    @Override
    public void onStart(ISuite iSuite) {
        nameReport =  "src/java/main/resources/reports-" + iSuite.getName()
                + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").
                format(new Date()) + ".html";
        reports =new ExtentReports(nameReport);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        reports.flush();

    }
}
