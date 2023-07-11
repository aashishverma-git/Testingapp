package TestCases;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider(name="logindata")
	public Object loginData() {
		Object data[][]= new Object[2][2];
		
		data[0][0]="aashish";
		data[0][1]="verma";
		data[1][0]="Ram";
		data[1][1]="Shyam";
		return data;
		
	}
	
}
