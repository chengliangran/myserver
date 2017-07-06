package com.myserver.core.pipeline;

import com.myserver.core.Container;

/**
 * Created by Administrator on 2017-07-06.
 */
public interface Contained {
    void setContainer(Container container);
    void getContainer();
}
