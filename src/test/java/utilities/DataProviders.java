package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Data Provider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception {
		String path = ".\\testData\\Opencart_LoginData.xlsx"; // taking xl from testData

		ExcelUtility xlUtil = new ExcelUtility(path); // creating an object for excel utility
		// totalRows and totalCol is to create 2 dimension array
		int totalRows = xlUtil.getRowCount("Sheet1");
		int totalCol = xlUtil.getCellCount("Sheet1", 1);

		// 2 dimension array
		String loginData[][] = new String[totalRows][totalCol];

		for (int i = 1; i <= totalRows; i++) { // rows
			for (int j = 0; j <= totalCol - 1; j++) { // columns
				// As i index is starting from 1, no need to start from 1st index in array.
				// Start from 0 itself (if we use same in array 0th row position will go waste)
				loginData[i - 1][j] = xlUtil.getCellData("Sheet1", i, j);
			}
		}

		return loginData; // returning 2 dimension array
	}

}
