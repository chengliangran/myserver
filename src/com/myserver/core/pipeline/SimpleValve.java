package com.myserver.core.pipeline;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

/**
 * Created by Administrator on 2017-07-07.
 */
public class SimpleValve implements Valve {
    @Override
    public void invoke(HttpRequest request, HttpResponse response, SimplePipeline.ValveContext valveContext) {
        System.out.println("这是普通阀门，打印个url"+request.getUrl());
        valveContext.invovleNext(request,response);

    }
}
