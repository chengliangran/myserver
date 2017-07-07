
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017-07-06.
 */
public class Test {
    public static void main(String[] args) {
         InputStream in=System.in;
        byte[] buf=new byte[3048];
        try {
            in.read(buf);
        String sql=new String(buf,0,buf.length);
        String[] cities=sql.split("\n");
             String newCity=null;
            System.out.println(cities.length);
        for (String city : cities) {
            int index1=city.indexOf("://");
            int index2=city.indexOf("/",index1+5);
            int index3=city.indexOf("/",index2+2);
            int index4=city.indexOf("/",index3+2);
             newCity=city.substring(0,index4);
            System.out.println(newCity);
        }
        } catch (IOException e) {
        e.printStackTrace();
        }
        }

        }
