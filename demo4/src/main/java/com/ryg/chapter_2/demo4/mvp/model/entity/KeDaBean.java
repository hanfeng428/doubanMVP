package com.ryg.chapter_2.demo4.mvp.model.entity;

import java.util.List;

public class KeDaBean {
    /**
     * sn : 1
     * ls : false
     * bg : 0
     * ed : 0
     * ws : [{"bg":0,"cw":[{"sc":0,"w":"谷歌"}]},{"bg":0,"cw":[{"sc":0,"w":"语音"}]},{"bg":0,"cw":[{"sc":0,"w":"助手"}]}]
     */

    private int sn;
    private boolean ls;
    private int bg;
    private int ed;
    private List<WsBean> ws;

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public boolean isLs() {
        return ls;
    }

    public void setLs(boolean ls) {
        this.ls = ls;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public int getEd() {
        return ed;
    }

    public void setEd(int ed) {
        this.ed = ed;
    }

    public List<WsBean> getWs() {
        return ws;
    }

    public void setWs(List<WsBean> ws) {
        this.ws = ws;
    }

    public static class WsBean {
        /**
         * bg : 0
         * cw : [{"sc":0,"w":"谷歌"}]
         */

        private int bg;
        private List<CwBean> cw;

        public int getBg() {
            return bg;
        }

        public void setBg(int bg) {
            this.bg = bg;
        }

        public List<CwBean> getCw() {
            return cw;
        }

        public void setCw(List<CwBean> cw) {
            this.cw = cw;
        }

        public static class CwBean {
            /**
             * sc : 0.0
             * w : 谷歌
             */

            private double sc;
            private String w;

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getW() {
                return w;
            }

            public void setW(String w) {
                this.w = w;
            }
        }
    }
}
