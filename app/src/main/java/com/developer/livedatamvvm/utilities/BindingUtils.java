package com.developer.livedatamvvm.utilities;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BindingUtils {

    public static void loadImage(ImageView view, String flag) {

        Glide.with(view.getContext())
                .load(flag)
                .apply(RequestOptions.circleCropTransform())
                .into(view);


    }

}
