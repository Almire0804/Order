package com.app.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.pages.GasMileageCalculatorPage;
import com.app.utilities.Driver;
import com.app.utilities.configReader;

public class BasicDataDrivenTest {

	WebDriver driver;
	Workbook workbook;
	Sheet worksheet;
	FileInputStream inStream;
	FileOutputStream outStream;
	GasMileageCalculatorPage page;
	public static final int CURRENTOD_COLNUM = 1;
	public static final int PREVIOUSOD_COLNUM = 2;
	public static final int GAS_COLNUM = 3;

	@BeforeClass
	public void setUp() throws Exception {
		inStream = new FileInputStream(configReader.getProperty("gasmileage.testdata.path"));
		workbook = WorkbookFactory.create(inStream);
		worksheet = workbook.getSheetAt(0);
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://www.calculator.net/gas-mileage-calculator.html");
		page = new GasMileageCalculatorPage();
	}

	@AfterClass
	public void tearDown() throws Exception {
		outStream = new FileOutputStream(configReader.getProperty("gasmileage.testdata.path"));
		workbook.write(outStream);
		outStream.close();
		inStream.close();
		workbook.close();
		driver.close();
	}

	@Test
	public void dataDrivenMileageCalculatorTest() {

		for (int rownum = 1; rownum < worksheet.getPhysicalNumberOfRows(); rownum++) {
			Row currentRow = worksheet.getRow(rownum);
			
			//check the control column. If it does not say Y, then skip this row
			if(!currentRow.getCell(0).toString().equalsIgnoreCase("Y")) {
				if(currentRow.getCell(6) == null) {
					currentRow.createCell(6);
				}
				currentRow.getCell(6).setCellValue("Skip Requested");
				continue;
			}
			
			double currentOd = currentRow.getCell(CURRENTOD_COLNUM).getNumericCellValue();
			double previousOd = currentRow.getCell(PREVIOUSOD_COLNUM).getNumericCellValue();
			double gas = currentRow.getCell(GAS_COLNUM).getNumericCellValue();

			page.currentOdometer.clear();
			page.currentOdometer.sendKeys(String.valueOf(currentOd));

			page.previousOdometer.clear();
			page.previousOdometer.sendKeys(String.valueOf(previousOd));

			page.gas.clear();
			page.gas.sendKeys(String.valueOf(gas));
			page.calculate.click();

			String result = page.result.getText().replaceAll(",", "").split(" ")[0];
			System.out.println(result);
			
			//write result to ACTUAL RESULT column
			if(currentRow.getCell(5) == null) {
				currentRow.createCell(5);
			}
			currentRow.getCell(5).setCellValue(result);
			
			
			double calculationResult = (currentOd - previousOd) / gas;

			DecimalFormat format = new DecimalFormat("#0.00");

			String expected = format.format(calculationResult);
			System.out.println(expected);
			
			//write result to expected RESULT column
			if(currentRow.getCell(4) == null) {
				currentRow.createCell(4);
			}
			currentRow.getCell(5).setCellValue(expected);
		
			assertEquals(result, expected);
			
			if(currentRow.getCell(6) == null) {
				currentRow.createCell(6);
			}
			//write Pass or Fail to Status column
			if(result.equals(format.format(calculationResult))) {
				System.out.println("Pass");
				currentRow.getCell(6).setCellValue("Pass");
			}else {
				System.out.println("Fail");
				currentRow.getCell(6).setCellValue("Fail");
			}
			
			//write current time
			if(currentRow.getCell(7) == null) {
				currentRow.createCell(7);
			}
			
			currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());
			

		}
		
	
	}
}
