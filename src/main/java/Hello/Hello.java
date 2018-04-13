package Hello;

import java.util.*;
import java.util.logging.Level;

import static Hello.Main.logger;


public class Hello {

    private String nameCity;
    private String nameTimeZone;

    public String getNameCity() {
        return nameCity;
    }

    public String getNameTimeZone() {
        return nameTimeZone;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setNameTimeZone(String nameTimeZone) {
        this.nameTimeZone = nameTimeZone;
    }

    public Hello(String nameCity, String nameTimeZone)
    {
        this.nameCity=nameCity;
        this.nameTimeZone=nameTimeZone;
    }
    public Hello()
    {
        this.nameCity="";
        this.nameTimeZone="";
    }

    public String getWelcome()
    {
        logger.logp(Level.INFO,"Hello","getWelcome","getWelcome started working");

        int count=0;
        int result=0;
        Calendar calendar=Calendar.getInstance();
        for(String s: TimeZone.getAvailableIDs())
        {
            if (s.indexOf(nameCity, 0) > 0)
            {
                calendar.setTimeZone(TimeZone.getTimeZone(s));
                result=calendar.get(Calendar.HOUR_OF_DAY);
                count++;
                break;
            }
        }
        if(count==0)
        {
            calendar.setTimeZone(TimeZone.getTimeZone(nameTimeZone));
            result=calendar.get(Calendar.HOUR_OF_DAY);
        }

        if(result>=6&&result<9)
            return "strGM";
        else
        if(result>=9&&result<19)
            return "strGA";
        else
        if(result>=19&&result<23)
            return "strGE";
        else
            return "strGN";

    }

}
