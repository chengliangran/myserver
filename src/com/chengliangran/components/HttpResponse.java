package com.chengliangran.components;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017-07-05.
 */
public class HttpResponse {
    HttpRequest request;

    OutputStream outputStream;

    public HttpResponse(HttpRequest request, OutputStream outputStream){
        this.request=request;
        this.outputStream=outputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

}
