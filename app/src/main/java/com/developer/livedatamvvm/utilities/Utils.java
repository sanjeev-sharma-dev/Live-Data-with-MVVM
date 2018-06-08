package com.developer.livedatamvvm.utilities;

import android.app.ProgressDialog;
import android.content.Context;

public class Utils {
    public static Utils instance=new Utils();
    static ProgressDialog dialog;

    public static Utils getInstance() {
        return instance;
    }

    public void showDialog(Context context){
        dialog=new ProgressDialog(context);
        dialog.setMessage("Loading...");
        dialog.show();
    }

    public void  hideProgress(){
        dialog.dismiss();
    }
}
