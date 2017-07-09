package com.myserver.core.pipeline;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017-07-06.
 */
public class SimplePipeline implements Pipeline {
    //测试
    List<Valve> valves=new ArrayList<>();
    Valve basic=new BasicValve();
    ValveContext valveContext=new ValveContext();


    @Override
    public void invoke(HttpRequest request, HttpResponse response) {
        System.out.println("pipeline开始启动唤醒valvecontext");
        valveContext.invovleNext(request,response);

    }

    @Override
    public void addValve(Valve valve) {

    }

    @Override
    public void removeValve() {

    }

    @Override
    public void findValve(String name) {

    }

    @Override
    public void findValves() {

    }

    @Override
    public void setBasicValve(Valve valve) {

    }

    @Override
    public void getBasicValve() {

    }
    class ValveContext{
        int index=0;
        public void invovleNext(HttpRequest request,HttpResponse response){
             if (index<valves.size()){
                 valves.get(index).invoke(request,response,this);
            }else {
                 basic.invoke(request,response,this);
            }
        }
    }
}
