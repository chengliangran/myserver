package com.myserver.core;

import jdk.nashorn.internal.runtime.linker.Bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-07-05.
 */
public class HttpProcessor implements Runnable {
    Socket socket=null;

    BootStrap bootstrap=null;

    HttpProcessor(BootStrap bootStrap){
        this.bootstrap=bootStrap;
    }

    public Socket getSocket() {
        return socket;
    }

    public void asign(Socket socket){
        this.socket=socket;
     }
    public void process(){
        Thread t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        socket=getSocket();
        try {
            InputStream is=socket.getInputStream();
            byte[] buf=new byte[2048];
            is.read(buf);
            String message=new String(buf,0,buf.length);
            Map<String,String> headValues=new HashMap<>();
            String[] lines=message.split("\r\n");
            if (lines.length>0){
//                解析里面的内容
                String reqFields[]= lines[0].split(" ");
                for (String line : lines) {
                    String[] headValue=line.split("=");
                    if (headValue.length>1){
                        headValues.put(headValue[0],headValue[1]);
                    }
                }
            }
            for (String s : headValues.keySet()) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bootstrap.recycle(this);

    }
}
