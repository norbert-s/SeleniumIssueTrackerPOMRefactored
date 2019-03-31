package testdatamanipulation;

import utility.Prop;

import java.io.*;
import java.util.*;

public class Data {
    public  Map<String,String> map = new HashMap<>();
    public Data() throws IOException {
        getDataFromExcel();
    }

    public void getDataFromExcel() throws FileNotFoundException {
        File f = new File(Prop.prop.getProperty("excel"));
        Scanner scanner = new Scanner (f,"ISO-8859-2");
        String[] stringArray ;
        while (scanner.hasNextLine()) {
            String check = scanner.nextLine();
            stringArray = check.split(";");
            map.put(stringArray[0],stringArray[1]);
        }
        scanner.close();

    }

    public String createData(int num) throws IOException {

        String library = Prop.prop.getProperty("sourcefiles");
        FileReader file = new FileReader(library+num+".txt");
        try(BufferedReader reader = new BufferedReader(file)){
            String line = "";
            String lineConcat="";
            while((line = reader.readLine())!=null){
                lineConcat += line;
            }

            return lineConcat;
        }
    }

    //this will return the string of the looked for string
    public  String it(String v){
        return  map.get(v);
    }

    public  String getValidTitle() {
        return it("validTitle");
    }
    public String getValidText()  {
        return it("validText");
    }

    public String getValidCreatedBy()  {
        return it("validCreatedBy");
    }

    public String getAssignedTo(){
        return it("assignedTo");
    }

    public String getStatusText(){
        return it("statusText");
    }

    public String getInvalidTitle() {
        return it("invalidTitle");
    }

    public String getInvalidText() {
        return it("invalidText");
    }

    public String getInvalidCreatedBy() {
        return it("invalidCreatedBy");
    }

    public String getUpdateErrId(){
        return it("errId");
    }

    public String getErrTitle(){
        return it("errTitle");
    }

    public String getErrText(){
        return it("errText");
    }

    public String getErrCreatedBy(){
        return it("errCreatedBy");
    }

    public String getErrDeleteId(){
        return it("errDeleteId");
    }

    public String getSuccess(){
        return it("success");
    }

    public String getSuccessUpdate(){
        return it("successUpdate");
    }

    public String getTxtLocation(){
        return it("txtLocation");
    }

    public String getErrWhenDbEmptyAndStatusActive(){
        return it("QueryStatusActiveWhenDbIsEmpty");
    }
    public String getAssignedTo2(){
        return it("assignedTo2");
    }
    public String getInvalidAssignedTo(){
        return it("invalidAssignedTo");
    }

    public String getInvalidStatusText(){
        return it("invalidStatus");
    }
}
