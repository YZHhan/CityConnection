package com.han.cityconnection.CityPart.HeardNews.SheQuPart.bean;

import java.util.List;

/**
 * Created by think on 2017/5/12.
 */

public class TabBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Id":1,"Class":0,"Name":"捧场王","Buju":1,"LocationId":0},{"Id":2,"Class":0,"Name":"名人堂","Buju":2,"LocationId":0},{"Id":3,"Class":0,"Name":"版区","Buju":3,"LocationId":0},{"Id":2,"Class":1,"Name":"最新","Buju":1,"LocationId":1},{"Id":1,"Class":1,"Name":"热帖","Buju":1,"LocationId":0},{"Id":7,"Class":1,"Name":"图说","Buju":1,"LocationId":0},{"Id":9,"Class":1,"Name":"专题活动","Buju":1,"LocationId":0},{"Id":10,"Class":1,"Name":"值得一看","Buju":1,"LocationId":0}]
     * Extend : null
     * Count : 8
     * GxNum : 0
     * PageNum : 0
     * retime : 0.5097657
     */

    private MessageListBean MessageList;
    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;
    private List<ServerInfoBean> ServerInfo;

    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
    }

    public Object getExtend() {
        return Extend;
    }

    public void setExtend(Object Extend) {
        this.Extend = Extend;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getGxNum() {
        return GxNum;
    }

    public void setGxNum(int GxNum) {
        this.GxNum = GxNum;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int PageNum) {
        this.PageNum = PageNum;
    }

    public double getRetime() {
        return retime;
    }

    public void setRetime(double retime) {
        this.retime = retime;
    }

    public List<ServerInfoBean> getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(List<ServerInfoBean> ServerInfo) {
        this.ServerInfo = ServerInfo;
    }

    public static class MessageListBean {
        /**
         * code : 1000
         * message : Success
         */

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ServerInfoBean {
        /**
         * Id : 1
         * Class : 0
         * Name : 捧场王
         * Buju : 1
         * LocationId : 0
         */

        private int Id;
        private String Name;
        private int Buju;
        private int LocationId;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getBuju() {
            return Buju;
        }

        public void setBuju(int Buju) {
            this.Buju = Buju;
        }

        public int getLocationId() {
            return LocationId;
        }

        public void setLocationId(int LocationId) {
            this.LocationId = LocationId;
        }
    }
}
