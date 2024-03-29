package com.ryg.chapter_2.demo4.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.app.utils.DisplayImgUtis;
import com.ryg.chapter_2.demo4.app.utils.ScreenUtils;
import com.ryg.chapter_2.demo4.mvp.model.entity.FilmLiveBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by forezp on 16/9/23.
 */
public class FilmLiveAdapter extends EasyRecyclerViewAdapter<FilmLiveBean.SubjectsBean> {
    Context context;
    public FilmLiveAdapter(Context context){
        this.context=context;
    }
    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film_live, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, FilmLiveBean.SubjectsBean data) {
        ViewHolder holder= (ViewHolder) viewHolder;

        holder.tvFilmName.setText(data.getTitle());
        ViewGroup.LayoutParams params=holder.iVFilm.getLayoutParams();
        int width= ScreenUtils.getScreenWidthDp(context);
        int ivWidth=(width-ScreenUtils.dipToPx(context,80))/3;
        params.width=ivWidth;
        double height=(420.0/300.0)*ivWidth;
        params.height=(int)height;
        holder.iVFilm.setLayoutParams(params);
        if(data.getImages()!=null&&!TextUtils.isEmpty(data.getImages().getLarge())) {
            DisplayImgUtis.getInstance().display(context, data.getImages().getLarge(), holder.iVFilm);
        }
        if(!TextUtils.isEmpty(""+data.getRating().getAverage())) {
            holder.tvFilmGrade.setText("评分:"+ String.valueOf(data.getRating().getAverage()));
        }else{
            holder.tvFilmGrade.setText("暂无评分");
        }
    }

    class ViewHolder extends EasyViewHolder{
        @BindView(R.id.iV_film)
        ImageView iVFilm;
        @BindView(R.id.tv_film_name)
        TextView tvFilmName;
        @BindView(R.id.tv_film_grade)
        TextView tvFilmGrade;

        public   ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
