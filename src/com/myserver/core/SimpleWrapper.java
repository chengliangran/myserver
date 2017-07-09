package com.myserver.core;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

/**
 * Created by Administrator on 2017-07-07.
 */
public class SimpleWrapper extends Wrapper{
    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void invoke(HttpRequest request, HttpResponse response) {
        System.out.println("抵达wrapper");
        super.invoke(request, response);

    }
}
