package com.myserver.core;

import com.myserver.components.SimpleLoader;
import com.myserver.components.SimpleLogger;
import com.myserver.components.SimpleManager;
import com.myserver.components.SimpleMapper;
import com.myserver.core.pipeline.Pipeline;
import com.myserver.core.pipeline.SimpleValve;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-07-04.
 */
public class Connector {
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

    public Connector(){
        while (processors.size()<min){
            addProcessor();
          }
        container=assemble();
        //组装context`
        Context context=(Context)container;
        if (context==null){
            System.out.println("为空");
        }
        context.addLoader(new SimpleLoader());
        context.addLogger(new SimpleLogger());
         context.addManager(new SimpleManager());
         Wrapper wrapper=new SimpleWrapper();
         wrapper.setServletClass("TestServlet");
         wrapper.setName("wrapper");

         context.addChild(wrapper);
        ((Pipeline)context).addValve(new SimpleValve());

        context.setMapper(new SimpleMapper());

    }

    public static void main(String[] args) {
        new Connector().handle();
    }

    public void handle(){
        try {
            int i=0;
            server=new ServerSocket(8080);
            while (true){
                socket= server.accept();
                System.out.println("接受到一个socket"+i++);
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
            System.out.println("处理类的数量是"+(processors.size()));
            return processors.remove(processors.size()-1);
        }else if (current<30){
            addProcessor();
            System.out.println("处理类的数量是"+(processors.size()));
             return processors.remove(processors.size()-1);
         }else {
            System.out.println("处理类的数量是"+processors.size());
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
        return new Context();
     }


}
