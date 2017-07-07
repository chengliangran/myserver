package com.myserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-07-04.
 */
public class BootStrap {
//    套接字工厂
    ServerSocket server=null;
    Socket socket=null;
//    处理者
    List<HttpProcessor> processors=new ArrayList();
    int min=10;
    int max=30;
    int current=0;
//容器
    Container container;

    public Container getContainer() {
        return container;
    }

    public BootStrap(){
        while (processors.size()<min){
            addProcessor();
          }
        container=assemble();
    }

    public static void main(String[] args) {
        new BootStrap().handle();
    }

    public void handle(){
        try {
            server=new ServerSocket(8080);
            while (true){
                socket= server.accept();
                HttpProcessor processor=getPocessor();
                if (processor!=null){
                    processor.asign(socket);
                    processor.process();
                }else {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HttpProcessor getPocessor(){
        if (processors.size()>0){
            System.out.println("处理类的数量时"+(processors.size()-1));
            return processors.remove(processors.size()-1);
        }else if (current<30){
            addProcessor();
            System.out.println("处理类的数量时"+(processors.size()-1));
             return processors.remove(processors.size()-1);
         }else {
            System.out.println("处理类的数量时"+processors.size());
            return null;
        }
    }

    public void addProcessor(){
        processors.add(new HttpProcessor(this));
        current++;
        System.out.println("处理器的总数为"+current);
    }

    public void recycle(HttpProcessor processor){
        processors.add(processor);
    }

    public Container assemble(){
        container=new Context();
        return null;
    }


}
