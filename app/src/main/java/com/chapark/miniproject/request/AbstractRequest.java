package com.chapark.miniproject.request;

import com.chapark.miniproject.manager.NetworkRequest;

import okhttp3.HttpUrl;

/**
 * Created by Tacademy on 2016-08-09.
 */
public abstract class AbstractRequest<T> extends NetworkRequest<T> {

    protected HttpUrl.Builder getBaseUrlBuilder(){
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme("https");
        builder.host("orum-1470719845577.appspot.com");
        return  builder;
    }
}
