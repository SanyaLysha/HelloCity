package Hello;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static final String lang="en";
    static final String country="US";
    static final Locale locale =new Locale(lang,country);
    static final ResourceBundle resourceBundle=ResourceBundle.getBundle("Bundle",locale);
    static final Logger logger=Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws UnsupportedEncodingException, ParseException {

        Hello h=new Hello();

        logger.logp(Level.INFO,"Main","main","starting working");
        try {
            FileHandler fh = new FileHandler("LogApp");
            logger.addHandler(fh);
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "Не удалось создать файл лога.", e);
        }
        logger.log(Level.INFO, "INFO - информационный уровень");
        logger.log(Level.WARNING,"WARNING - предупреждение");
        logger.log(Level.SEVERE, "SEVERE - серъёзная ошибка");

        goResult(input(h));
    }
    public static Hello input( Hello h) throws ParseException, UnsupportedEncodingException {


        Scanner scan=new Scanner(System.in);
        System.out.println("Input a city: ");
        h.setNameCity(scan.nextLine());
        System.out.println("Input TimeZone: ");
        h.setNameTimeZone(scan.nextLine());
        h.setNameCity(h.getNameCity().replace(" ","_"));
        logger.log(Level.INFO,"read data");
        return h;
    }
    public static void goResult(Hello h) throws UnsupportedEncodingException {
        System.out.println(new String(resourceBundle.getString(h.getWelcome()).getBytes("ISO-8859-5"),"UTF-8")+h.getNameCity()+"!");
        logger.getLevel();
        logger.log(Level.INFO,"The end of the program");
    }
}
