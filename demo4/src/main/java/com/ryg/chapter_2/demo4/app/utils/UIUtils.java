package com.ryg.chapter_2.demo4.app.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;

import com.ryg.chapter_2.demo4.R;

/**
 * Created by ChinaLHR on 2016/12/13.
 * Email:13435500980@163.com
 */

public class UIUtils {


    /**
     * 加载资源文件===================
     */
    // 获取字符串
    public static String getString(Context context, int id) {
        return context.getResources().getString(id);
    }

    // 获取字符串数组
    public static String[] getStringArray(Context context, int id) {
        return context.getResources().getStringArray(id);
    }

    // 获取图片
    public static Drawable getDrawable(Context context, int id) {
        return context.getResources().getDrawable(id);
    }

    // 获取颜色
    public static int getColor(Context context, int id) {
        return context.getResources().getColor(id);
    }

    // 根据id获取颜色的状态选择器
    public static ColorStateList getColorStateList(Context context, int id) {
        return context.getResources().getColorStateList(id);
    }

    public static int getColorBackground(Bitmap bitmap,Context context) {
        if (bitmap != null) {
            Palette p = Palette.from(bitmap).generate();
            Palette.Swatch s_dm = p.getDarkMutedSwatch();
            Palette.Swatch s_dv = p.getDarkVibrantSwatch();
            if (s_dm != null) {
                return s_dm.getRgb();
            } else {
                if (s_dv != null) {
                    return s_dv.getRgb();
                } else {
                    return UIUtils.getColor(context, R.color.colorPrimary);
                }
            }
        } else {
            return UIUtils.getColor(context, R.color.colorPrimary);
        }
    }

}
