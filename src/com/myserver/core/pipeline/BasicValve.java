package com.myserver.core.pipeline;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;
import com.myserver.core.Container;
import com.myserver.core.Context;
import com.myserver.components.Mapper;

/**
 * Created by Administrator on 2017-07-07.
 */
public class BasicValve implements Valve,Contained{
    @Override
    public void setContainer(Container container) {
    }

    @Override
    public void getContainer() {

    }

    @Override
    public void invoke(HttpRequest request, HttpResponse response, SimplePipeline.ValveContext valveContext) {
        System.out.println("这是基本阀门,将唤醒mapper");
        Context context= (Context) request.getContainer();
        Mapper mapper=context.getMapper();

    }
}
