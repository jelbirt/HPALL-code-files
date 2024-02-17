/*
 * @Author Jacob Elbirt
 * Data cleaning and organization script written for
 * WSU Human Performance and Assisted Learning Lab (HPALL)
 * Fall 2023
 */

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Hashtable;
 import java.util.Scanner;
 
 import org.apache.poi.xssf.usermodel.XSSFCell;
 import org.apache.poi.xssf.usermodel.XSSFRow;
 import org.apache.poi.xssf.usermodel.XSSFSheet;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
 public class CleanData {
         private static FileInputStream fis = null;	
         static ArrayList<String> fileNames = null;
 
     
         public static void main(String[] args) throws Exception {
             
 
             
             String directoryName = "DIRECTORY-NAME";	// TODO : DIRECTORY NAME HERE !
             File dataDir = new File("FILEPATH");
 
             
             File[] dataFileArr = dataDir.listFiles();
             Hashtable<String, String> dataContainer = new Hashtable<String, String>();
             fileNames = new ArrayList<String>();
             for (int i=0; i < dataFileArr.length; ++i) {			
                 File f = dataFileArr[i];
                 String filePath = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\"));
                 if(filePath.substring(filePath.length()-4).equals(".csv")) {
                     String fileName = filePath.substring(0, filePath.length()-4);
                     fileNames.add(fileName);
                     fis = new FileInputStream(filePath);
                     Scanner sc = new Scanner(filePath);  
                     String currVals = sc.next();
                     dataContainer.put(fileName, currVals);
                     
                     fis.close(); sc.close();
                 } else {
                     System.out.println(filePath + " is not a valid .csv file.");
                 }
                 Collections.sort(fileNames);
                 
                 writeToMain(dataContainer, fileNames);
             }
 
 
             
 
         }
         
         public static void readMain() throws FileNotFoundException {
             String mainFileName = "MainData.csv";	// FILL IN FILE NAME
             File mainFile = new File(mainFileName);
             fis = new FileInputStream(mainFileName);
             Scanner sc = new Scanner(mainFile);
             System.out.println(sc.next());
         }
         
         public static void writeToMain(Hashtable<String, String> dataContainer, 
         ArrayList<String> fileNames) throws Exception {
             String mainFileName = "MainData.csv";	// FILL IN FILE NAME
             File mainFile = new File(mainFileName);
             fis = new FileInputStream(mainFileName);
             FileWriter fw = new FileWriter(new File(mainFileName.substring(mainFileName.lastIndexOf(".")-1)
             + "_clean.csv"));
             Scanner sc = new Scanner(mainFile);
             String headerRow = "";
             for (int i=0; i < fileNames.size(); ++i ) {
                 if (i == 0) {
                     headerRow = sc.next();
                     //System.out.println("im here" + headerRow);
                     fw.write(headerRow + "\n");
                 }
                 String dataLine = sc.next();
                 dataLine = dataLine.substring(0, dataLine.length()-1);
                 dataLine += dataContainer.get(fileNames.get(i));
                 fw.write(dataLine + "\n");
             }
             fw.close(); sc.close();
             //System.out.println(sc.next());
             
         }
 
 
 }
 