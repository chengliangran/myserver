package com.myserver.core;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-07-05.
 */
public class HttpProcessor implements Runnable {
    Connector bootstrap=null;

    Socket socket=null;

    HttpProcessor(Connector bootStrap){
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
            System.out.println("打印socket内容"+message);
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
                    System.out.println(reqFields[0]+"---");
                    throw new Exception("请求行不符合http标准");
                }
                for (String line : lines) {
                    String[] headValue=line.split("=");
                    if (headValue.length>1){
                        headValues.put(headValue[0],headValue[1]);
                    }
                }
                request.setParameters(headValues);
                if ((Context)(bootstrap.getContainer())!=null){
                    bootstrap.getContainer().invoke(request,response);
                 }
                System.out.println("开始发送返回结果");
                 String resp="HTTP/1.1 2OO OK\n" +
                         "Server: Microsoft-IIS/4.0\n" +
                         "Date: Mon,  5 Jan 2004 13:13:33 GHT\n" +
                         "Content -Type:  text/html\n" +
                         "Last-Modified:Mon,  5 Jan 2004 13:13:12 GMT\n" +
                         "Content-Length: 112";
                 socket.getOutputStream().write(resp.getBytes());

                 socket.close();
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
