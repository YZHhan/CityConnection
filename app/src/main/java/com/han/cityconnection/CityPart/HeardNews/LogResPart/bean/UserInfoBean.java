package com.han.cityconnection.CityPart.HeardNews.LogResPart.bean;

/**
 * Created by think on 2017/5/16.
 */

public class UserInfoBean {

    /**
     * customerID : 8001
     * requestTime : 2017-05-11 11:25:53
     * Method : PHSocket_SetRegUserInfo
     * customerKey : 9774FC5723FB3312E8132490D7D58980
     * appName : CcooCity
     * version : 1.0
     * Param : {"InUser":{"RoleIMG":"yzhdezh.jpg","SiteID":2482,"RoleName":"zydDan","lifeaddr":"北京清河","sex":"男","birthday":"1991-06-07","OType":5,"Tel":"13721685693","UserPWD":"plmoknij"}}
     * Statis : {"SiteId":2482,"UserId":0,"PhoneNo":"android.os.Build.MODEL;","SystemNo":2,"System_VersionNo":"Android 6.0","PhoneId":"862380037036772","PhoneNum":"0"}
     */

    private int customerID;
    private String requestTime;
    private String Method;
    private String customerKey;
    private String appName;
    private String version;
    private ParamBean Param;
    private StatisBean Statis;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ParamBean getParam() {
        return Param;
    }

    public void setParam(ParamBean Param) {
        this.Param = Param;
    }

    public StatisBean getStatis() {
        return Statis;
    }

    public void setStatis(StatisBean Statis) {
        this.Statis = Statis;
    }

    public static class ParamBean {
        /**
         * InUser : {"RoleIMG":"yzhdezh.jpg","SiteID":2482,"RoleName":"zydDan","lifeaddr":"北京清河","sex":"男","birthday":"1991-06-07","OType":5,"Tel":"13721685693","UserPWD":"plmoknij"}
         */

        private InUserBean InUser;

        public InUserBean getInUser() {
            return InUser;
        }

        public void setInUser(InUserBean InUser) {
            this.InUser = InUser;
        }

        public static class InUserBean {
            /**
             * RoleIMG : yzhdezh.jpg
             * SiteID : 2482
             * RoleName : zydDan
             * lifeaddr : 北京清河
             * sex : 男
             * birthday : 1991-06-07
             * OType : 5
             * Tel : 13721685693
             * UserPWD : plmoknij
             */

            private String RoleIMG;
            private int SiteID;
            private String RoleName;
            private String lifeaddr;
            private String sex;
            private String birthday;
            private int OType;
            private String Tel;
            private String UserPWD;

            public String getRoleIMG() {
                return RoleIMG;
            }

            public void setRoleIMG(String RoleIMG) {
                this.RoleIMG = RoleIMG;
            }

            public int getSiteID() {
                return SiteID;
            }

            public void setSiteID(int SiteID) {
                this.SiteID = SiteID;
            }

            public String getRoleName() {
                return RoleName;
            }

            public void setRoleName(String RoleName) {
                this.RoleName = RoleName;
            }

            public String getLifeaddr() {
                return lifeaddr;
            }

            public void setLifeaddr(String lifeaddr) {
                this.lifeaddr = lifeaddr;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public int getOType() {
                return OType;
            }

            public void setOType(int OType) {
                this.OType = OType;
            }

            public String getTel() {
                return Tel;
            }

            public void setTel(String Tel) {
                this.Tel = Tel;
            }

            public String getUserPWD() {
                return UserPWD;
            }

            public void setUserPWD(String UserPWD) {
                this.UserPWD = UserPWD;
            }
        }
    }

    public static class StatisBean {
        /**
         * SiteId : 2482
         * UserId : 0
         * PhoneNo : android.os.Build.MODEL;
         * SystemNo : 2
         * System_VersionNo : Android 6.0
         * PhoneId : 862380037036772
         * PhoneNum : 0
         */

        private int SiteId;
        private int UserId;
        private String PhoneNo;
        private int SystemNo;
        private String System_VersionNo;
        private String PhoneId;
        private String PhoneNum;

        public int getSiteId() {
            return SiteId;
        }

        public void setSiteId(int SiteId) {
            this.SiteId = SiteId;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public void setPhoneNo(String PhoneNo) {
            this.PhoneNo = PhoneNo;
        }

        public int getSystemNo() {
            return SystemNo;
        }

        public void setSystemNo(int SystemNo) {
            this.SystemNo = SystemNo;
        }

        public String getSystem_VersionNo() {
            return System_VersionNo;
        }

        public void setSystem_VersionNo(String System_VersionNo) {
            this.System_VersionNo = System_VersionNo;
        }

        public String getPhoneId() {
            return PhoneId;
        }

        public void setPhoneId(String PhoneId) {
            this.PhoneId = PhoneId;
        }

        public String getPhoneNum() {
            return PhoneNum;
        }

        public void setPhoneNum(String PhoneNum) {
            this.PhoneNum = PhoneNum;
        }
    }
}
