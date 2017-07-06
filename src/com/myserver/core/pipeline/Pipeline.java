package com.myserver.core.pipeline;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

/**
 * Created by Administrator on 2017-07-06.
 */
public interface Pipeline {

    void invoke(HttpRequest request, HttpResponse response);

    void addValve(Valve valve);
    void removeValve();
    void findValve(String name);
    void findValves();

    void setBasicValve(Valve valve);
    void getBasicValve();

}
