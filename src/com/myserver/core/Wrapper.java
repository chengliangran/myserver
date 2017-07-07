package com.myserver.core;

import com.myserver.components.*;
import com.myserver.core.Container;

/**
 * Created by Administrator on 2017-07-07.
 */
public class Wrapper implements Container{

    @Override
    public void invoke(HttpRequest request, HttpResponse response) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addChild(Container container) {

    }

    @Override
    public void removeChild(Container container) {

    }

    @Override
    public Container findChild(String name) {
        return null;
    }

    @Override
    public Container[] findChildren() {
        return new Container[0];
    }

    @Override
    public void setParent(Container container) {

    }

    @Override
    public Container getParent() {
        return null;
    }

    @Override
    public void addLoader(Loader loader) {

    }

    @Override
    public Loader getLoader() {
        return null;
    }

    @Override
    public void addLogger(Logger logger) {

    }

    @Override
    public Logger getLogger() {
        return null;
    }

    @Override
    public void addManager(Manager manager) {

    }

    @Override
    public Manager getmanager(Manager manager) {
        return null;
    }

    @Override
    public void addRealm(Realm realm) {

    }

    @Override
    public Realm getRealm() {
        return null;
    }


}
