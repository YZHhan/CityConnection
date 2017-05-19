package com.han.cityconnection.model.Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

public class MessageList {
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"HeadTInfoList":[{"FirstType":1,"SecondType":2,"TheirID":9032583,"Data":[{"Title":"谢谢大家的支持回报大家超级体验:大韩牙膏项目新西兰直发。","Description":"","Image":"","ImageCount":0,"time":"","variable1":78,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"各地代理和销售商","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":13,"SecondType":1,"TheirID":7746934,"Data":[{"Title":"新西兰教育制度概况","Description":"","Image":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/aibsmgdtIduLRbbicGZo9uIYk1huOgibyibiajtibvFyDPrGtX5LS0ryOv2bbYajIZznibUyUgeAuG76oWedRmPqUQ5Kw/300?wx_fmt=jpeg","ImageCount":1,"time":"","variable1":678,"variable2":0,"variable3":"","variable4":"","variable5":"","variable6":0,"variable7":"","variable8":"我爱新西兰我爱哈密尔顿","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9032517,"Data":[{"Title":"爱你，不仅仅局限于生活中的伴侣，还要成为你最重要的政治伙伴","Description":"","Image":"","ImageCount":0,"time":"","variable1":164,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9032522,"Data":[{"Title":"法国总统候选人马克龙:娶同学妈妈有7名继孙(图)","Description":"","Image":"","ImageCount":0,"time":"","variable1":184,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9032520,"Data":[{"Title":"马克龙青涩照片曝光15岁时亲吻未来妻子(图)","Description":"","Image":"","ImageCount":0,"time":"","variable1":217,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030963,"Data":[{"Title":"已经是青年才俊的你，知道女人真正想要的爱情吗？","Description":"","Image":"","ImageCount":0,"time":"","variable1":2153,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030962,"Data":[{"Title":"如果经历了这件事情还相爱，那就结婚吧","Description":"","Image":"","ImageCount":0,"time":"","variable1":2219,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030961,"Data":[{"Title":"跟不漂亮的女孩子谈恋爱是什么感觉？","Description":"","Image":"","ImageCount":0,"time":"","variable1":1992,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030959,"Data":[{"Title":"一位姑娘的婚姻观：有时嫁一个人的损失太大","Description":"","Image":"","ImageCount":0,"time":"","variable1":2078,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030958,"Data":[{"Title":"和不成熟的男人在一起是种怎样的体验？","Description":"","Image":"","ImageCount":0,"time":"","variable1":2109,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]}],"UserCount":6606,"GiftInfoList":[]}
     * Extend : null
     * Count : 166
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0654297
     */

    private MessageListBean MessageList;
    private ServerInfoBean ServerInfo;
    private Object Extend;
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
         * HeadTInfoList : [{"FirstType":1,"SecondType":2,"TheirID":9032583,"Data":[{"Title":"谢谢大家的支持回报大家超级体验:大韩牙膏项目新西兰直发。","Description":"","Image":"","ImageCount":0,"time":"","variable1":78,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"各地代理和销售商","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":13,"SecondType":1,"TheirID":7746934,"Data":[{"Title":"新西兰教育制度概况","Description":"","Image":"http://imgref.ccoo.cn/Ajax/ImgRef.ashx?url=http://mmbiz.qpic.cn/mmbiz_jpg/aibsmgdtIduLRbbicGZo9uIYk1huOgibyibiajtibvFyDPrGtX5LS0ryOv2bbYajIZznibUyUgeAuG76oWedRmPqUQ5Kw/300?wx_fmt=jpeg","ImageCount":1,"time":"","variable1":678,"variable2":0,"variable3":"","variable4":"","variable5":"","variable6":0,"variable7":"","variable8":"我爱新西兰我爱哈密尔顿","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9032517,"Data":[{"Title":"爱你，不仅仅局限于生活中的伴侣，还要成为你最重要的政治伙伴","Description":"","Image":"","ImageCount":0,"time":"","variable1":164,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9032522,"Data":[{"Title":"法国总统候选人马克龙:娶同学妈妈有7名继孙(图)","Description":"","Image":"","ImageCount":0,"time":"","variable1":184,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9032520,"Data":[{"Title":"马克龙青涩照片曝光15岁时亲吻未来妻子(图)","Description":"","Image":"","ImageCount":0,"time":"","variable1":217,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030963,"Data":[{"Title":"已经是青年才俊的你，知道女人真正想要的爱情吗？","Description":"","Image":"","ImageCount":0,"time":"","variable1":2153,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030962,"Data":[{"Title":"如果经历了这件事情还相爱，那就结婚吧","Description":"","Image":"","ImageCount":0,"time":"","variable1":2219,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030961,"Data":[{"Title":"跟不漂亮的女孩子谈恋爱是什么感觉？","Description":"","Image":"","ImageCount":0,"time":"","variable1":1992,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030959,"Data":[{"Title":"一位姑娘的婚姻观：有时嫁一个人的损失太大","Description":"","Image":"","ImageCount":0,"time":"","variable1":2078,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]},{"FirstType":1,"SecondType":2,"TheirID":9030958,"Data":[{"Title":"和不成熟的男人在一起是种怎样的体验？","Description":"","Image":"","ImageCount":0,"time":"","variable1":2109,"variable2":1,"variable3":"1,0,1","variable4":"harry","variable5":"恋爱和婚姻","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]}]
         * UserCount : 6606
         * GiftInfoList : []
         */

        private int UserCount;
        private List<HeadTInfoListBean> HeadTInfoList;
        private List<?> GiftInfoList;

        public int getUserCount() {
            return UserCount;
        }

        public void setUserCount(int UserCount) {
            this.UserCount = UserCount;
        }

        public List<HeadTInfoListBean> getHeadTInfoList() {
            return HeadTInfoList;
        }

        public void setHeadTInfoList(List<HeadTInfoListBean> HeadTInfoList) {
            this.HeadTInfoList = HeadTInfoList;
        }

        public List<?> getGiftInfoList() {
            return GiftInfoList;
        }

        public void setGiftInfoList(List<?> GiftInfoList) {
            this.GiftInfoList = GiftInfoList;
        }

        public static class HeadTInfoListBean {
            /**
             * FirstType : 1
             * SecondType : 2
             * TheirID : 9032583
             * Data : [{"Title":"谢谢大家的支持回报大家超级体验:大韩牙膏项目新西兰直发。","Description":"","Image":"","ImageCount":0,"time":"","variable1":78,"variable2":0,"variable3":"1,0,1","variable4":"harry","variable5":"各地代理和销售商","variable6":0,"variable7":"","variable8":"harry","variable9":"","variable10":0,"variable11":"","variable12":0,"variable13":"","variable14":""}]
             */

            private int FirstType;
            private int SecondType;
            private int TheirID;
            private List<DataBean> Data;

            public int getFirstType() {
                return FirstType;
            }

            public void setFirstType(int FirstType) {
                this.FirstType = FirstType;
            }

            public int getSecondType() {
                return SecondType;
            }

            public void setSecondType(int SecondType) {
                this.SecondType = SecondType;
            }

            public int getTheirID() {
                return TheirID;
            }

            public void setTheirID(int TheirID) {
                this.TheirID = TheirID;
            }

            public List<DataBean> getData() {
                return Data;
            }

            public void setData(List<DataBean> Data) {
                this.Data = Data;
            }

            public static class DataBean {
                /**
                 * Title : 谢谢大家的支持回报大家超级体验:大韩牙膏项目新西兰直发。
                 * Description :
                 * Image :
                 * ImageCount : 0
                 * time :
                 * variable1 : 78
                 * variable2 : 0
                 * variable3 : 1,0,1
                 * variable4 : harry
                 * variable5 : 各地代理和销售商
                 * variable6 : 0
                 * variable7 :
                 * variable8 : harry
                 * variable9 :
                 * variable10 : 0
                 * variable11 :
                 * variable12 : 0
                 * variable13 :
                 * variable14 :
                 */

                private String Title;
                private String Description;
                private String Image;
                private int ImageCount;
                private String time;
                private int variable1;
                private int variable2;
                private String variable3;
                private String variable4;
                private String variable5;
                private int variable6;
                private String variable7;
                private String variable8;
                private String variable9;
                private int variable10;
                private String variable11;
                private int variable12;
                private String variable13;
                private String variable14;

                public String getTitle() {
                    return Title;
                }

                public void setTitle(String Title) {
                    this.Title = Title;
                }

                public String getDescription() {
                    return Description;
                }

                public void setDescription(String Description) {
                    this.Description = Description;
                }

                public String getImage() {
                    return Image;
                }

                public void setImage(String Image) {
                    this.Image = Image;
                }

                public int getImageCount() {
                    return ImageCount;
                }

                public void setImageCount(int ImageCount) {
                    this.ImageCount = ImageCount;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getVariable1() {
                    return variable1;
                }

                public void setVariable1(int variable1) {
                    this.variable1 = variable1;
                }

                public int getVariable2() {
                    return variable2;
                }

                public void setVariable2(int variable2) {
                    this.variable2 = variable2;
                }

                public String getVariable3() {
                    return variable3;
                }

                public void setVariable3(String variable3) {
                    this.variable3 = variable3;
                }

                public String getVariable4() {
                    return variable4;
                }

                public void setVariable4(String variable4) {
                    this.variable4 = variable4;
                }

                public String getVariable5() {
                    return variable5;
                }

                public void setVariable5(String variable5) {
                    this.variable5 = variable5;
                }

                public int getVariable6() {
                    return variable6;
                }

                public void setVariable6(int variable6) {
                    this.variable6 = variable6;
                }

                public String getVariable7() {
                    return variable7;
                }

                public void setVariable7(String variable7) {
                    this.variable7 = variable7;
                }

                public String getVariable8() {
                    return variable8;
                }

                public void setVariable8(String variable8) {
                    this.variable8 = variable8;
                }

                public String getVariable9() {
                    return variable9;
                }

                public void setVariable9(String variable9) {
                    this.variable9 = variable9;
                }

                public int getVariable10() {
                    return variable10;
                }

                public void setVariable10(int variable10) {
                    this.variable10 = variable10;
                }

                public String getVariable11() {
                    return variable11;
                }

                public void setVariable11(String variable11) {
                    this.variable11 = variable11;
                }

                public int getVariable12() {
                    return variable12;
                }

                public void setVariable12(int variable12) {
                    this.variable12 = variable12;
                }

                public String getVariable13() {
                    return variable13;
                }

                public void setVariable13(String variable13) {
                    this.variable13 = variable13;
                }

                public String getVariable14() {
                    return variable14;
                }

                public void setVariable14(String variable14) {
                    this.variable14 = variable14;
                }
            }
        }
    }
}
