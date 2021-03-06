package com.smhrd.team.yh;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PreferenceManager {
    private static final String PREFERENCE_NAME = "my_app";
    private static final String DEFAULT_VALUE_STRING = "";
    private static final boolean DEFAULT_VALUE_BOOLEAN = false;
    private static final int DEFAULT_VALUE_INT = -1;
    private static final long DEFAULT_VALUE_LONG = -1L;
    private static final float DEFAULT_VALUE_FLOAT = -1F;
    private static final String SETTINGS_PLAYER_JSON = "settings_item_json";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

    }

    // String 값 저장
    public static void setString(Context context, String key, String value) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    // boolean 값 저장
    public static void setBoolean(Context context, String key, Boolean value) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    // int 값 저장
    public static void setInt(Context context, String key, int value) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    // long 값 저장
    public static void setLong(Context context, String key, long value) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    //float 값 저장
    public static void setFloat(Context context, String key, float value) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    // string 값 꺼내기
    public static String getString(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        String value = prefs.getString(key, DEFAULT_VALUE_STRING);
        return value;
    }
    public static Boolean getBoolean(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        Boolean value = prefs.getBoolean(key, DEFAULT_VALUE_BOOLEAN);
        return value;
    }
    public static int getInt(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        int value = prefs.getInt(key,DEFAULT_VALUE_INT);
        return value;
    }
    public static long getLong(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        long value = prefs.getLong(key,DEFAULT_VALUE_LONG);
        return value;
    }
    public static float getFloat(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        float value = prefs.getFloat(key,DEFAULT_VALUE_FLOAT);
        return value;
    }
    // key 값과 일치하는 것 삭제
    public static void removeKey(Context context, String key){
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }
    // 모든 저장 데이터 삭제
    public static void clear(Context context){
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }
   public static void setStringArrayPref(Context context, String key, ArrayList<HomePolisyDTO> values) {

        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();

        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }

        if (!values.isEmpty()) {

            editor.putString(key, a.toString());
            Log.v("test2",a.toString());
        } else {
            editor.putString(key, null);
        }

        editor.apply();
    }



   public static ArrayList<JSONObject> getStringArrayPref(Context context, String key) {

        SharedPreferences prefs = getPreferences(context);
        String json = prefs.getString(key, null);
//       Log.v("test", json);
        ArrayList<JSONObject> urls = new ArrayList<JSONObject> ();

        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
//                    HomePolisyDTO homePolisyDTO;
                    JSONObject jo = new JSONObject((String)a.get(i));


//                    homePolisyDTO= (HomePolisyDTO) a.get(i);
//
                            urls.add(jo);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }
}