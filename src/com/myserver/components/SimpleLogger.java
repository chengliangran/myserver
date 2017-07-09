package com.myserver.components;

import com.myserver.core.Container;
import com.myserver.ext.Constants;
import com.sun.jnlp.FileOpenServiceImpl;
import javafx.scene.chart.PieChart;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/7.
 */
public class SimpleLogger implements Logger {
    Container container;
    int verbosity;
    FileOutputStream fos=null;
    String currentDate=null;
    public int getVerbosity() {
        return verbosity;
    }

    public void setVerbosity(int verbosity) {
        this.verbosity = verbosity;
    }

    public static final int DEBUG=4;
    public static final int INFORMATION=3;
    public static final int WARNING=2;
    public static final int ERROR=1;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
    public void log(String msg){
        test();
        try {
            fos.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void log(String msg,int verbosity){

    }
    private void test(){
        if (fos==null){
            File logDoc=new File(Constants.WEB_ROOT+"/log",new SimpleDateFormat("yyyy MM dd").format(new Date()));
            try {
                logDoc.createNewFile();
                fos=new FileOutputStream(logDoc);
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentDate=new SimpleDateFormat("yyyy MM dd").format(new Date());
        }else {
            String newCurrentDate=new SimpleDateFormat("yyyy MM dd").format(new Date());
            if (!currentDate.equals(newCurrentDate)){
                try {
                    fos= new FileOutputStream(new File(Constants.WEB_ROOT+"/log",new SimpleDateFormat("yyyy MM dd").format(new Date())));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
