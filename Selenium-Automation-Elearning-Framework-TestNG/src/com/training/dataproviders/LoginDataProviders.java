package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\selenium\\excelsheetstestdata\\RegisterMultipleTeachers.xlsx"; 
		String sheetname="MultipleTeachers";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
		
	}
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\selenium\\excelsheetstestdata\\MultipleCreateUser.xlsx"; 
		String sheetname="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
		
	}
	
	@DataProvider(name = "excel-inputs-error")
	public Object[][] getExcelDataerror(){
		String fileName ="C:\\selenium\\excelsheetstestdata\\RegisterMultipleTeachers.xlsx"; 
		String sheetname="error";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname); 
		
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\selenium\\excelsheetstestdata\\RegisterMultipleTeachers.xlsx", "Sheet1"); 
	}
}
