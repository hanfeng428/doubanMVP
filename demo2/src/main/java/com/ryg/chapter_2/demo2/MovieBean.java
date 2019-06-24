package com.ryg.chapter_2.demo2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieBean {

    /**
     * mdown : 0
     * wmarkPos : 0
     * publishTime : 1439567432000
     * vpic : http://pic9.iqiyipic.com/image/20150803/96/f9/v_109343020_m_601.jpg
     * tvQipuId : 385274600
     * payMarkUrl :
     * purType : 0
     * shortTitle : 航海王 第1集
     * type : 1
     * lgh : []
     * isProduced : 0
     * vurl : http://www.iqiyi.com/v_19rrok4nt0.html
     * plcdown : {"17":0,"15":0}
     * vid : e59fa071d268247291f7737c72ea37f8
     * timeLength : 1500
     * pd : 1
     * vn : 航海王 第1集
     * payMark : 0
     * exclusive : 1
     * id : 385274600
     * vt : 我是路飞！ 将要成为海贼王的男人
     * pds : 1
     */

    private int mdown;
    private int wmarkPos;
    private long publishTime;
    private String vpic;
    private int tvQipuId;
    private String payMarkUrl;
    private int purType;
    private String shortTitle;
    private String type;
    private int isProduced;
    private String vurl;
    private PlcdownBean plcdown;
    private String vid;
    private int timeLength;
    private int pd;
    private String vn;
    private int payMark;
    private int exclusive;
    private int id;
    private String vt;
    private String pds;
    private List<?> lgh;

    public int getMdown() {
        return mdown;
    }

    public void setMdown(int mdown) {
        this.mdown = mdown;
    }

    public int getWmarkPos() {
        return wmarkPos;
    }

    public void setWmarkPos(int wmarkPos) {
        this.wmarkPos = wmarkPos;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getVpic() {
        return vpic;
    }

    public void setVpic(String vpic) {
        this.vpic = vpic;
    }

    public int getTvQipuId() {
        return tvQipuId;
    }

    public void setTvQipuId(int tvQipuId) {
        this.tvQipuId = tvQipuId;
    }

    public String getPayMarkUrl() {
        return payMarkUrl;
    }

    public void setPayMarkUrl(String payMarkUrl) {
        this.payMarkUrl = payMarkUrl;
    }

    public int getPurType() {
        return purType;
    }

    public void setPurType(int purType) {
        this.purType = purType;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsProduced() {
        return isProduced;
    }

    public void setIsProduced(int isProduced) {
        this.isProduced = isProduced;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public PlcdownBean getPlcdown() {
        return plcdown;
    }

    public void setPlcdown(PlcdownBean plcdown) {
        this.plcdown = plcdown;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public int getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(int timeLength) {
        this.timeLength = timeLength;
    }

    public int getPd() {
        return pd;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public int getPayMark() {
        return payMark;
    }

    public void setPayMark(int payMark) {
        this.payMark = payMark;
    }

    public int getExclusive() {
        return exclusive;
    }

    public void setExclusive(int exclusive) {
        this.exclusive = exclusive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVt() {
        return vt;
    }

    public void setVt(String vt) {
        this.vt = vt;
    }

    public String getPds() {
        return pds;
    }

    public void setPds(String pds) {
        this.pds = pds;
    }

    public List<?> getLgh() {
        return lgh;
    }

    public void setLgh(List<?> lgh) {
        this.lgh = lgh;
    }

    public static class PlcdownBean {
        /**
         * 17 : 0
         * 15 : 0
         */

        @SerializedName("17")
        private int _$17;
        @SerializedName("15")
        private int _$15;

        public int get_$17() {
            return _$17;
        }

        public void set_$17(int _$17) {
            this._$17 = _$17;
        }

        public int get_$15() {
            return _$15;
        }

        public void set_$15(int _$15) {
            this._$15 = _$15;
        }
    }
}
