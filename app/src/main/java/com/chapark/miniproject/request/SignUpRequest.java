package com.chapark.miniproject.request;


import android.content.Context;

import com.chapark.miniproject.data.NetworkResult;
import com.chapark.miniproject.data.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Tacademy on 2016-08-09.
 */
public class SignUpRequest extends AbstractRequest<NetworkResult<User>>  {
    Request request;
    public SignUpRequest(Context context, String username, String password,
                         String email, String regId){
        HttpUrl.Builder builder = getBaseUrlBuilder();
        builder.addPathSegment("signup");

        RequestBody body = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .add("email", email)
                .add("registrationId", regId)
                .build();

        request = new Request.Builder()
                .url(builder.build())
                .post(body)
                .tag(context)
                .build();
    }


    @Override
    public Request getRequest() {
        return request;
    }

    @Override
    protected Type getType() {
        return new TypeToken<NetworkResult<List<User>>>(){}.getType();
    }
}

