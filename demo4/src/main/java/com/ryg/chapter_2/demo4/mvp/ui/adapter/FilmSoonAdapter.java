package com.ryg.chapter_2.demo4.mvp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.app.utils.DisplayImgUtis;
import com.ryg.chapter_2.demo4.app.utils.ScreenUtils;
import com.ryg.chapter_2.demo4.mvp.model.entity.ComingBean;
import com.ryg.chapter_2.demo4.mvp.ui.activity.MovieSubjectActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmSoonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private static final String TAG = "FilmSoonAdapter";
    private Context context;
    private ComingBean root;
    private int status = 1;
    public static final int LOAD_MORE = 0;
    public static final int LOAD_PULL_TO = 1;
    public static final int LOAD_NONE = 2;
    public static final int LOAD_END = 3;
    private static final int TYPE_TOP = -1;
    private static final int TYPE_FOOTER = -2;

    public FilmSoonAdapter(Context context, ComingBean root) {
        this.context = context;
        this.root = root;
    }


    @Override
    public int getItemViewType(int position) {

        if (position+1  == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return position;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = View.inflate(parent.getContext(), R.layout.activity_view_footer, null);
            return new FooterViewHolder(view);
        } else {
            View rootView = View.inflate(parent.getContext(), R.layout.item_film_coming, null);
            return new FilmUsBoxViewHolder(rootView);
        }
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            footerViewHolder.bindItem();
        }else if (holder instanceof FilmUsBoxViewHolder) {
            FilmUsBoxViewHolder filmUsBoxViewHolder = (FilmUsBoxViewHolder) holder;
            filmUsBoxViewHolder.bindItem(root.getSubjects().get(position),position,filmUsBoxViewHolder);
        }
    }

    @Override
    public int getItemCount() {
        return root.getSubjects().size()+1;
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
        @BindView(R.id.iV_film)
        ImageView iVFilm;
        @BindView(R.id.tv_film_name)
        TextView tvFilmName;
        @BindView(R.id.tv_film_grade)
        TextView tvFilmGrade;
        @BindView(R.id.ll_item_view)
        LinearLayout llItemView;
        public   FilmUsBoxViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
        private void bindItem(ComingBean.SubjectsBean subjects,int positon,FilmUsBoxViewHolder holder) {

            ViewGroup.LayoutParams params=holder.iVFilm.getLayoutParams();
            int width= ScreenUtils.getScreenWidthDp(context);
            int ivWidth=(width-ScreenUtils.dipToPx(context,80))/3;
            params.width=ivWidth;
            double height=(420.0/300.0)*ivWidth;
            params.height=(int)height;
            holder.iVFilm.setLayoutParams(params);
            if(subjects.getImages()!=null&&!TextUtils.isEmpty(subjects.getImages().getLarge())) {
                DisplayImgUtis.getInstance().display(context, subjects.getImages().getLarge(), holder.iVFilm);
            }

            tvFilmName.setText(subjects.getTitle());
            tvFilmGrade.setText("上映日期:"+subjects.getMainland_pubdate());

            llItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG,"hf_FilmSoonAdapter_bindItem ");
                    MovieSubjectActivity.toActivity((Activity) context,subjects.getId(),subjects.getImages().getLarge());

                }
            });
        }
    }

    public void updateLoadStatus(int status) {
        this.status = status;
        notifyDataSetChanged();
    }
}
