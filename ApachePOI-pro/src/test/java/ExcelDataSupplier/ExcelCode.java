package ExcelDataSupplier;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCode {
    public static void main(String[] args) throws IOException {
    	String filePath = "C://Users//MRIDUL//eclipse//myworkspace//ApachePOI-pro//src//test//resources//ExcelData.xlsx";
        
    	        FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fis);

               Sheet sheet = workbook.getSheetAt(0); //used to select the first sheet in the workbook

               //first row
               int headerRow = 0;

               DataFormatter dataFormatter = new DataFormatter(); //used to format the data in cells accordingly

               for (Row row : sheet) {
                   if (row.getRowNum() == headerRow) {
                       continue; // Skip the header row
                   }

                   Cell empNoCell = row.getCell(0);
                   Cell empNameCell = row.getCell(1);
                   Cell empDesignationCell = row.getCell(2);
                   Cell empSalaryCell = row.getCell(3);
                   Cell empDepartmentCell = row.getCell(4);

                   int empNo = (int) empNoCell.getNumericCellValue(); //casting double to int  
                   //String empNo = dataFormatter.formatCellValue(empNoCell); //formatting the cell value from double to string
                   String empName = empNameCell.getStringCellValue();
                   String empDesignation = empDesignationCell.getStringCellValue();
                   int empSalary =(int) empSalaryCell.getNumericCellValue(); // casting double to int 
                   String empDepartment = empDepartmentCell.getStringCellValue();

                   // Checking whether the cell data is numeric or string and formatting accordingly
                   /*if (empSalaryCell.getCellType() == CellType.NUMERIC) {
                       empSalary = empSalaryCell.getNumericCellValue();
                   } else if (empSalaryCell.getCellType() == CellType.STRING) {
                           empSalary = Double.parseDouble(dataFormatter.formatCellValue(empSalaryCell));
                   } else {
                       empSalary = 0.0; // Set default value for other cell types
                   } */

                   System.out.println("EMP No: " + empNo);
                   System.out.println("EMP Name: " + empName);
                   System.out.println("EMP Designation: " + empDesignation);
                   System.out.println("EMP Salary: " + empSalary);
                   System.out.println("EMP Department: " + empDepartment);
                   System.out.println("----------------------------------------------");
               }
       }  
}
                                                     
    	
    	
    	
    	           
    	
    	
    	  /*     // *************************CODE TO DISPLAY THE OUTPUT IN A TABLE FORMAT***********************************
    	   
    	   
    	   
    	        FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fis);

               Sheet sheet = workbook.getSheetAt(0);

               // first row
               int headerRow = 0;

               DataFormatter dataFormatter = new DataFormatter();

               for (Row row : sheet) {
                   if (row.getRowNum() == headerRow) {
                       continue; // Skip the header row
                   }

                   Cell empNoCell = row.getCell(0);
                   Cell empNameCell = row.getCell(1);
                   Cell empDesignationCell = row.getCell(2);
                   Cell empSalaryCell = row.getCell(3);
                   Cell empDepartmentCell = row.getCell(4);

                   int empNo = (int) empNoCell.getNumericCellValue(); //casting double to int  
                   //String empNo = dataFormatter.formatCellValue(empNoCell); //formatting the cell value from double to string
                   String empName = empNameCell.getStringCellValue();
                   String empDesignation = empDesignationCell.getStringCellValue();
                   int empSalary =(int) empSalaryCell.getNumericCellValue(); // casting double to int 
                   String empDepartment = empDepartmentCell.getStringCellValue();

                   // Checking whether the cell data is numeric or string and formatting accordingly
                   if (empSalaryCell.getCellType() == CellType.NUMERIC) {
                       empSalary = empSalaryCell.getNumericCellValue();
                   } else if (empSalaryCell.getCellType() == CellType.STRING) {
                           empSalary = Double.parseDouble(dataFormatter.formatCellValue(empSalaryCell));
                   } else {
                       empSalary = 0.0; // Set default value for other cell types
                   } 

                   // print in table format
                  // System.out.printf("| %-6s | %-20s | %-20s | %-12s | %-15s |%n",
                           //empNo, empName, empDesignation, empSalary, empDepartment);
               //}

               //System.out.println("+--------+----------------------+----------------------+--------------+-----------------+");
           
       }
   }            
   
   */

