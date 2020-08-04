package obieeReportsTests;

import obieeReportsBase.TestBaseReports;

import obieeReportsUtilities.RolePermission;
import obieeReportsUtilities.TestUtilReports;
import obieeReportsUtilities.WriteResults;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


	@BeforeClass
	public void runBeforeClass() {
		log.debug("0 ====== Report ARoleTest =======================================");
		super.setTheTest("ARoleTest");
		wr = new WriteResults("ARoleTest.html",true);
		//wr.pageHeader();
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	//@Test
	public void ARoleTest(RolePermission rolePermission) throws InterruptedException {


		//setRoleInDB(rolePermission.getRoleName());


		log.debug("=== run before class  =======" + rolePermission.getRoleName() );
		runBeforeClass();
		log.debug("=== calling setup ============================");
		super.setUp(rolePermission);


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String theTestValue = this.getTheTest();
		log.debug("Report ARoleTest: " + rolePermission.getRoleName());
		//log.debug("Report ARoleTest: " + config.getProperty("reportRequested"));
		//log.debug("Going into Traveler & User Information section");

		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wr.openTable(rolePermission.getRoleName(),roleCount++,rolePermission.getUserName());
		List<WebElement> theEle0 = driver.findElements(By.xpath("//*[text() = 'Trip & Document Status']"));
		log.debug("List of Trip & Document Status " + theEle0.size());
		wr.writeRow("Trip & Document Status", rolePermission.isTripDocumentStatus(), theEle0.size(), "");


		List<WebElement> theEle1 = driver.findElements(By.xpath("//*[text() = 'Document Details']"));
		log.debug("List of Document Details " + theEle1.size());
		wr.writeRow("Document Details", rolePermission.isTripDocumentStatus(), theEle1.size(), "");

		List<WebElement> theEle2 = driver.findElements(By.xpath("//*[text() = 'Traveler & User Information']"));
		log.debug("List of Traveler & User Information " + theEle2.size());
		wr.writeRow("Traveler & User Information", rolePermission.isTravelerUserInformation(), theEle2.size(), "");

		List<WebElement> theEle3 = driver.findElements(By.xpath("//*[text() = 'Tickets']"));
		log.debug("List of Tickets " + theEle3.size());
		wr.writeRow("Tickets", rolePermission.isTickets(), theEle3.size(), "");

		List<WebElement> theEle4 = driver.findElements(By.xpath("//*[text() = 'Military Information']"));
		log.debug("List of Military Information " + theEle4.size());
		wr.writeRow("Military Information", rolePermission.isMilitaryInformation(), theEle4.size(), "");

		List<WebElement> theEle5 = driver.findElements(By.xpath("//*[text() = 'Expenses']"));
		log.debug("List of Expenses  " + theEle5.size());
		wr.writeRow("Expenses", rolePermission.isExpenses(), theEle5.size(), "");

		List<WebElement> theEle6 = driver.findElements(By.xpath("//*[text() = 'Lodging']"));
		log.debug("List of Lodging " + theEle6.size());
		wr.writeRow("Lodging", rolePermission.isLodging(), theEle6.size(), "");

		List<WebElement> theEle7 = driver.findElements(By.xpath("//*[text() = 'Debt Management']"));
		log.debug("List of Debt Management " + theEle7.size());
		wr.writeRow("Debt Management", rolePermission.isDebtManagement(), theEle7.size(), "");

		List<WebElement> theEle8 = driver.findElements(By.xpath("//*[text() = 'Transaction Monitoring']"));
		log.debug("List of Transaction Monitoring " + theEle8.size());
		wr.writeRow("Transaction Monitoring", rolePermission.isTransactionMonitoring(), theEle8.size(), "");


		wr.closeTable();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//WebElement ti = driver.findElement(By.xpath("//span[text()[contains(.,'Traveler & User Information Dashboard')]]"));
		//ti.click();

		log.debug("Try ARoleTest  0");

		log.debug("Try ARoleTest theTestValue: " + theTestValue);
		driver.findElement(By.xpath("//*[@id=\'logout\']")).click();
		driver.close();
		log.debug("Report ARoleTest Complete ##########################");
	}


}
