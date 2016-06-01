package com.roy.coffeetrip.bean.customize;

import java.util.List;

/**
 * Created by ${Roy} on 16/5/26.
 */
public class CustomizeBean {


    private int Err;
    private Object Msg;
    private String ServerTime;
    private int Time;


    private List<ItemsEntity> Items;
    /**
     * Bid : 22
     * Title : 新的故事，新的旅行
     * PicUrl : http://img2.miaotu.net/2016-01-06/6ff2f438f656a20ec2a22787120bce55.jpg
     * Mark :
     * Extend : http://m.miaotu.net/Activity/banner?pid=03
     * Sort : 0
     * Type : 3
     * Area : 101
     */

    private List<BannerEntity> Banner;
    /**
     * Tid : 1
     * Title : 东北
     * PicUrl : http://img2.miaotu.net/2015-11-25/59c03a00be0992f7a80ad312d15491d5.jpg
     * ReasonUrl : http://img2.miaotu.net/2015-11-12/8d665ccf8685490e124ac722de101f26.jpg
     * Reason : 如果你喜欢冰雪的话，东北的冬天是最好的季节了。晶莹的冰，洁白的雪，更有绽放在冬季的雾淞。温度越低，这北方的魅力就愈发浓郁。
     * Status : -1
     * Created : 2016-04-20T14:19:54+08:00
     * ReplyCount : 109
     * List : null
     */

    private List<TopicEntity> Topic;
    private List<String> CityList;

    public int getErr() {
        return Err;
    }

    public void setErr(int Err) {
        this.Err = Err;
    }

    public Object getMsg() {
        return Msg;
    }

    public void setMsg(Object Msg) {
        this.Msg = Msg;
    }

    public String getServerTime() {
        return ServerTime;
    }

