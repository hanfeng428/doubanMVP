package com.ryg.chapter_2.demo4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jess.arms.http.imageloader.BaseImageLoaderStrategy;
import com.jess.arms.http.imageloader.glide.GlideArms;
import com.jess.arms.http.imageloader.glide.GlideRequest;
import com.jess.arms.http.imageloader.glide.GlideRequests;
import com.jess.arms.utils.Preconditions;
import com.ryg.chapter_2.demo4.app.utils.UIUtils;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class BitmapImageLoaderStrategy implements BaseImageLoaderStrategy<BitmapConfiglmpl> {
    @Override
    public void loadImage(Context ctx, BitmapConfiglmpl config) {
        Preconditions.checkNotNull(ctx, "Context is required");
        Preconditions.checkNotNull(config, "ImageConfigImpl is required");
        Preconditions.checkNotNull(config.getImageView(), "ImageView is required");

        GlideRequests requests;

        requests = GlideArms.with(ctx);//如果context是activity则自动使用Activity的生命周期
        GlideRequest<Bitmap> glideRequest = requests.asBitmap();

        if (config.getLayout() != null) {
            glideRequest
                    .load(config.getUrl())
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            int color = UIUtils.getColorBackground(resource, ctx);
                            config.getLayout().setContentScrimColor(color);
                            config.getLayout().setBackgroundColor(color);
                            config.getImageView().setImageBitmap(resource);
                        }
                    });
        } else {
            glideRequest.load(config.getUrl())
                    .into(config.getImageView());
        }
    }

    @Override
    public void clear(Context ctx, BitmapConfiglmpl config) {
        Preconditions.checkNotNull(ctx, "Context is required");
        Preconditions.checkNotNull(config, "ImageConfigImpl is required");

        if (config.getImageView() != null) {
            GlideArms.get(ctx).getRequestManagerRetriever().get(ctx).clear(config.getImageView());
        }
    }
}
