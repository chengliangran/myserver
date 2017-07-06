package com.myserver.core;

import com.myserver.components.HttpRequest;

/**
 * Created by Administrator on 2017-07-06.
 */
public interface Mapper {
    Container map(HttpRequest request,boolean update);
}
