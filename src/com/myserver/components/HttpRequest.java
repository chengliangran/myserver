package com.myserver.components;

import com.myserver.core.Container;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-07-05.
 */
public class HttpRequest {
    InputStream inputStream;
    String url;
    String method;
    String protocal;
    String queryString;
    String jsessionid;
    Container container;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    Map<String,String> parameters=new HashMap<>();
    String attribute;

    public String getAttribute(String key) {
        return parameters.get(key);
    }


    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public HttpRequest(InputStream inputStream){
        this.inputStream=inputStream;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocal() {
        return protocal;
    }

    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }
}
