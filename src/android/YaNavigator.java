package com.guardia.yanavigator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Toast;
import android.content.Context;
import android.util.Log;

public class YaNavigator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();

        Log.i("DEV", "yanavi - execute: " + action);

        if (action.equals("launch")) {

            String message = args.getString(0);


            Log.i("DEV", "yanavi - launch ok + " + message);

            Toast.makeText(context, "Проверка: " + message, Toast.LENGTH_SHORT).show();

            Log.i("DEV", "yanavi - after toast");

            callbackContext.success("All Ok :)");

            return true;
        }
        return false;
    }

}
