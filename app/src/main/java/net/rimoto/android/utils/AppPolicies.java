package net.rimoto.android.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import net.rimoto.core.API;
import net.rimoto.core.RimotoException;
import net.rimoto.core.models.Policy;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by almog on 04/08/15.
 */
public class AppPolicies {
    public interface SimpleCallback {
        void done(Policy policy, RimotoException error);
    }
    public static void addAppPolicy(Context context, SimpleCallback cb) {
        TelephonyManager tel = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String home_operator = API.rimotoOperatorFormat(tel.getSimOperator());
        String visited_operator = API.rimotoOperatorFormat(tel.getNetworkOperator());

        if(home_operator.equals("N/A") || visited_operator.equals("N/A")) {
            cb.done(null, new RimotoException("NO_SIM"));
        }

        API.getInstance().addAppPolicy(home_operator, visited_operator, new Callback<Policy>() {
            @Override
            public void success(Policy policy, Response response) {
                cb.done(policy, null);
            }

            @Override
            public void failure(RetrofitError error) {
                RimotoException exeption = new RimotoException(error.getResponse().getStatus(), error.getMessage(), error.getUrl());
                exeption.setStackTrace(error.getStackTrace());
                cb.done(null, exeption);
            }
        });
    }
}
