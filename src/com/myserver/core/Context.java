package com.myserver.core;

import com.myserver.components.*;
import com.myserver.core.pipeline.Pipeline;
import com.myserver.core.pipeline.SimplePipeline;
import com.myserver.core.pipeline.Valve;

/**
 * Created by Administrator on 2017-07-06.
 */
public class Context implements Container,Pipeline {
    Pipeline pipeline=new SimplePipeline();
    Loader loader;
    Logger logger;
    Manager manager;
    Realm realm;
    Mapper mapper;
    Container[] wrappers;

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void invoke(HttpRequest request, HttpResponse response) {
        System.out.println("context开始启动，将唤醒其中的pipeline");
        request.setContainer(this);
        pipeline.invoke(request,response );
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
        Wrapper[] wrapper= (Wrapper[]) findChildren();
        return null;

    }

    @Override
    public Container[] findChildren() {

        return wrappers;
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


    @Override
    public void addValve(Valve valve) {

    }

    @Override
    public void removeValve() {

    }

    @Override
    public void findValve(String name) {

    }

    @Override
    public void findValves() {

    }

    @Override
    public void setBasicValve(Valve valve) {

    }

    @Override
    public void getBasicValve() {

    }
}
