package obieeReportsTests;

import obieeReportsBase.TestBaseReports;

import obieeReportsUtilities.Report;
import obieeReportsUtilities.RolePermission;
import obieeReportsUtilities.TestUtilReports;
import obieeReportsUtilities.WriteResults;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ARoleTest extends TestBaseReports {
    public static Logger log = Logger.getLogger("ARoleTest");
    WebElement tdsLink = null;
    WebElement retHome = null;

    @BeforeClass
    public void runBeforeClass() {
        //log.debug("0 ====== Report ARoleTest =======================================");
        super.setTheTest("ARoleTest");
        wr = new WriteResults("ARoleTest.html", true);

    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    //@Test
    public void ARoleTest(RolePermission rolePermission) throws InterruptedException {


        //setRoleInDB(rolePermission.getRoleName());


        log.debug("===== Enter ARoleTest Rolename -- " + rolePermission.getRoleName());
        runBeforeClass();

        super.setUp(rolePermission);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String userName = rolePermission.getUserName().trim();

/*
		if (!"RTEST11".equals(userName)){
			log.debug("SKIP " + userName);
			driver.findElement(By.xpath("//*[@id=\'logout\']")).click();
			driver.close();
			return;
		}
*/
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String theTestValue = this.getTheTest();

        // Open the table for this loop
        wr.openTable(rolePermission.getRoleName(), roleCount++, rolePermission.getUserName());


        try {
            tdsLink = null;
            retHome = null;

            List<WebElement> theEle0 = driver.findElements(By.xpath("//h2[text() = 'Trip & Document Status']"));
            //log.debug("List of Trip & Document Status " + theEle0.size());
            wr.writeRow("Trip & Document Status", rolePermission.isTripDocumentStatus(), theEle0.size(), "");
            findReportElements(rolePermission, "Trip & Document Status");
            if (rolePermission.isTripDocumentStatus()) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Document & Trip Status Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Trip & Document Status");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Trip & Document Status section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Trip & Document Status section ", e);
            wr.writeSubRowException("Trip & Document Status Dashboard", "Exception ");
        }


        try {
            tdsLink = null;
            retHome = null;
            List<WebElement> theEle1 = driver.findElements(By.xpath("//h2[text() = 'Document Details']"));
            //log.debug("List of Document Details " + theEle1.size());
            wr.writeRow("Document Details", rolePermission.isTripDocumentStatus(), theEle1.size(), "");
            findReportElements(rolePermission, "Document Details");
            if (rolePermission.isTripDocumentStatus()) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Document Details Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());

                tdsLink.click();
                findReportListInSection(rolePermission, "Document Details");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Document Details section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Document Details section ", e);
            wr.writeSubRowException("Document Details Dashboard", "Exception ");
        }

        try {
            tdsLink = null;
            retHome = null;
            String rolename = rolePermission.getRoleName();
            List<WebElement> theEle2 = driver.findElements(By.xpath("//h2[text() = 'Traveler & User Information']"));
            //log.debug("List of Traveler & User Information " + theEle2.size());
            wr.writeRow("Traveler & User Information", rolePermission.isTravelerUserInformation(), theEle2.size(), "");
            findReportElements(rolePermission, "Traveler & User Information");

            // For Trveler and Audit need to check the role
            // BacisB and Adt
            // Using spread sheet for this
            if (rolename.contains("BasicB") && !rolename.contains("Adt")) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Traveler & User Information Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Traveler & User Information");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Traveler & User Information section");
            }
            else if (rolename.contains("BasicB") && rolename.contains("Adt")) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Traveler & User Information Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());

                tdsLink.click();
                findReportListInSection(rolePermission, "Traveler & User Information");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Traveler & User Information section");
            }
            else if (!rolename.contains("BasicB") && rolename.contains("Adt")) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Audit Trail Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Audit Trail");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Traveler & User Information section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Traveler & User Information section ", e);
            wr.writeSubRowException("Traveler & User Information", "Exception ");
        }

        try {
            tdsLink = null;
            retHome = null;
            List<WebElement> theEle3 = driver.findElements(By.xpath("//h2[text() = 'Tickets']"));
            //log.debug("List of Tickets " + theEle3.size());
            wr.writeRow("Tickets", rolePermission.isTickets(), theEle3.size(), "");
            findReportElements(rolePermission, "Tickets");
            if (rolePermission.isTickets()) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Tickets Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Tickets");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Tickets section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Tickets section ", e);
            wr.writeSubRowException("Tickets Dashboard", "Exception ");
        }

        try {
            tdsLink = null;
            retHome = null;
            List<WebElement> theEle4 = driver.findElements(By.xpath("//h2[text() = 'Military Information']"));
            //log.debug("List of Military Information " + theEle4.size());
            wr.writeRow("Military Information", rolePermission.isMilitaryInformation(), theEle4.size(), "");
            findReportElements(rolePermission, "Military Information");
            if (rolePermission.isMilitaryInformation()) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Military Information Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Military Information");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Military Information section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Military Information Status section ", e);
            wr.writeSubRowException("Military Information Dashboard", "Exception ");
        }

        try {
            tdsLink = null;
            retHome = null;
            List<WebElement> theEle5 = driver.findElements(By.xpath("//h2[text() = 'Expenses']"));
            //.debug("List of Expenses  " + theEle5.size());
            wr.writeRow("Expenses", rolePermission.isExpenses(), theEle5.size(), "");
            findReportElements(rolePermission, "Expenses");
            if (rolePermission.isExpenses()) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Expenses Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Expenses");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Expenses section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Expenses section ", e);
            wr.writeSubRowException("Expenses Dashboard", "Exception ");
        }

        try {
            tdsLink = null;
            retHome = null;
            List<WebElement> theEle6 = driver.findElements(By.xpath("//h2[text() = 'Lodging']"));
            //log.debug("List of Lodging " + theEle6.size());
            wr.writeRow("Lodging", rolePermission.isLodging(), theEle6.size(), "");
            findReportElements(rolePermission, "Lodging");
            if (rolePermission.isLodging()) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Lodging Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Lodging");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Lodging section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Lodging section ", e);
            wr.writeSubRowException("Lodging Dashboard", "Exception ");
        }

        try {
            tdsLink = null;
            retHome = null;
            List<WebElement> theEle7 = driver.findElements(By.xpath("//h2[text() = 'Debt Management']"));
            //log.debug("List of Lodging " + theEle6.size());
            wr.writeRow("Debt Management", rolePermission.isDebtManagement(), theEle7.size(), "");
            findReportElements(rolePermission, "Debt Management");
            if (rolePermission.isDebtManagement()) {
                tdsLink = driver.findElement(By.xpath("//span[text() = 'Debt Management Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Debt Management");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Debt Management section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Debt Management section ", e);
            wr.writeSubRowException("Debt Management Dashboard", "Exception ");
        }



        try {
            tdsLink = null;
            retHome = null;
            List<WebElement> theEle8 = driver.findElements(By.xpath("//h2[text() = 'Transaction Monitoring']"));
            //log.debug("List of Transaction Monitoring " + theEle8.size());
            wr.writeRow("Transaction Monitoring", rolePermission.isTransactionMonitoring(), theEle8.size(), "");
            findReportElements(rolePermission, "Transaction Monitoring");
            if (rolePermission.isTransactionMonitoring()) {
                tdsLink = driver.findElement(By.xpath("//*[text() = 'Transaction Monitoring Dashboard']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdsLink);
                Thread.sleep(500);
                log.debug("There are tdsLink " + tdsLink.getTagName() + " " + tdsLink.getText());
                tdsLink.click();
                findReportListInSection(rolePermission, "Transaction Monitoring");
                retHome = driver.findElement(By.xpath("//*[text() = 'Return to Defense Travel Reports Home']"));
                retHome.click();
                log.debug("finished Transaction Monitoring section");
            }
        } catch (Exception e) {
            log.error(rolePermission.getUserName() + " " + rolePermission.getRoleName() + " " + "Exception in Transaction Monitoring section " , e);
            wr.writeSubRowException("Transaction Monitoring Dashboard", "Exception ");
        }


        wr.closeTable();


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Logout
        driver.findElement(By.xpath("//*[@id=\'logout\']")).click();
        driver.close();
        driver.close();

        log.debug("===== Complete ARoleTest Rolename -- " + rolePermission.getRoleName());
    }

    public void findReportElements(RolePermission rolePermission, String section) {
        try {
        List<Report> theReportList = reportList.getReportBySection(section);
        for (Report aReport : theReportList) {

            String text = aReport.getReportText();
            List<WebElement> theReport = null;
            if (text.equals("What's Out - Totals by System")) {
                theReport = driver.findElements(By.xpath("//*[contains(text(),'Out') and contains(text(),'Totals by System')]"));
            } else if (text.equals("What's Out - Details")) {
                theReport = driver.findElements(By.xpath("//*[contains(text(),'Out') and contains(text(),'Details')]"));
            } else {
                theReport = driver.findElements(By.xpath("//li[text() = '" + text + "']"));
            }
            boolean rp = rolePermission.findPermissionByString(text);
            wr.writeSubRow(text, rp, theReport.size(), "");
            log.debug("Report search " + text + " " + theReport.size() + " " + rp);

        }
    } catch (Exception e){
        log.debug("Error in findReportElements " + section , e);
        throw e;
    }
        log.debug("leaving findReportElements " + section);
    }

    public void findReportListInSection(RolePermission rolePermission, String section) {
        try {
            if (section.equals("Transaction Monitoring")) {
                int i = 0;
            }
            List<Report> theReportList = reportList.getReportBySection(section);
            wr.writeSectionRow(section + " drilldown ");
            for (Report aReport : theReportList) {
                String text = aReport.getReportText();
                String displayText = aReport.getReportDisplayText();
                List<WebElement> theReports = null;
                if (displayText.equals("Display the What's Out - Totals by System report")) {
                    theReports = driver.findElements(By.xpath("//span[contains(text(),'Display the What') and contains(text(),'Totals by System')]"));
                } else if (displayText.equals("Display the What's Out - Transaction Details")) {
                    theReports = driver.findElements(By.xpath("//span[contains(text(),'Display the What') and contains(text(),'Transaction Details')]"));
                } else {
                    theReports = driver.findElements(By.xpath("//span[contains(text(), '" + displayText + "'  ) ]"));
                }
                boolean rp = rolePermission.findPermissionByString(text);


                wr.writeSubRow(displayText, rp, theReports.size(), "");


            }
        } catch (Exception e){
            log.debug("Error in findReportListInSection " + section , e);
            throw e;
        }
        log.debug("leaving findReportListInSection " + section);
    }

    public void findReportElements(RolePermission rolePermission) {
        for (Report aReport : reportList.getTheReports()) {
            String text = aReport.getReportText();
            List<WebElement> theReport = null;

            theReport = driver.findElements(By.xpath("//*[text() = '" + text + "']"));

            boolean good = rolePermission.findPermissionByString(text);
            log.debug("Report search " + text + " " + theReport.size() + " " + good);

        }

    }

}
