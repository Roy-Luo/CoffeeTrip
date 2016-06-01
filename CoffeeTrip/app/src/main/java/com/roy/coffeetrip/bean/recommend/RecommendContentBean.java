package com.roy.coffeetrip.bean.recommend;

import java.util.List;

/**
 * Created by ${Roy} on 16/5/14.
 */
public class RecommendContentBean {


    private int id;
    private String name;
    private int photos_count;
    private String start_date;
    private String end_date;
    private int level;
    private boolean privacy;
    private int front_cover_photo_id;
    private int views_count;
    private int comments_count;
    private int likes_count;
    private int favorites_count;
    private String state;
    private String source;
    private Object serial_id;
    private Object serial_position;
    private int serial_next_id;
    private int updated_at;
    /**
     * id : 443679
     * name : 醉美精灵之一
     * image : http://tp4.sinaimg.cn/3018640455/180/5735107036/0
     */

    private UserBean user;
    private Object upload_token;
    private boolean current_user_favorite;
    private Object password;
    private String front_cover_photo_url;
    /**
     * id : 1255158
     * trip_date : 2016-04-29
     * day : 1
     * updated_at : 1463199808
     * destination : {"id":211,"name_zh_cn":"伊朗"}
     */

    private List<TripDaysBean> trip_days;
    /**
     * id : 14988540
     * comments_count : 0
     * likes_count : 1
     * current_user_like : false
     * current_user_comment : false
     */

    private List<NotesLikesCommentsBean> notes_likes_comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public int getFront_cover_photo_id() {
        return front_cover_photo_id;
    }

