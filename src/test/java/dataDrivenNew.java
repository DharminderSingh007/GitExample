import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenNew {

	public ArrayList<String> getdata(String TestCaseName) throws IOException
	{
		
		ArrayList<String> a= new ArrayList<String>();  // Create an array list to send all the below data into a list form.
		
		// TODO Auto-generated method stub
        // Common template for Automating test cases from Excel for anytype of job.
		//FileInputStream fis= new FileInputStream("C://udemy//excelldata.xlsx");
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir"+"\\ExcellDrivenNew\\src\\test\\resources/excelldata.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets= workbook.getNumberOfSheets();
		int i=0;
		for (i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Testdata"))
			{
			XSSFSheet sheet= workbook.getSheetAt(i);      // Sheet has all the rows.
			//Identify Testcases column by scanning the entire 1st row
			Iterator<Row> rows= sheet.iterator();        // Now the object row has all the ability to iterate though all the rows.
		    Row firstrow= rows.next();                   // rows.next will trigger to move to the first row. Now we the access to specific Row.
		    Iterator<Cell> ce= firstrow.cellIterator();  // rows.next will trigger to move to the first Cell. Now we the access to specific Cell.
		    int k=0;
		    int column = 0;
		    while(ce.hasNext())                         // To read eacch cell value and compare the with Desired one in this case Testcases use while loop.
		    {
		    	 Cell value= ce.next();
		    	if (value.getStringCellValue().equalsIgnoreCase("Testcases"))
		    	{
		    		
		    		column=k;
		    	}
		    		k++;
		    		
		    }
		    System.out.println(column);                // untill this code we have identified fist column.
		    while(rows.hasNext())                      //Once column is identied then scan the entire column to identify purchase testcase row.
		    {
		    	Row r= rows.next();
		           if( r.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName))
		           {
		        	  Iterator<Cell>cv= r.cellIterator();
		        	  while(cv.hasNext())
		        	  {
		        		  Cell c=cv.next();		 
		        		  if(c.getCellTypeEnum()==CellType.STRING)
		        		  {
		        		a.add(c.getStringCellValue());
		        		  }
		        		  else {
		        			 a.add(NumberToTextConverter.toText(c.getNumericCellValue())); // To convert any string value to integer.
		        			  
		        		  }
		        		//System.out.println(a);
		        	  }
		           }
		        
		    }
			}
			
		}
		return a;
	
		
		
	}
	
		public static void main(String[] args) throws IOException {
		

		
	}

}
