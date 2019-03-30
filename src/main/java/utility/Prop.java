package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    public static Properties prop;
    public String txtLocation = "";

    public Prop()  {

    }

    public static void properties()  {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\Idea_Selenium\\Selenium_now\\SeleniumIssueTrackerPageObjectRefactored\\src\\main\\java\\sourcefiles\\data.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
