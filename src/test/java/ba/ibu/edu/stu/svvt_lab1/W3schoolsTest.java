package ba.ibu.edu.stu.svvt_lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class W3schoolsTest {
	
	private static WebDriver webDriver;
	private static String baseUrl;
	

	@BeforeAll
	static void setUpBeforeAll() {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Chrome driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.w3schools.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Disabled
	@Order(1)
	@Test
	void NavBarLinksTest() throws InterruptedException {
		
		webDriver.get(baseUrl);
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"navbtn_tutorials\"]")).click();
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"nav_tutorials\"]/div/div/div[2]/a[1]")).click();
		Thread.sleep(750);
		String tutorials = webDriver.getCurrentUrl();
		webDriver.findElement(By.xpath("//*[@id=\"navbtn_references\"]")).click();
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"nav_references\"]/div/div/div[2]/a[1]")).click();
		Thread.sleep(750);
		String references = webDriver.getCurrentUrl();
		webDriver.findElement(By.xpath("//*[@id=\"navbtn_exercises\"]")).click();
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"nav_exercises\"]/div/div/div[2]/a[1]")).click();
		Thread.sleep(750);
		String exercises = webDriver.getCurrentUrl();
		assertEquals("https://www.w3schools.com/html/default.asp", tutorials);
		assertEquals("https://www.w3schools.com/tags/default.asp", references);
		assertEquals("https://www.w3schools.com/html/html_exercises.asp", exercises);
		
		
	}
	@Disabled
	@Order(2)
	@Test
	void EmptySignUpTest() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(750);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/a[4]")).click();
		Thread.sleep(750);
		
		webDriver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[1]/div/a")).click();
		Thread.sleep(750);
		
		webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[1]/div/div[5]/div[1]/button")).click();
		Thread.sleep(750);
		
		WebElement emailTextTest = webDriver.findElement(By.xpath("//*[@id=\"root\"]/"
				+ "div/div/div[4]/div[1]/div/div[2]/form/div[1]/span"));
		Thread.sleep(750);
		
		String emailText = emailTextTest.getText();
		Thread.sleep(750);
		
		assertEquals("Please enter an email", emailText);
		

		
	}
	@Disabled
	@Order(3)
	@Test
	void SearchBarTest() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"nav_search_btn\"]")).click();
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"gsc-i-id1\"]")).sendKeys("Java");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"___gcse_0\"]/div/div/form/table/tbody/tr/td[2]/button")).click();
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div[1]/div[6]/div[2]/div/div/div[1]/div[1]"
				+ "/div[1]/div[1]/div/a")).click();
		Thread.sleep(750);
		String searchResult1 = webDriver.getCurrentUrl();
		webDriver.get(baseUrl);
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"search2\"]")).sendKeys("Java");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"learntocode_searchbtn\"]")).click();
		Thread.sleep(750);
		String searchResult2 = webDriver.getCurrentUrl();
		assertNotEquals(searchResult1, searchResult2);
	}

	@Disabled
	@Order(4)
	@Test
	void PositiveInputExerciseTest() throws InterruptedException {
		webDriver.get("https://www.w3schools.com/html/html_exercises.asp");
		Thread.sleep(750);
		
		//Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();
		//Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;
		//Click the link which opens in a new window
		webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/p[2]/a")).click();
		//Wait for the new window or tab
		Thread.sleep(1500);
		//Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        webDriver.switchTo().window(windowHandle);
		        break;
		    }
		}
		webDriver.findElement(By.xpath("//*[@id=\"assignmentcontainer\"]/input")).sendKeys("title");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"answerbutton\"]")).click();
		WebElement correct = webDriver.findElement(By.xpath("//*[@id=\"assignmentCorrect\"]/h2"));
		Thread.sleep(750);
		String correctText = correct.getText();
		assertEquals("Correct!", correctText);
		
	}
	@Disabled
	@Order(5)
	@Test
	void NegativeInputExerciseTest() throws InterruptedException {
		webDriver.get("https://www.w3schools.com/html/html_exercises.asp");
		Thread.sleep(750);
		//Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();
		//Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;
		//Click the link which opens in a new window
		webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/p[2]/a")).click();
		//Wait for the new window or tab
		Thread.sleep(1500);
		//Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        webDriver.switchTo().window(windowHandle);
		        break;
		    }
		}
		webDriver.findElement(By.xpath("//*[@id=\"assignmentcontainer\"]/input")).sendKeys("sdaf");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"answerbutton\"]")).click();
		WebElement incorrect = webDriver.findElement(By.xpath("//*[@id=\"assignmentNotCorrect\"]/h2"));
		Thread.sleep(750);
		String incorrectText = incorrect.getText();
		assertEquals("Not Correct", incorrectText);
	}
	@Disabled
	@Order(6)
	@Test
	void ShoppingCartTest() throws InterruptedException {
		webDriver.get("https://www.w3schools.com");
		Thread.sleep(750);
		
		//Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();
		//Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;
		//Click the link which opens in a new window
		webDriver.findElement(By.xpath("//*[@id=\"cert_navbtn\"]")).click();
		//Wait for the new window or tab
		Thread.sleep(1500);
		//Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        webDriver.switchTo().window(windowHandle);
		        break;
		    }
		}
		Select selectSearch = new Select(webDriver.findElement(By.xpath("//*[@id=\"sh"
				+ "opify-section-static-header\"]/div[1]/div[1]/div[2]/form/div[1]/span/select")));
			
		selectSearch.selectByIndex(3);
		Thread.sleep(750);
		
		webDriver.findElement(By.xpath("//*[@id=\"shopify-section-static-header\"]"
				+ "/div[1]/div[1]/div[2]/form/div[1]/input")).sendKeys("Java");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"shopify-section-static-header\"]"
				+ "/div[1]/div[1]/div[2]/form/div[1]/button[2]")).click();
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"shopify-section-template--1541504"
				+ "4374585__main\"]/div[1]/div/ul/li[1]/div/div/div[1]/a/figure")).click();
		Thread.sleep(1500);
		Select selectQuantity = new Select(webDriver.findElement(By.xpath("//*[@id=\"product-quantity-select\"]")));
		
		WebElement coursePrice = webDriver.findElement(By.xpath("//*[@id=\"shopify-section"
				+ "-template--15415044243513__main\"]/section/article/div[2]/div/div[2]/div/div/div[4]/span[2]"));
		
		int course = (int) Float.parseFloat(coursePrice.getText().replace("$",""));
		
		selectQuantity.selectByValue("3");
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"product_form_5859265380409\"]/div[1]/button")).click();
		Thread.sleep(750);
		WebElement sub = webDriver.findElement(By.xpath("//*[@id=\"shopify-section-template--15415"
				+ "043850297__main\"]/form/section/div/div/div[1]/div/span[2]"));
		int subtotal = (int) Float.parseFloat(sub.getText().replace("$",""));
		assertEquals(course * 3, subtotal);
		Thread.sleep(1500);
	}

	@Order(7)
	@Test
	void ExerciseSelectionTest() throws InterruptedException {
		webDriver.get("https://www.w3schools.com/html/html_exercises.asp");
		Thread.sleep(750);
		
		//Store the ID of the original window
		String originalWindow = webDriver.getWindowHandle();
		//Check we don't have other windows open already
		assert webDriver.getWindowHandles().size() == 1;
		//Click the link which opens in a new window
		webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/p[2]/a")).click();
		//Wait for the new window or tab
		Thread.sleep(1500);
		//Loop through until we find a new window handle
		for (String windowHandle : webDriver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        webDriver.switchTo().window(windowHandle);
		        break;
		    }
		}
		
		WebElement completionBefore = webDriver.findElement(By.xpath("//*[@id=\"completedExercisesNo\"]"));
		String completionTextBefore = completionBefore.getText();
		webDriver.findElement(By.xpath("//*[@id=\"exercisemenu\"]/div[4]/div[1]/div[2]/a[1]")).click();
		Thread.sleep(1200);
		webDriver.findElement(By.xpath("//*[@id=\"exercisemenu\"]/div[4]/div[1]/div[2]/a[2]")).click();
		Thread.sleep(1200);
		webDriver.findElement(By.xpath("//*[@id=\"exercisemenu\"]/div[4]/div[1]/div[2]/a[3]")).click();
		Thread.sleep(1200);
		webDriver.findElement(By.xpath("//*[@id=\"exercisemenu\"]/div[4]/div[1]/div[2]/a[4]")).click();
		Thread.sleep(1200);
		webDriver.findElement(By.xpath("//*[@id=\"exercisemenu\"]/div[4]/div[2]/div[1]")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"exercisemenu\"]/div[4]/div[2]/div[2]/a[1]")).click();
		Thread.sleep(1200);
		WebElement completionAfter = webDriver.findElement(By.xpath("//*[@id=\"completedExercisesNo\"]"));
		String completionTextAfter = completionAfter.getText();
		webDriver.findElement(By.xpath("//*[@id=\"exercisemenu\"]/div[1]/div[2]/span")).click();
		Thread.sleep(1200);
		webDriver.findElement(By.xpath("//*[@id=\"id01\"]/div/div/button[1]")).click();
		Thread.sleep(1200);
		assertEquals(completionTextBefore, completionTextAfter);
		
		
		//The test has passed since the number of completed tasks does not change regardless if we skipped or not
		
	}
	
	@Disabled
	@Order(8)
	@Test
	void QuizTest() throws InterruptedException {
		webDriver.get("https://www.w3schools.com/quiztest/default.asp");
		webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/div/div[2]/a")).click();
		Thread.sleep(750);
		for (int i = 0; i < 40; i++) {
			try {
				webDriver.findElement(By.xpath("//*[@id=\"label3\"]")).click();
				Thread.sleep(1500);
				webDriver.findElement(By.xpath("//*[@id=\"answerbuttoncontainer\"]/button")).click();
				Thread.sleep(1500);
				
			}catch (Exception ex) {
				webDriver.findElement(By.xpath("//*[@id=\"label2\"]")).click();
				Thread.sleep(1500);
				webDriver.findElement(By.xpath("//*[@id=\"answerbuttoncontainer\"]/button")).click();
				Thread.sleep(1500);
			}
		}
		
		WebElement result1 = webDriver.findElement(By.xpath("//*[@id=\"quizcontainer\"]/div[1]/p[1]"));
		String resultText1 = result1.getText();
		webDriver.findElement(By.xpath("//*[@id=\"quizcontainer\"]/form/input[7]")).click();
		Thread.sleep(1000);
		for (int i = 0; i < 40; i++) {
					try {
						webDriver.findElement(By.xpath("//*[@id=\"label3\"]")).click();
						Thread.sleep(1500);
						webDriver.findElement(By.xpath("//*[@id=\"answerbuttoncontainer\"]/button")).click();
						Thread.sleep(1500);
					}catch (Exception ex) {
						webDriver.findElement(By.xpath("//*[@id=\"label2\"]")).click();
						Thread.sleep(1500);
						webDriver.findElement(By.xpath("//*[@id=\"answerbuttoncontainer\"]/button")).click();
						Thread.sleep(1500);
					}
				}
		WebElement result2 = webDriver.findElement(By.xpath("//*[@id=\"quizcontainer\"]/div[1]/p[1]"));
		String resultText2 = result2.getText();
		assertEquals(resultText1, resultText2);
	}
	
	@Disabled
	@Order(9)
	@Test
	void LoginTest() throws InterruptedException {
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.xpath("//*[@id=\"w3loginbtn\"]")).click();
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"modalusername\"]")).sendKeys("adnanselimovic33@gmail.com");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"current-password\"]")).sendKeys("Projectsignup1$");
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[1]/div/div[4]/div[1]/button")).click();
		Thread.sleep(2000);
		
		
		//Test failed, could not login for whatever reason
		

	}

	@Disabled
	@Order(10)
	@Test
	void ColorPickerTest() throws InterruptedException {
		webDriver.get("https://www.w3schools.com/colors/colors_picker.asp");
		Thread.sleep(1250);
		
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).sendKeys("Red");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"entercolorDIV\"]/button")).click();
		Thread.sleep(750);
		WebElement red = webDriver.findElement(By.xpath("//*[@id=\"colornamDIV\"]"));
		String redText = red.getText();
		assertEquals("Red", redText);
		Thread.sleep(1250);
		
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).sendKeys("Blue");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"entercolorDIV\"]/button")).click();
		Thread.sleep(750);
		WebElement blue = webDriver.findElement(By.xpath("//*[@id=\"colornamDIV\"]"));
		String blueText = blue.getText();
		assertEquals("Blue", blueText);
		Thread.sleep(1250);
		
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).sendKeys("Yellow");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"entercolorDIV\"]/button")).click();
		Thread.sleep(750);
		WebElement yellow = webDriver.findElement(By.xpath("//*[@id=\"colornamDIV\"]"));
		String yellowText = yellow.getText();
		assertEquals("Yellow", yellowText);
		Thread.sleep(1250);
		
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"entercolor\"]")).sendKeys("Green");
		Thread.sleep(750);
		webDriver.findElement(By.xpath("//*[@id=\"entercolorDIV\"]/button")).click();
		Thread.sleep(750);
		WebElement green = webDriver.findElement(By.xpath("//*[@id=\"colornamDIV\"]"));
		String greenText = green.getText();
		assertEquals("Green", greenText);
		Thread.sleep(1250);
	}
}
