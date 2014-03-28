package com.hill30.android.angular;

import android.webkit.JavascriptInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MVCControllers {

    static List<JSONObject> todos = new LinkedList<JSONObject>();

    // todo: check how it is going to work on API prior to 17
    @JavascriptInterface
    public String get(String url) throws Exception {
        String[] tokens = url.split("/");
        if (tokens[0].equals("todos")) {
            JSONArray result = new JSONArray();
            result.put(new JSONObject("{description:'The first one'}"));
            for (JSONObject record : todos) {
                result.put(record.toString());
            }
            return result.toString();
        }
//        if (tokens[0].equals("activity")) {
//            if (tokens.length < 2)
//                throw new Exception("Invalid REST request: activityRecord id missing");
//            return storageConnection.get(Integer.parseInt(tokens[1])).getPayload().toString();
//        }
        throw new Exception("Invalid REST request: unknown controller '" + tokens[0] + "'");
    }

    @JavascriptInterface
    public String post(String url, String post) throws Exception {
        String[] tokens = url.split("/");
//        if (tokens[0].equals("activity")) {
//            if (tokens.length < 2)
//                throw new Exception("Invalid REST request: activityRecord id missing");
//            storageConnection.save(Integer.parseInt(tokens[1]), post);
//            return post;
//        }
        throw new Exception("Invalid REST request: unknown controller '" + tokens[0] + "'");
    }
}