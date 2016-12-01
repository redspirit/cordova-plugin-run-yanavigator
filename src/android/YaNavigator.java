package com.guardia.yanavigator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

public class YaNavigator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();
        if (action.equals("launch")) {

            double lat_from = args.getDouble(0);
            double lon_from = args.getDouble(1);
            double lat_to = args.getDouble(2);
            double lon_to = args.getDouble(3);

            Intent intent = new Intent("ru.yandex.yandexnavi.action.BUILD_ROUTE_ON_MAP");
            intent.setPackage("ru.yandex.yandexnavi");

            PackageManager pm = context.getPackageManager();
            List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);

            // Проверяем, установлен ли Яндекс.Навигатор
            if (infos == null || infos.size() == 0) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=ru.yandex.yandexnavi"));
            } else {
                intent.putExtra("lat_from", lat_from);
                intent.putExtra("lon_from", lon_from);
                intent.putExtra("lat_to", lat_to);
                intent.putExtra("lon_to", lon_to);
            }

            cordova.getActivity().startActivity(intent);

            return true;
        }
        return false;
    }

}
