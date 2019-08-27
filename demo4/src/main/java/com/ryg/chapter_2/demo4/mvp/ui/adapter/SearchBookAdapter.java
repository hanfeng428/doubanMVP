package com.ryg.chapter_2.demo4.mvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.app.utils.DisplayImgUtis;
import com.ryg.chapter_2.demo4.app.utils.ScreenUtils;
import com.ryg.chapter_2.demo4.app.utils.StringUtils;
import com.ryg.chapter_2.demo4.mvp.model.entity.BookSearchBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private Context context;
    private List<BookSearchBean.BooksBean> list;
    private static final int TYPE_TOP = -1;
    private static final int TYPE_FOOTER = -2;
    private int status = 1;
    public static final int LOAD_MORE = 0;
    public static final int LOAD_PULL_TO = 1;
    public static final int LOAD_NONE = 2;
    public static final int LOAD_END = 3;

    public SearchBookAdapter(Context context, List<BookSearchBean.BooksBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getItemViewType(int position) {
        if (position+1  == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return position;
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i == TYPE_FOOTER){
            View view =LayoutInflater.from(context).inflate( R.layout.activity_view_footer, viewGroup,false);
            return new FooterViewHolder(view);
        }else {
            View view =LayoutInflater.from(context).inflate( R.layout.item_search, viewGroup,false);
            return new FilmUsBoxViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) viewHolder;
            footerViewHolder.bindItem();
        }else if (viewHolder instanceof FilmUsBoxViewHolder) {
            FilmUsBoxViewHolder filmUsBoxViewHolder = (FilmUsBoxViewHolder) viewHolder;
            filmUsBoxViewHolder.bindItem(list,i);
        }

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    /**
     * footer view
     */
    class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_load_prompt)
        TextView tv_load_prompt;
        @BindView(R.id.progress)
        ProgressBar progress;

        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.dipToPx(context, 40));
            itemView.setLayoutParams(params);
        }

        private void bindItem() {
            switch (status) {
                case LOAD_MORE:
                    progress.setVisibility(View.VISIBLE);
                    tv_load_prompt.setText("正在加载...");
                    itemView.setVisibility(View.VISIBLE);
                    break;
                case LOAD_PULL_TO:
                    progress.setVisibility(View.GONE);
                    tv_load_prompt.setText("上拉加载更多");
                    itemView.setVisibility(View.VISIBLE);
                    break;
                case LOAD_NONE:
                    System.out.println("LOAD_NONE----");
                    progress.setVisibility(View.GONE);
                    tv_load_prompt.setText("已无更多加载");
                    break;
                case LOAD_END:
                    itemView.setVisibility(View.GONE);
                default:
                    break;
            }
        }
    }
    class FilmUsBoxViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_search_iv)
        ImageView itemImg;
        @BindView(R.id.item_search_title)
        TextView searchTitle;
        @BindView(R.id.item_search_rating)
        RatingBar searchRating;
        @BindView(R.id.item_search_ratnum)
        TextView searchRatnum;
        @BindView(R.id.item_search_tv1)
        TextView searchAuthor;
        @BindView(R.id.item_search_tv2)
        TextView searchPublish;
        @BindView(R.id.item_search_tv3)
        TextView searchTime;
        @BindView(R.id.item_search_switch)
        ImageView iconImg;

        FilmUsBoxViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
        private void bindItem(List<BookSearchBean.BooksBean> bean,int position) {

            Glide.with(context)
                    .load(bean.get(position).getImages().getLarge())
                    .into(itemImg);
            searchTitle.setText(bean.get(position).getTitle());
            float average = Float.parseFloat(bean.get(position).getRating().getAverage());
            searchRating.setRating(average / 2);
            searchRatnum.setText(average + "");

            searchAuthor.setText("作者：");
            List<String> author = bean.get(position).getAuthor();
            StringUtils.addViewString(author, (searchAuthor));

            searchPublish.setText("出版社：" + bean.get(position).getPublisher());

            searchTime.setText("出版时间：" + bean.get(position).getPubdate());
            iconImg.setVisibility(View.GONE);

        }
    }

    public void updateLoadStatus(int status) {
        this.status = status;
        notifyDataSetChanged();
    }

}
