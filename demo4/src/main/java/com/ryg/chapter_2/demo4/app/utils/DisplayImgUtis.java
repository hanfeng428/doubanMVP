package com.ryg.chapter_2.demo4.app.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jess.arms.utils.ArmsUtils;
import com.ryg.chapter_2.demo4.app.BitmapConfiglmpl;

/**
 *   
 * Created hefeng on 19/8/10.
 */
public class DisplayImgUtis {
    private static DisplayImgUtis instance;
    private DisplayImgUtis(){}
    public static DisplayImgUtis getInstance(){
        if(instance==null){
            instance =new DisplayImgUtis();
        }
        return  instance;
    }


    public void display(Context context, String url, ImageView imageView){
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context, BitmapConfiglmpl
                        .builder()
                        .url(url)
                        .imagerView(imageView)
                        .build());
    }

}
