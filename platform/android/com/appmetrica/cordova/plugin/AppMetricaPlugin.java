package com.appmetrica.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

import com.yandex.metrica.YandexMetrica;

import android.content.Context;
import android.util.Log;

public class AppMetricaPlugin extends CordovaPlugin { 
    @Override
    public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if("activate".equals(action))
        {
            activate(args, callbackContext);
            return true;
        }
        return false;
    }

    private void activate(JSONArray parameters, final CallbackContext callbackContext) {
        String devKey = null;
        try
        {
            devKey = parameters.getString(0);
            if(devKey != null){
                YandexMetrica.activate(cordova.getActivity().getApplicationContext(), devKey);				
				YandexMetrica.reportEvent("activated");
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return;
        }
    }
}