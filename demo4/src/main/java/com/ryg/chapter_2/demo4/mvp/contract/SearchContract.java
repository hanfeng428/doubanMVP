package com.ryg.chapter_2.demo4.mvp.contract;

import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;
import com.ryg.chapter_2.demo4.mvp.model.entity.BookSearchBean;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/22/2019 17:41
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public interface SearchContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setBookDataList(BookSearchBean dataList, boolean ismore);

    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<BookSearchBean> getBook(int lastIdQueried, boolean update, String start,String q);
    }
}
