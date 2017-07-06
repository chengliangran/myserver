package com.myserver.core;

import com.myserver.components.HttpRequest;
import com.myserver.components.HttpResponse;

/**
 * Created by Administrator on 2017-07-06.
 */
public interface Container  {

    void invoke(HttpRequest request, HttpResponse response);
//    添加子类容器或父类容器
    void addChild(Container container);
    void removeChild(Container container);
    void findChild(String name);
    void findChildren();
    void setParent(Container container);
    void getParent();
//    添加组件
    void addLoader();



}
