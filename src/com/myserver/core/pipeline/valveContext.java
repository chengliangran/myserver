package com.myserver.core.pipeline;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

/**
 * Created by Administrator on 2017-07-06.
 */
public interface valveContext {
    void invokeNext(HttpRequest request, HttpResponse response);
}
