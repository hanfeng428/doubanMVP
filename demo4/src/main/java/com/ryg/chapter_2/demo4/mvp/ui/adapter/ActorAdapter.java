package com.ryg.chapter_2.demo4.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jess.arms.utils.ArmsUtils;
import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.app.BitmapConfiglmpl;
import com.ryg.chapter_2.demo4.mvp.model.entity.MovieDetailsBean;

/**
 * Created by ChinaLHR on 2016/12/20.
 * Email:13435500980@163.com
 */

public class ActorAdapter extends BaseRecyclerAdapter<ActorAdapter.MyHolder> {
    private Context mContext;
    private MovieDetailsBean mdate;
    private LayoutInflater mInflater;

    public ActorAdapter(Context context, MovieDetailsBean bean) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mdate = bean;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(mInflater.inflate(R.layout.item_actor, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < mdate.getDirectors().size()) {
            if (mdate.getDirectors().get(position).getAvatars() != null) {
                final MovieDetailsBean.DirectorsBean directorsBean = mdate.getDirectors().get(position);
                ArmsUtils.obtainAppComponentFromContext(mContext)
                        .imageLoader()
                        .loadImage(mContext, BitmapConfiglmpl
                                .builder()
                                .url(directorsBean.getAvatars().getLarge())
                                .imagerView(((MyHolder) holder).item_actor_iv)
                                .build());
                ((MyHolder) holder).item_actor_actortv.setText(directorsBean.getName());
                ((MyHolder) holder).item_actor_directtv.setText("导演");

                if (mListener != null) {
                    ((MyHolder) holder).item_actor_iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mListener.onItemClick(directorsBean.getId(), directorsBean.getAvatars().getLarge());
                        }
                    });
                }
            }
        } else {
            position -= mdate.getDirectors().size();
            if (mdate.getCasts().get(position).getAvatars()  != null) {
                final MovieDetailsBean.CastsBean castsBean = mdate.getCasts().get(position);
                ((MyHolder) holder).item_actor_directtv.setText("");
                ArmsUtils.obtainAppComponentFromContext(mContext)
                        .imageLoader()
                        .loadImage(mContext, BitmapConfiglmpl
                                .builder()
                                .url(castsBean.getAvatars().getLarge())
                                .imagerView(((MyHolder) holder).item_actor_iv)
                                .build());
                ((MyHolder) holder).item_actor_actortv.setText(castsBean.getName());
                if (mListener != null) {
                    ((MyHolder) holder).item_actor_iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mListener.onItemClick(castsBean.getId(), castsBean.getAvatars().getLarge());
                        }
                    });
                }

            }
        }
    }


    @Override
    public int getItemCount() {
        int i = 0;
        if (mdate.getCasts() != null) {
            i += mdate.getCasts().size();
        }
        if (mdate.getDirectors() != null) {
            i += mdate.getDirectors().size();
        }
        return i;
    }

    class MyHolder extends BaseRecyclerAdapter.Holder {
        ImageView item_actor_iv;
        TextView item_actor_actortv;
        TextView item_actor_directtv;

        public MyHolder(View itemView) {
            super(itemView);

            item_actor_iv = (ImageView) itemView.findViewById(R.id.item_actor_iv);
            item_actor_actortv = (TextView) itemView.findViewById(R.id.item_actor_actortv);
            item_actor_directtv = (TextView) itemView.findViewById(R.id.item_actor_directtv);

        }
    }


}
