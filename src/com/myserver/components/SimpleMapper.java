package com.myserver.components;

import com.myserver.core.Container;
import com.myserver.core.Context;

/**
 * Created by Administrator on 2017-07-07.
 */
public class SimpleMapper implements Mapper{

    @Override
    public Container map(HttpRequest request, boolean update) {
        String name=request.getUrl();
        Context context=(Context) request.getContainer();
        return  context.findChild(name);
    }
}
