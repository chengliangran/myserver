package com.myserver.components;

import com.myserver.core.Container;import com.myserver.core.Context;

/**
 * Created by Administrator on 2017-07-07.
 */
public class SimpleMapper implements Mapper{

    @Override
    public Container map(HttpRequest request, boolean update) {
        String name=request.getUrl();
        Context context=(Context) request.getContainer();
        Logger logger= context.getLogger();
        if (logger!=null){
            System.out.println("测试logger");
            ((SimpleLogger)logger).log("今天是个好日子");
        }
        return  context.findChild(name);
    }
}
