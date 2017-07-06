package com.myserver.core.pipeline;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

/**
 * Created by Administrator on 2017-07-06.
 */
public class SimplePipeline implements Pipeline {
    //测试
    Valve[] valves;


    @Override
    public void invoke(HttpRequest request, HttpResponse response) {

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
}
