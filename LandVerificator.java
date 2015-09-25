
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.Scanner;

    public class LandVerificator{
        public static Scanner in = new Scanner(System.in);
public static String queryMenu(){
  int resa;
      String inp = in.nextLine();
            System.out.print("Enter land code to search:");
             inp = in.nextLine();
            
            String csvFile = "database";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
       int hit = 0;
    try {

        Map<String, String> maps = new HashMap<String, String>();

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

            String[] record = line.split(cvsSplitBy);

            maps.put(record[1], "Name: "+record[2]+"\n Date: "+record[3]+"\n Contact number: "+record[4]+"\n Land size: "+record[5]+"\n Land Location: "+record[0]);

        }

        for (Map.Entry<String, String> entry : maps.entrySet()) {
                        if(inp.equals( entry.getKey())){
            System.out.println("Land code: " + entry.getKey() + "\nLand owner "
                + entry.getValue());

                 hit=1;}}

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    if(hit !=1){
        
        System.out.println("Sorry record could not be found");
        }
            
           
     String  check="";String error="Enter ";
            System.out.println("'1': Search again) \n'2': Quit to main menu");
            resa = in.nextInt();
            if (resa==1) { 
                queryMenu();
            }
            if(resa==2){
            
            mainMenu();
            }
return "";
}
public static String logger(){

return "log taken /n";
}        

public static String delete(){
    return "delete method called";
} 
public static String regfile(){
String[] register ;  register= new String[10];String fileName="database";
String timeStamp = new SimpleDateFormat("mmss").format(new Date());    
try
    {
                   
           String reg;
            
            reg = in.nextLine();
             System.out.print("Please enter the location of the land: ");
            reg = in.nextLine();
             register[0] = reg;
            
             System.out.print("Who owns the land: ");
            reg = in.nextLine();
             register[1] = reg;
             
             System.out.print("What is the owners Id: ");
            reg = in.nextLine();
             register[2] = reg;
             
             System.out.print("When was the land registered(dd-mm-yyy): ");
            reg = in.nextLine();
             register[3] = reg;
             
              System.out.print("contact number of owner: ");
            reg = in.nextLine();
             register[4] = reg;
             System.out.print("how big is the land: ");
            reg = in.nextLine();
             register[5] = reg;
             
             
             
        FileWriter writer = new FileWriter(fileName,true);
          java.util.Date date= new java.util.Date();
        writer.append(register[0]);
        writer.append(',');
        String code ="lld"+timeStamp;
        writer.append(code);
            writer.append(",");
            writer.append(register[1]);
            writer.append(",");
            writer.append(register[3]);
            writer.append(",");
            writer.append(register[4]);
            writer.append(",");
            writer.append(register[5]);
        writer.append('\n');

            
            
        writer.flush();
        writer.close();
            System.out.println("Record was just created for land at "+register[0]+" of size "+register[5]+
                    " \n owned by "+register[1]+"\n land code: "+code
                    +" \n registered on the "+ register[3]);
            System.out.println(" Other Details include \n owners contact "+register[4]+" \n Land owners id "+register[2]+"\n");
    }
    catch(IOException e)
    {
         e.printStackTrace();
    } 
    
    return "";

}
public static String secondRegisterMenu(){
   //  System.out.println(storefiles());
                 
                System.out.println("'1': Main Menu \n'2': Delete\n'3': Register Another Land\n'4': Exit");
                  int resp = in.nextInt();
                  switch (resp) {
            case 1: mainMenu();secondRegisterMenu();
                     break;
            case 2:  System.out.println(delete())  ;
                     break;
             case 3: 
                regfile();
                     break;  
             case 4:  System.exit(0);
                     break;
                default: System.exit(0);
                     break;
        }
return "";
}
public static int mainMenu(){
   
     String  check="";String error="Enter ";
            System.out.println("'1': Register(official use only) \n'2': Query Land(Input land code)");
            int resp = in.nextInt();
            if (resp==1) {
                              
            while(check !="yes"){
                System.out.println (error+" pin:");
                 resp = in.nextInt();
                if (resp ==12345) {
                    regfile();
                    
                   
                   secondRegisterMenu();
                    check="yes";
                    
                } error="Re-enter";}
           
    
    
} if(resp==2){
      queryMenu();
            }           return 0;
           
}



        public static void main(String [] args){
            
             mainMenu();
            
        
        }}



 


            
