package com.myserver.core;

import com.chengliangran.components.HttpRequest;
import com.chengliangran.components.HttpResponse;
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
    BootStrap bootstrap=null;

    Socket socket=null;

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
                String[] reqFields= lines[0].split(" ");
                HttpRequest request=new HttpRequest(socket.getInputStream());
                HttpResponse response=new HttpResponse(request,socket.getOutputStream());
                if (reqFields.length==3){
                    request.setMethod(reqFields[0]);
                    request.setUrl(reqFields[1]);
                    request.setProtocal(reqFields[2]);
                }else {
                    throw new Exception("请求行不符合http标准");
                }
                for (String line : lines) {
                    String[] headValue=line.split("=");
                    if (headValue.length>1){
                        headValues.put(headValue[0],headValue[1]);
                    }
                }
                request.setParameters(headValues);
             }else {
                throw new Exception("没有解析到任何内容");
            }
            for (String s : headValues.keySet()) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bootstrap.recycle(this);

    }
}
