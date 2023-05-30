package DataProviders;

import org.testng.annotations.DataProvider;

public class ProductDataProvider {

	@DataProvider
	public Object[][] getProductSearchKeyData() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
	@DataProvider
	public Object[][] getProductdata(){
		return new Object[][] {
			{"Macbook","MacBook Pro"},
			{"iMac","iMac"},
			{"Samsung","Samsung SyncMaster 941BW"},
			{"Samsung","Samsung Galaxy Tab 10.1"}
		};
		
	}
	
	@DataProvider
	public Object[][] getProductImagesTestdata(){
		return new Object[][] {
			{"Macbook","MacBook Pro",4},
			{"iMac","iMac",3},
			{"Samsung","Samsung SyncMaster 941BW",1},
			{"Samsung","Samsung Galaxy Tab 10.1",7}
		};
	}
}