    public void setServerTime(String ServerTime) {
        this.ServerTime = ServerTime;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public List<ItemsEntity> getItems() {
        return Items;
    }

    public void setItems(List<ItemsEntity> Items) {
        this.Items = Items;
    }

    public List<BannerEntity> getBanner() {
        return Banner;
    }

    public void setBanner(List<BannerEntity> Banner) {
        this.Banner = Banner;
    }

    public List<TopicEntity> getTopic() {
        return Topic;
    }

    public void setTopic(List<TopicEntity> Topic) {
        this.Topic = Topic;
    }

    public List<String> getCityList() {
        return CityList;
    }

    public void setCityList(List<String> CityList) {
        this.CityList = CityList;
    }

    public static class ItemsEntity {
        private int Yid;
        private String Uid;
        private String Destination;
        private String From;
        private String FromMark;
        private String StartDate;
        private String EndDate;
        private String EndTime;
        private String Require;
        private int Number;
        private String MoneyType;
        private double Latitude;
        private double Longitude;
        private String Remark;
        private String Tags;
        private int YueyouJoinCount;
        private int YueyouLikeCount;
        private int YueyouReplyCount;
        private String Created;
        private String Updated;
        private int Status;
        private boolean IsTop;
        private String Position;
        private boolean IsCohabit;
        private int ComId;
        /**
         * ComId : 0
         * Address :
         * Locate :
         * Country :
         * Province :
         * City :
         * Section :
         * YueyouCount : 0
         * PicUrl :
         */

        private AssemblingPlaceEntity AssemblingPlace;
        private String Platform;
        private String Nickname;
        private String HeadUrl;
        private Object LikeList;
        private Object JoinList;
        private Object ReplyList;
        private int Age;
        private String Gender;
        private String UserTags;
        private String Work;
        private boolean IsLike;
        private double Distance;
        private String Gid;
        private String GroupName;
        private String MaritalStatus;
        private String WantGo;
        private boolean IsGroup;
        private boolean IsJoin;
        private Object RecommendRes;
        private int RecommendResCount;
        private String RecommendCity;
        private boolean Recommend;
        /**
         * Ypid : 150643
         * Yid : 44481
         * Url : http://img2.miaotu.net/2016-04-26/cc3f68f45f2b001c41b47dfccd1419b5.jpg
         * Created : 2016-04-26 16:49:38
         * Uid : 98fb4c9f-2126-11e5-a75b-00163e002e59
         * Status : 0
         */

        private List<PicListEntity> PicList;

        public int getYid() {
            return Yid;
        }

        public void setYid(int Yid) {
            this.Yid = Yid;
        }

        public String getUid() {
            return Uid;
        }

        public void setUid(String Uid) {
            this.Uid = Uid;
        }

        public String getDestination() {
            return Destination;
        }

        public void setDestination(String Destination) {
            this.Destination = Destination;
        }

        public String getFrom() {
            return From;
        }

        public void setFrom(String From) {
            this.From = From;
        }

        public String getFromMark() {
            return FromMark;
        }

        public void setFromMark(String FromMark) {
            this.FromMark = FromMark;
        }

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String StartDate) {
            this.StartDate = StartDate;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public String getRequire() {
            return Require;
        }

        public void setRequire(String Require) {
            this.Require = Require;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public String getMoneyType() {
            return MoneyType;
        }

        public void setMoneyType(String MoneyType) {
            this.MoneyType = MoneyType;
        }

        public double getLatitude() {
            return Latitude;
        }

        public void setLatitude(double Latitude) {
            this.Latitude = Latitude;
        }

        public double getLongitude() {
            return Longitude;
        }

        public void setLongitude(double Longitude) {
            this.Longitude = Longitude;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getTags() {
            return Tags;
        }

        public void setTags(String Tags) {
            this.Tags = Tags;
        }

        public int getYueyouJoinCount() {
            return YueyouJoinCount;
        }

        public void setYueyouJoinCount(int YueyouJoinCount) {
            this.YueyouJoinCount = YueyouJoinCount;
        }

        public int getYueyouLikeCount() {
            return YueyouLikeCount;
        }

        public void setYueyouLikeCount(int YueyouLikeCount) {
            this.YueyouLikeCount = YueyouLikeCount;
        }

        public int getYueyouReplyCount() {
            return YueyouReplyCount;
        }

        public void setYueyouReplyCount(int YueyouReplyCount) {
            this.YueyouReplyCount = YueyouReplyCount;
        }

        public String getCreated() {
            return Created;
        }

        public void setCreated(String Created) {
            this.Created = Created;
        }

        public String getUpdated() {
            return Updated;
        }

        public void setUpdated(String Updated) {
            this.Updated = Updated;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public boolean isIsTop() {
            return IsTop;
        }

        public void setIsTop(boolean IsTop) {
            this.IsTop = IsTop;
        }

        public String getPosition() {
            return Position;
        }

        public void setPosition(String Position) {
            this.Position = Position;
        }

        public boolean isIsCohabit() {
            return IsCohabit;
        }

        public void setIsCohabit(boolean IsCohabit) {
            this.IsCohabit = IsCohabit;
        }

        public int getComId() {
            return ComId;
        }

        public void setComId(int ComId) {
            this.ComId = ComId;
        }

        public AssemblingPlaceEntity getAssemblingPlace() {
            return AssemblingPlace;
        }

        public void setAssemblingPlace(AssemblingPlaceEntity AssemblingPlace) {
            this.AssemblingPlace = AssemblingPlace;
        }

        public String getPlatform() {
            return Platform;
        }

        public void setPlatform(String Platform) {
            this.Platform = Platform;
        }

        public String getNickname() {
            return Nickname;
        }

        public void setNickname(String Nickname) {
            this.Nickname = Nickname;
        }

        public String getHeadUrl() {
            return HeadUrl;
        }

        public void setHeadUrl(String HeadUrl) {
            this.HeadUrl = HeadUrl;
        }

        public Object getLikeList() {
            return LikeList;
        }

        public void setLikeList(Object LikeList) {
            this.LikeList = LikeList;
        }

        public Object getJoinList() {
            return JoinList;
        }

        public void setJoinList(Object JoinList) {
            this.JoinList = JoinList;
        }

        public Object getReplyList() {
            return ReplyList;
        }

        public void setReplyList(Object ReplyList) {
            this.ReplyList = ReplyList;
        }

        public int getAge() {
            return Age;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String Gender) {
            this.Gender = Gender;
        }

        public String getUserTags() {
            return UserTags;
        }

        public void setUserTags(String UserTags) {
            this.UserTags = UserTags;
        }

        public String getWork() {
            return Work;
        }

        public void setWork(String Work) {
            this.Work = Work;
        }

        public boolean isIsLike() {
            return IsLike;
        }

        public void setIsLike(boolean IsLike) {
            this.IsLike = IsLike;
        }

        public double getDistance() {
            return Distance;
        }

        public void setDistance(double Distance) {
            this.Distance = Distance;
        }

        public String getGid() {
            return Gid;
        }

        public void setGid(String Gid) {
            this.Gid = Gid;
        }

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }

        public String getMaritalStatus() {
            return MaritalStatus;
        }

        public void setMaritalStatus(String MaritalStatus) {
            this.MaritalStatus = MaritalStatus;
        }

        public String getWantGo() {
            return WantGo;
        }

        public void setWantGo(String WantGo) {
            this.WantGo = WantGo;
        }

        public boolean isIsGroup() {
            return IsGroup;
        }

        public void setIsGroup(boolean IsGroup) {
            this.IsGroup = IsGroup;
        }

        public boolean isIsJoin() {
            return IsJoin;
        }

        public void setIsJoin(boolean IsJoin) {
            this.IsJoin = IsJoin;
        }

        public Object getRecommendRes() {
            return RecommendRes;
        }

        public void setRecommendRes(Object RecommendRes) {
            this.RecommendRes = RecommendRes;
        }

        public int getRecommendResCount() {
            return RecommendResCount;
        }

        public void setRecommendResCount(int RecommendResCount) {
            this.RecommendResCount = RecommendResCount;
        }

        public String getRecommendCity() {
            return RecommendCity;
        }

        public void setRecommendCity(String RecommendCity) {
            this.RecommendCity = RecommendCity;
        }

        public boolean isRecommend() {
            return Recommend;
        }

        public void setRecommend(boolean Recommend) {
            this.Recommend = Recommend;
        }

        public List<PicListEntity> getPicList() {
            return PicList;
        }

        public void setPicList(List<PicListEntity> PicList) {
            this.PicList = PicList;
        }

        public static class AssemblingPlaceEntity {
            private int ComId;
            private String Address;
            private String Locate;
            private String Country;
            private String Province;
            private String City;
            private String Section;
            private int YueyouCount;
            private String PicUrl;

            public int getComId() {
                return ComId;
            }

            public void setComId(int ComId) {
                this.ComId = ComId;
            }

            public String getAddress() {
                return Address;
            }

            public void setAddress(String Address) {
                this.Address = Address;
            }

            public String getLocate() {
                return Locate;
            }

            public void setLocate(String Locate) {
                this.Locate = Locate;
            }

            public String getCountry() {
                return Country;
            }

            public void setCountry(String Country) {
                this.Country = Country;
            }

            public String getProvince() {
                return Province;
            }

            public void setProvince(String Province) {
                this.Province = Province;
            }

            public String getCity() {
                return City;
            }

            public void setCity(String City) {
                this.City = City;
            }

            public String getSection() {
                return Section;
            }

            public void setSection(String Section) {
                this.Section = Section;
            }

            public int getYueyouCount() {
                return YueyouCount;
            }

            public void setYueyouCount(int YueyouCount) {
                this.YueyouCount = YueyouCount;
            }

            public String getPicUrl() {
                return PicUrl;
            }

            public void setPicUrl(String PicUrl) {
                this.PicUrl = PicUrl;
            }
        }

        public static class PicListEntity {
            private int Ypid;
            private int Yid;
            private String Url;
            private String Created;
            private String Uid;
            private int Status;

            public int getYpid() {
                return Ypid;
            }

            public void setYpid(int Ypid) {
                this.Ypid = Ypid;
            }

            public int getYid() {
                return Yid;
            }

            public void setYid(int Yid) {
                this.Yid = Yid;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public String getCreated() {
                return Created;
            }

            public void setCreated(String Created) {
                this.Created = Created;
            }

            public String getUid() {
                return Uid;
            }

            public void setUid(String Uid) {
                this.Uid = Uid;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }
        }
    }

    public static class BannerEntity {
        private int Bid;
        private String Title;
        private String PicUrl;
        private String Mark;
        private String Extend;
        private int Sort;
        private int Type;
        private int Area;

        public int getBid() {
            return Bid;
        }

        public void setBid(int Bid) {
            this.Bid = Bid;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getPicUrl() {
            return PicUrl;
        }

        public void setPicUrl(String PicUrl) {
            this.PicUrl = PicUrl;
        }

        public String getMark() {
            return Mark;
        }

        public void setMark(String Mark) {
            this.Mark = Mark;
        }

        public String getExtend() {
            return Extend;
        }

        public void setExtend(String Extend) {
            this.Extend = Extend;
        }

        public int getSort() {
            return Sort;
        }

        public void setSort(int Sort) {
            this.Sort = Sort;
        }

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public int getArea() {
            return Area;
        }

        public void setArea(int Area) {
            this.Area = Area;
        }
    }

    public static class TopicEntity {
        private int Tid;
        private String Title;
        private String PicUrl;
        private String ReasonUrl;
        private String Reason;
        private int Status;
        private String Created;
        private int ReplyCount;
        private Object List;

        public int getTid() {
            return Tid;
        }

        public void setTid(int Tid) {
            this.Tid = Tid;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getPicUrl() {
            return PicUrl;
        }

        public void setPicUrl(String PicUrl) {
            this.PicUrl = PicUrl;
        }

        public String getReasonUrl() {
            return ReasonUrl;
        }

        public void setReasonUrl(String ReasonUrl) {
            this.ReasonUrl = ReasonUrl;
        }

        public String getReason() {
            return Reason;
        }

        public void setReason(String Reason) {
            this.Reason = Reason;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getCreated() {
            return Created;
        }

        public void setCreated(String Created) {
            this.Created = Created;
        }

        public int getReplyCount() {
            return ReplyCount;
        }

        public void setReplyCount(int ReplyCount) {
            this.ReplyCount = ReplyCount;
        }

        public Object getList() {
            return List;
        }

        public void setList(Object List) {
            this.List = List;
        }
    }
}
