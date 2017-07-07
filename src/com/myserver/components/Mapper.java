package com.myserver.components;

import com.myserver.components.HttpRequest;
import com.myserver.core.Container;

/**
 * Created by Administrator on 2017-07-06.
 */
public interface Mapper {
    Container map(HttpRequest request, boolean update);
}
