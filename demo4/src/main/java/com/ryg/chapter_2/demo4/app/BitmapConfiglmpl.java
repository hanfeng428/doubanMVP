package com.ryg.chapter_2.demo4.app;

import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;

import com.jess.arms.http.imageloader.ImageConfig;

public class BitmapConfiglmpl extends ImageConfig {

    private CollapsingToolbarLayout layout;

    public BitmapConfiglmpl(Buidler buidler) {
        this.imageView = buidler.imageView;
        this.url = buidler.url;
        this.errorPic = buidler.errorPic;
        this.placeholder = buidler.placeholder;
        this.layout = buidler.layout;
    }

    public CollapsingToolbarLayout getLayout() {
        return layout;
    }
    public static Buidler builder() {
        return new Buidler();
    }

    public static final class Buidler {
        private String url;
        private ImageView imageView;
        private int placeholder;
        protected int errorPic;
        private CollapsingToolbarLayout layout;

        private Buidler() {
        }

        public Buidler layout(CollapsingToolbarLayout layout) {
            this.layout = layout;
            return this;
        }

        public Buidler url(String url) {
            this.url = url;
            return this;
        }

        public Buidler placeholder(int placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Buidler errorPic(int errorPic) {
            this.errorPic = errorPic;
            return this;
        }

        public Buidler imagerView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public BitmapConfiglmpl build() {
            if (url == null) throw new IllegalStateException("url is required");
            if (imageView == null) throw new IllegalStateException("imageview is required");
            return new BitmapConfiglmpl(this);
        }
    }
}
