package com.example.jdong.net;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 刘雅文 on 2017/12/15.
 */

public class ImageLoaderHelper extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
       Glide.with(context).load(path).into(imageView);
    }
}