    public void setFront_cover_photo_id(int front_cover_photo_id) {
        this.front_cover_photo_id = front_cover_photo_id;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(Object serial_id) {
        this.serial_id = serial_id;
    }

    public Object getSerial_position() {
        return serial_position;
    }

    public void setSerial_position(Object serial_position) {
        this.serial_position = serial_position;
    }

    public int getSerial_next_id() {
        return serial_next_id;
    }

    public void setSerial_next_id(int serial_next_id) {
        this.serial_next_id = serial_next_id;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Object getUpload_token() {
        return upload_token;
    }

    public void setUpload_token(Object upload_token) {
        this.upload_token = upload_token;
    }

    public boolean isCurrent_user_favorite() {
        return current_user_favorite;
    }

    public void setCurrent_user_favorite(boolean current_user_favorite) {
        this.current_user_favorite = current_user_favorite;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getFront_cover_photo_url() {
        return front_cover_photo_url;
    }

    public void setFront_cover_photo_url(String front_cover_photo_url) {
        this.front_cover_photo_url = front_cover_photo_url;
    }

    public List<TripDaysBean> getTrip_days() {
        return trip_days;
    }

    public void setTrip_days(List<TripDaysBean> trip_days) {
        this.trip_days = trip_days;
    }

    public List<NotesLikesCommentsBean> getNotes_likes_comments() {
        return notes_likes_comments;
    }

    public void setNotes_likes_comments(List<NotesLikesCommentsBean> notes_likes_comments) {
        this.notes_likes_comments = notes_likes_comments;
    }

    public static class UserBean {
        private int id;
        private String name;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class TripDaysBean {
        private int id;
        private String trip_date;
        private int day;
        private int updated_at;
        /**
         * id : 211
         * name_zh_cn : 伊朗
         */

        private DestinationBean destination;
        /**
         * id : 2665776
         * row_order : 0
         * score : 0
         * comment : null
         * tips : null
         * memo : {}
         * entry_id : null
         * lat : 0
         * lng : 0
         * entry_type : null
         * user_entry : false
         * entry_name : null
         * attraction_type : null
         * updated_at : 1463199808
         * notes : [{"id":14988540,"row_order":0,"layout":"full","col":0,"description":"人生中第一次约伴旅行献给了伊朗。\r\n有一部电影叫《逃离德黑兰》，而我在伊朗的日子就有这种感觉。\r\n伊朗旅行是否安全我根本不担心。在去过伊朗回来后我觉得：\r\n每天的吃饭还有每天的住宿and网络都是我比较担忧的问题。其他都ok!\r\n这次旅行少了老公的陪伴，和几个不熟悉的朋友踏上波斯国度。\r\n为了减轻重量，旅行前一天换掉我70D的套头镜头135mm 。太重拍片一般。\r\n于是重新购置了50mm/f1.4的定焦镜头。非常适合女生独自行旅行用。\r\n\r\n在伊朗的每一天，我都在思考：我什么来这个国家旅游？\r\n因为没来过，所以要来看看吗？\r\n因为这里有波斯地毯和波斯美女and帅吗？\r\n因为这里的无数美丽的穹顶，以及卖各式工艺品的大巴扎吗？\r\n\r\n想了想，我记不清为什么了... ... \r\n","updated_at":1463206833},{"id":14988541,"row_order":4194304,"layout":"full","col":1,"description":"伊朗十天，去了传统的五个城市。\r\n德黑兰和亚兹德无感，卡尚和设拉子还可以。最爱伊斯法罕。\r\n要说自然风光，伊朗的风光远不及新西兰带给我的自然纯净。\r\n要说色彩丰富，伊朗的色彩没有印度的五彩斑斓，甚至是沉闷的。\r\n要说美味食物，伊朗的远不及中国的食物美味可口。\r\n\r\n\r\n因为伊朗不是我去过的第一个国家，\r\n它也不是我去过后每天魂牵梦绕的地方。\r\n有时候难免会和其他国家相提并论。\r\n但是伊朗式的伊朗，也会有不一样的特色：\r\n波斯以前是许多部落中的其中一个部落，后来慢慢壮大，于是领导人觉得波斯这个名字太小了，于是重新起名叫伊朗。\r\n\r\n波斯人和阿拉伯人不是一个概念。\r\n伊朗人不喜欢被人当做是阿拉伯人。\r\n真难以想象这个被禁锢的国家，\r\n既不投靠东方，也不投靠西方。他们要独立自强。  \r\n","updated_at":1463206745},{"id":14988544,"row_order":6291456,"layout":"full","col":2,"description":"这次旅行：\r\n\r\n我第一次在旅行中被要求全程戴头巾，衣服要遮住臀部，穿衣保守。\r\n周围的一切色彩单调保守，网络不发达，每天都吃米饭配烤肉。\r\n尤其是当地货币位数那么多零，让人发晕。每天都有无数个黑袍从你身边经过。\r\n到了自己的饭点，满大街关门找不到吃饭的地方。他们吃饭都有固定时间。\r\n每晚拿着手机刷着屏幕只祈求能和家人保持联系。\r\n\r\n在荒芜贫瘠的公路上，中途上个厕所，被几个伊朗男人盯着。\r\n在三十三孔桥上，被伊朗男人\u201c看上\u201d，并且被告白I Love you~~\r\n\r\n在伊朗，被伊朗男人搭讪的几率很高，如果你坐在广场上，\r\n便会有很多人过来搭讪，问你来自哪里，有些处于好奇，有些出于其他目的。\r\n\r\n伊朗男人的霸权意识很强，他们喜欢被女人包围，照相也喜欢勾肩搭背。\r\n在伊朗，不管是单身女性还是结伴，遭遇咸猪手的几率很高。","updated_at":1463206728},{"id":14988545,"row_order":7340032,"layout":"full","col":3,"description":"国际机票： 北京--德黑兰   往返  4018元 /人 \r\n国内机票： 德黑兰--设拉子   单飞  432元/人\r\n\r\n打电话给上海那边的办事处：021-22871200 打电话直接预订就好了。付款时方式邮箱里会发。德黑兰到设拉子当天两班，选择了晚上7:40分的。一个人432元。\r\n马汉上海办事处：021-62473300  \r\n\r\n签证：500元\r\n淘宝代办。后来去波斯波利斯一起包车的女孩是自己跑去大使馆，还可以代拿，才花了300多。可以自己办理。\r\n\r\n \r\n\r\n ","updated_at":1463206904}]
         */

        private List<NodesBean> nodes;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTrip_date() {
            return trip_date;
        }

        public void setTrip_date(String trip_date) {
            this.trip_date = trip_date;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public DestinationBean getDestination() {
            return destination;
        }

        public void setDestination(DestinationBean destination) {
            this.destination = destination;
        }

        public List<NodesBean> getNodes() {
            return nodes;
        }

        public void setNodes(List<NodesBean> nodes) {
            this.nodes = nodes;
        }

        public static class DestinationBean {
            private int id;
            private String name_zh_cn;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName_zh_cn() {
                return name_zh_cn;
            }

            public void setName_zh_cn(String name_zh_cn) {
                this.name_zh_cn = name_zh_cn;
            }
        }

        public static class NodesBean {
            private int id;
            private int row_order;
            private int score;
            private Object comment;
            private Object tips;
            private MemoBean memo;
            private Object entry_id;


            private Object entry_type;
            private boolean user_entry;
            private Object entry_name;
            private Object attraction_type;
            private int updated_at;
            /**
             * id : 14988540
             * row_order : 0
             * layout : full
             * col : 0
             * description : 人生中第一次约伴旅行献给了伊朗。
             * 有一部电影叫《逃离德黑兰》，而我在伊朗的日子就有这种感觉。
             * 伊朗旅行是否安全我根本不担心。在去过伊朗回来后我觉得：
             * 每天的吃饭还有每天的住宿and网络都是我比较担忧的问题。其他都ok!
             * 这次旅行少了老公的陪伴，和几个不熟悉的朋友踏上波斯国度。
             * 为了减轻重量，旅行前一天换掉我70D的套头镜头135mm 。太重拍片一般。
             * 于是重新购置了50mm/f1.4的定焦镜头。非常适合女生独自行旅行用。
             * <p>
             * 在伊朗的每一天，我都在思考：我什么来这个国家旅游？
             * 因为没来过，所以要来看看吗？
             * 因为这里有波斯地毯和波斯美女and帅吗？
             * 因为这里的无数美丽的穹顶，以及卖各式工艺品的大巴扎吗？
             * <p>
             * 想了想，我记不清为什么了... ...
             * <p>
             * updated_at : 1463206833
             */

            private List<NotesBean> notes;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRow_order() {
                return row_order;
            }

            public void setRow_order(int row_order) {
                this.row_order = row_order;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public Object getComment() {
                return comment;
            }

            public void setComment(Object comment) {
                this.comment = comment;
            }

            public Object getTips() {
                return tips;
            }

            public void setTips(Object tips) {
                this.tips = tips;
            }

            public MemoBean getMemo() {
                return memo;
            }

            public void setMemo(MemoBean memo) {
                this.memo = memo;
            }

            public Object getEntry_id() {
                return entry_id;
            }

            public void setEntry_id(Object entry_id) {
                this.entry_id = entry_id;
            }

            public Object getEntry_type() {
                return entry_type;
            }

            public void setEntry_type(Object entry_type) {
                this.entry_type = entry_type;
            }

            public boolean isUser_entry() {
                return user_entry;
            }

            public void setUser_entry(boolean user_entry) {
                this.user_entry = user_entry;
            }

            public Object getEntry_name() {
                return entry_name;
            }

            public void setEntry_name(Object entry_name) {
                this.entry_name = entry_name;
            }

            public Object getAttraction_type() {
                return attraction_type;
            }

            public void setAttraction_type(Object attraction_type) {
                this.attraction_type = attraction_type;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public List<NotesBean> getNotes() {
                return notes;
            }

            public void setNotes(List<NotesBean> notes) {
                this.notes = notes;
            }

            public static class MemoBean {
            }

            public static class NotesBean {

                /**
                 * id : 13998756
                 * row_order : -4194303
                 * layout : full
                 * col : 1
                 * description : null
                 * updated_at : 1457072119
                 * photo : {"id":12988569,"image_width":1080,"image_height":720,"image_file_size":132172,"exif_lat":null,"exif_lng":null,"exif_date_time_original":1454953437,"url":""}
                 */

                private int id;
                private int row_order;
                private String layout;
                private int col;
                private Object description;
                private int updated_at;
                /**
                 * id : 12988569
                 * image_width : 1080
                 * image_height : 720
                 * image_file_size : 132172
                 * exif_lat : null
                 * exif_lng : null
                 * exif_date_time_original : 1454953437
                 * url :
                 */

                private PhotoBean photo;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getRow_order() {
                    return row_order;
                }

                public void setRow_order(int row_order) {
                    this.row_order = row_order;
                }

                public String getLayout() {
                    return layout;
                }

                public void setLayout(String layout) {
                    this.layout = layout;
                }

                public int getCol() {
                    return col;
                }

                public void setCol(int col) {
                    this.col = col;
                }

                public Object getDescription() {
                    return description;
                }

                public void setDescription(Object description) {
                    this.description = description;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }

                public PhotoBean getPhoto() {
                    return photo;
                }

                public void setPhoto(PhotoBean photo) {
                    this.photo = photo;
                }

                public static class PhotoBean {
                    private int id;
                    private int image_width;
                    private int image_height;
                    private int image_file_size;
                    private Object exif_lat;
                    private Object exif_lng;
                    private int exif_date_time_original;
                    private String url;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getImage_width() {
                        return image_width;
                    }

                    public void setImage_width(int image_width) {
                        this.image_width = image_width;
                    }

                    public int getImage_height() {
                        return image_height;
                    }

                    public void setImage_height(int image_height) {
                        this.image_height = image_height;
                    }

                    public int getImage_file_size() {
                        return image_file_size;
                    }

                    public void setImage_file_size(int image_file_size) {
                        this.image_file_size = image_file_size;
                    }

                    public Object getExif_lat() {
                        return exif_lat;
                    }

                    public void setExif_lat(Object exif_lat) {
                        this.exif_lat = exif_lat;
                    }

                    public Object getExif_lng() {
                        return exif_lng;
                    }

                    public void setExif_lng(Object exif_lng) {
                        this.exif_lng = exif_lng;
                    }

                    public int getExif_date_time_original() {
                        return exif_date_time_original;
                    }

                    public void setExif_date_time_original(int exif_date_time_original) {
                        this.exif_date_time_original = exif_date_time_original;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }
    }

    public static class NotesLikesCommentsBean {
        private int id;
        private int comments_count;
        private int likes_count;
        private boolean current_user_like;
        private boolean current_user_comment;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public boolean isCurrent_user_like() {
            return current_user_like;
        }

        public void setCurrent_user_like(boolean current_user_like) {
            this.current_user_like = current_user_like;
        }

        public boolean isCurrent_user_comment() {
            return current_user_comment;
        }

        public void setCurrent_user_comment(boolean current_user_comment) {
            this.current_user_comment = current_user_comment;
        }
    }
}