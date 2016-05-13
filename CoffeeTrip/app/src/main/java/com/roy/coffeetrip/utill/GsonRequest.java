package com.roy.coffeetrip.utill;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by ${Roy} on 16/5/12.
 */
public class GsonRequest<T> extends Request<T> {
    private Gson gson;
    private Class<T> tClass;
    private Response.Listener<T> mlistener;

    public GsonRequest(int method, String url, Response.ErrorListener listener, Class<T> tClass, Response.Listener<T> mlistener) {
        super(method, url, listener);
        this.tClass = tClass;
        this.mlistener = mlistener;
        this.gson = new Gson();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String data = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(data,tClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mlistener.onResponse(response);
    }
}
