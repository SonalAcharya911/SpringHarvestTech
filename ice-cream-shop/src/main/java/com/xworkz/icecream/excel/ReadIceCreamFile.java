package com.xworkz.icecream.excel;

import com.xworkz.icecream.dto.OrderDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReadIceCreamFile {
    public static Collection<OrderDTO> readFileData(String filename){
        Collection<OrderDTO> orderDTOS=new ArrayList<>();

        try{
            FileInputStream fis=new FileInputStream(filename);
            if(fis==null){
                System.out.println("file not loaded");
            }
            else{
                System.out.println("file loaded...");
            }

            Workbook workbook=null;

//            =new XSSFWorkbook(fis);
            if(filename.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
                System.out.println("workbook xlsx created..");
            }else if(filename.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
                System.out.println("workbook xls created");
            }


            int numberOfSheets=workbook.getNumberOfSheets();

            for(int i=0; i<numberOfSheets;i++){
                Sheet sheet= workbook.getSheetAt(i);

                Iterator<Row> rowIterator= sheet.iterator();

                while(rowIterator.hasNext()){
                    String name="";
                    String flavour="";
                    int quantity=0;
                    boolean takeAway=false;
                    String addOn="";
                    String couponCode="";

                    Row row=rowIterator.next();
                    Iterator<Cell> cellIterator=row.cellIterator();


                    while(cellIterator.hasNext()){
                        Cell cell= cellIterator.next();
//                        switch(cell.getCellType()){
//                            case Cell.CELL_TYPE_STRING:
//                                if(name.equalsIgnoreCase("")){
//                                    name=cell.getStringCellValue().trim();
//                                } else if (flavour.equalsIgnoreCase("")) {
//                                    flavour=cell.getStringCellValue().trim();
//                                } else if (addOn.equalsIgnoreCase("")) {
//                                    addOn= cell.getStringCellValue();
//                                } else if (couponCode.equalsIgnoreCase("")) {
//                                    couponCode= cell.getStringCellValue();
//                                }
//                                else{
//                                    System.out.println("nothing else");
//                                }
//
//                            case Cell.CELL_TYPE_NUMERIC:
//                                if(quantity==0){
//                                    quantity=(int) cell.getNumericCellValue();
//                                }
//                                else{
//                                    System.out.println("nothing else");
//                                }
//
//                            case Cell.CELL_TYPE_BOOLEAN:
//                                if(takeAway==false){
//                                    takeAway= cell.getBooleanCellValue();
//                                }
//                                else{
//                                    System.out.println("over....");
//                                }
//
//                            default:
//                                System.out.println("none match...no data");
//                        }
                        switch(cell.getColumnIndex()){
                            case 0:
                                name=cell.getStringCellValue();
                                break;
                            case 1:
                                flavour=cell.getStringCellValue();
                                break;
                            case 2:
                                quantity=(int)cell.getNumericCellValue();
                                break;
                            case 3:
                                takeAway=cell.getBooleanCellValue();
                                break;
                            case 4:
                                addOn=cell.getStringCellValue();
                                break;
                            case 5:
                                couponCode=cell.getStringCellValue();
                                break;
                            default:
                                System.out.println("none match");
                        }
                    }
//                    OrderDTO orderDTO=new OrderDTO(name,flavour,quantity,takeAway,addOn,couponCode);
//                    orderDTOS.add(orderDTO);
                }
            }

            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return orderDTOS;
    }
}
