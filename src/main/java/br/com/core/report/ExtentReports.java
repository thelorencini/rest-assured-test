package br.com.core.report;

import br.com.core.setup.SetupManager;
import br.com.core.properties.PropertiesManager;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import org.picocontainer.classname.ClassName;

import java.io.UnsupportedEncodingException;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExtentReports extends SetupManager {

    private static PropertiesManager setupProperties = new PropertiesManager("src/test/resources/setup.properties");
    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

    public synchronized void setExtentReportsPath() {
        LocalDate dia = LocalDate.now();
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        String reportPath = setupProperties.getProps().getProperty("ReportPath")
                + setupProperties.getProps().getProperty("ReportFile") + "_" + dia.getDayOfMonth() + "-" + dia.getMonthValue() + "-" + dia.getYear() + ".html";
        extentProperties.setReportPath(reportPath);
    }

    public static synchronized void appendToReport(String sMsg) {
        System.out.println("RESPONSE==> " + sMsg);
//        testScenario.write(sMsg);
        if (Reporter.getExtentReport() != null) {
            Reporter.addStepLog("<textarea style=\"margin: 0px; width: 593px; height: 27px;\">" + sMsg + "</textarea>");
        }
    }

    public String setupExtentReports() {
        String reportConfigPath = setupProperties.getProps().getProperty("reportConfigPath");
        Reporter.loadXMLConfig(reportConfigPath);
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("OS Name", System.getProperty("os.name"));
        Reporter.setSystemInfo("OS Version", System.getProperty("os.version"));
        Reporter.setSystemInfo("User language", System.getProperty("user.language"));
        Reporter.setSystemInfo("CPU", System.getProperty("cpu"));
        Reporter.assignAuthor(System.getProperty("user.name"));
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public static void setCucumberLanguage() {
        try {
            Reporter.getExtentReport().setGherkinDialect(setupProperties.getProps().getProperty("Language"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.log(Level.FINE, e.toString(), e);
        }
    }


}

