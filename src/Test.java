
import com.myserver.ext.Constants;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017-07-06.
 */
public class Test {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        Date date=new Date();
        System.out.println(date);
        System.out.println(new SimpleDateFormat("yyyy MM dd").format(date));

     }
}