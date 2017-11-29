package com.yangge.test.utils;

import android.widget.Toast;

import com.yangge.test.App;


/**
 * Created by weifei on 16/8/10.
 */
public class IToast {
    public static Toast toast;

    public static void toast(final String msg){
        if (toast == null) {
            toast = Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    public static void toast(int msg){
        toast(App.getContext().getString(msg));
    }
}
