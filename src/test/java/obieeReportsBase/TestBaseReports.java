package obieeReportsBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import obieeReportsUtilities.RolePermission;
import obieeReportsUtilities.WriteResults;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import obieeReportsUtilities.ExcelReader1;

public class TestBaseReports {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("TestBaseReports");
	public static String user_dir = System.getProperty("user.dir");
	public static ExcelReader1 excel = new ExcelReader1(
			user_dir + "\\src\\test\\resources\\obieeReportsExcel\\OBIEE_Role_Permission_Matrix_v1.1.xlsx");
	public static WebDriverWait wait;

	public String theTest = null;
	public WriteResults wr = null;
	public int roleCount = 1;

	@BeforeSuite
	public void resources()  {
		log.debug("TestBaseReports resources() start ");


        log.debug("The User_dir " + user_dir);
		try {
			fis = new FileInputStream(user_dir + "\\src\\test\\resources\\obieeReportsProperties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		wr = new WriteResults("ARoleTest.html", false);
		wr.pageHeader();


		log.debug("TestBaseReports resources() exit ");
	}


	public void setUp(RolePermission rolePermission)  {
		log.debug("TestBaseReports setup()  " + theTest);

        driver= null;
        if (driver == null) {
			switch (config.getProperty("browser")) {
				case "chrome":
					try {
						System.setProperty("webdriver.chrome.driver", user_dir + "/src/test/resources/SeleniumWebDrivers/chromedriver.exe");
						driver = new ChromeDriver();
						driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
						log.debug("Chrome browser launched");
					} catch (Exception e) {
						System.out.println("Error caught");
						log.error("Error ", e);

					}

					break;
				case "edge":

					System.setProperty("webdriver.edge.driver", user_dir + "/src/test/resources/SeleniumWebDrivers/msedgedriver.exe");
					driver = new EdgeDriver();
					log.debug("Edge browser launched");

					break;
				case "firefox":

					System.setProperty("webdriver.gecko.driver", user_dir + "/src/test/resources/SeleniumWebDrivers/geckodriver.exe");
					driver = new FirefoxDriver();
					log.debug("Firefox browser launched");

					break;
			}
		}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(config.getProperty("testingurl"));

			log.debug("Navigated to " + config.getProperty("testingurl"));

			driver.manage().window().maximize();

			//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//*[@id='idUser']")).sendKeys(config.getProperty("userID"));
			//.findElement(By.xpath("//*[@id=\'idPassword\']")).sendKeys(config.getProperty("password"));
			//driver.findElement(By.xpath("//*[@id=\'btn_login\']")).click();
			String actualRoleName = signIn(rolePermission);
			log.debug("Logging in OBIEE " + theTest + " theRole " + actualRoleName + " deisred Role Name " + rolePermission.getRoleName());

			//String theRoleByHtml = checkTheRole(rolePermission);


			WebElement dashbd = driver.findElement(By.xpath("//*[text() = 'Dashboards']"));
			dashbd.click();
			WebElement dtshome = driver.findElement(By.xpath("//*[text() = 'DTS Reports Home']"));

			driver.findElement(By.xpath("//*[text() = 'DTS Reports Home']")).click();
			log.debug("Inside OBIEE");


			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 10);
			log.debug("TestBaseReorts setup() start");



	}

	public void click(String locator) {

		if (locator.endsWith("_css")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_xpath")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_id")) {

			driver.findElement(By.id(OR.getProperty(locator))).click();

		}

		log.debug("Clicking on: " + locator);

	}

	public void type(String locator, String value) {

		if (locator.endsWith("_css")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_xpath")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_id")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);

		}

		log.debug("Typing in: " + locator + ". Entered value as " + value);

	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_css")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_xpath")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_id")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator)));

		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from dropdown: " + locator + " value as " + value);

	}

	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public String getTheTest() {
		return theTest;
	}

	public void setTheTest(String theTest) {
		this.theTest = theTest;
	}

	public String checkTheRole(RolePermission rolePermission,String userName) {

        String desiredRole = rolePermission.getRoleName().trim();
        String actualRoleName = null;
		WebElement signedIn = driver.findElement((By.xpath("//*[text() = '"+userName+"']")));
		signedIn.click();
		WebElement myAccount = driver.findElement((By.xpath("//*[text() = 'My Account']")));
		myAccount.click();
		WebElement appRoles = driver.findElement((By.xpath("//*[text() = 'Application Roles']")));
		appRoles.click();


		try {
			WebElement theRole = driver.findElement((By.xpath("//*[text() = '"+ desiredRole+"']")));
			actualRoleName = theRole.getText().trim();
			log.debug("Found the Role is " + actualRoleName + " Should Match " + rolePermission.getRoleName());
		} catch (Exception e) {
			log.error("Exception in TestBaseReports.checkTheRole " , e);
		}
		if (!desiredRole.equals(actualRoleName)) actualRoleName = null;
		driver.findElement((By.xpath("//*[text() = 'OK']"))).click();

        return actualRoleName;
	}

	public String  signIn(RolePermission rolePermission){

		// This will signIn to account in ThisCase the roleName being tested
		String perRoleName = rolePermission.getRoleName();

		String userName = config.getProperty(perRoleName);
        rolePermission.setUserName(userName);

		String actualRoleName = null;

		int loop = 0;
		//while (!perRoleName.equals(actualRoleName)){
			//loop++;

			// Login to the user which is the same as RoleName
			// First Login
			driver.findElement(By.xpath("//*[@id='idUser']")).sendKeys(userName.trim());

			//driver.findElement(By.xpath("//*[@id='idUser']")).sendKeys(config.getProperty("userID"));
			driver.findElement(By.xpath("//*[@id=\'idPassword\']")).sendKeys(config.getProperty("password").trim());
			driver.findElement(By.xpath("//*[@id=\'btn_login\']")).click();
            log.debug("Logging in as --"+ userName  + "--");
			//actualRoleName = checkTheRole(rolePermission,userName);
			//if (actualRoleName == null) {
			//	driver.findElement(By.xpath("//*[@id=\'logout\']")).click();
			//	log.debug(loop + " NOT THE CORRECT USER " + perRoleName + " != " + actualRoleName);
			//	try {
			//		Thread.sleep(20000);
			//	}catch (Exception e){}
			//}

			//if (loop > 10)break;
		//}


		return actualRoleName;

	}

}