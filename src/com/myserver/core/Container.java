package com.myserver.core;

import com.myserver.components.*;

/**
 * Created by Administrator on 2017-07-06.
 */
public interface Container  {

    void invoke(HttpRequest request, HttpResponse response);

    void setName(String name);
    String getName();

//    添加子类容器或父类容器
    void addChild(Container container);
    void removeChild(Container container);
    Container findChild(String name);
    Container[] findChildren();
    void setParent(Container container);
    Container getParent();
//    添加组件
    void addLoader(Loader loader);
    Loader getLoader();
    void addLogger(Logger logger);
    Logger getLogger();
    void  addManager(Manager manager);
    Manager getmanager(Manager manager);
    void addRealm(Realm realm);
    Realm getRealm();



}
