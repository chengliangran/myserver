package com.myserver.core.pipeline;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;
import com.myserver.core.Container;

/**
 * Created by Administrator on 2017-07-06.
 */
public class Context implements Container,Pipeline {
    Pipeline pipeline=new SimplePipeline();




    @Override
    public void invoke(HttpRequest request, HttpResponse response) {
        System.out.println("context开始启动，将唤醒其中的pipeline");
    }

    @Override
    public void addChild(Container container) {

    }

    @Override
    public void removeChild(Container container) {

    }

    @Override
    public void findChild(String name) {

    }

    @Override
    public void findChildren() {

    }

    @Override
    public void setParent(Container container) {

    }

    @Override
    public void getParent() {

    }

    @Override
    public void addLoader() {

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
