package com.han.cityconnection.CityPart.HeardNews.Entity;

import java.util.List;

/**
 * Created by think on 2017/5/22.
 */

public class Photobean {

    /**
     * MessageList : {"code":1000,"message":"发布成功~"}
     * ServerInfo : {"ID":8770652}
     * Extend : {"reTask":[{"id":75470,"title":"发帖","property":0,"integral":50,"coin":0,"code":1000}],"reMsg":""}
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.2558594
     */

    private MessageListBean MessageList;
    private ServerInfoBean ServerInfo;
    private ExtendBean Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;

    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
    }

    public ServerInfoBean getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(ServerInfoBean ServerInfo) {
        this.ServerInfo = ServerInfo;
    }

    public ExtendBean getExtend() {
        return Extend;
    }

    public void setExtend(ExtendBean Extend) {
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

    public static class MessageListBean {
        /**
         * code : 1000
         * message : 发布成功~
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
         * ID : 8770652
         */

        private int ID;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    }

    public static class ExtendBean {
        /**
         * reTask : [{"id":75470,"title":"发帖","property":0,"integral":50,"coin":0,"code":1000}]
         * reMsg :
         */

        private String reMsg;
        private List<ReTaskBean> reTask;

        public String getReMsg() {
            return reMsg;
        }

        public void setReMsg(String reMsg) {
            this.reMsg = reMsg;
        }

        public List<ReTaskBean> getReTask() {
            return reTask;
        }

        public void setReTask(List<ReTaskBean> reTask) {
            this.reTask = reTask;
        }

        public static class ReTaskBean {
            /**
             * id : 75470
             * title : 发帖
             * property : 0
             * integral : 50
             * coin : 0
             * code : 1000
             */

            private int id;
            private String title;
            private int property;
            private int integral;
            private int coin;
            private int code;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getProperty() {
                return property;
            }

            public void setProperty(int property) {
                this.property = property;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getCoin() {
                return coin;
            }

            public void setCoin(int coin) {
                this.coin = coin;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }
        }
    }
}
