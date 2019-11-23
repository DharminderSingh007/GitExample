import java.io.IOException;
import java.util.ArrayList;

public class testSampleTocreateMethod {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		dataDrivenNew d= new dataDrivenNew();
		ArrayList data= d.getdata("Login");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(3));
		
		
		// no need to hrda anything you can now basically write anything to excell and grab it into your test case directly. 
		//Instead if going back to test cases and changing the data everyime see the example below.
		//driver.findElement(By.Xpath(locationOf the Element)).Sendkeys(data.get(1));
	}

}
