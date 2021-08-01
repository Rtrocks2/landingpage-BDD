package webTest;

import org.testng.annotations.DataProvider;

public class TestData {
	String Male = "//*[@id=\"onlinetermWrapper\"]/div[5]/div/div[2]/div[2]/div[1]/ul/li[1]/label/input";
	String Female = "//*[@id=\"onlinetermWrapper\"]/div[5]/div/div[2]/div[2]/div[1]/ul/li[2]/label/input";
	String Other = "//*[@id=\"onlinetermWrapper\"]/div[5]/div/div[2]/div[2]/div[1]/ul/li[3]/label/input";
	String Smoker = "//*[@id=\"onlinetermWrapper\"]/div[5]/div/div[2]/div[1]/div[2]/div/label/div";
	
	
	@DataProvider(name = "user-data")
	Object[][] testData() {
		return new Object [][] {
			{"16","06","1995",Smoker,Male,"14,160","50000000","30"},
			{"15","08","1997","",Female,"5,900","15000000","25"},
			{"20","10","2000","",Other,"5,900","75000000","28"}
	};
	
}
	}

