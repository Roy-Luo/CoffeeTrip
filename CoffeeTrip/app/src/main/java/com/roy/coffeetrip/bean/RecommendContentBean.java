package com.roy.coffeetrip.bean;

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
    private int serial_id;
    private int serial_position;
    private int serial_next_id;
    private int updated_at;


    private TipEntity tip;
    /**
     * id : 25836
     * name : 饕餮89
     * image : http://tp3.sinaimg.cn/1856838602/180/40005314526/1
     */

    private UserEntity user;
    private Object upload_token;
    private boolean current_user_favorite;
    private Object password;
    private String front_cover_photo_url;


    private List<TripDaysEntity> trip_days;

    private List<NotesLikesCommentsEntity> notes_likes_comments;

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

    public int getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(int serial_id) {
        this.serial_id = serial_id;
    }

    public int getSerial_position() {
        return serial_position;
    }

    public void setSerial_position(int serial_position) {
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

    public TipEntity getTip() {
        return tip;
    }

    public void setTip(TipEntity tip) {
        this.tip = tip;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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

    public List<TripDaysEntity> getTrip_days() {
        return trip_days;
    }

    public void setTrip_days(List<TripDaysEntity> trip_days) {
        this.trip_days = trip_days;
    }

    public List<NotesLikesCommentsEntity> getNotes_likes_comments() {
        return notes_likes_comments;
    }

    public void setNotes_likes_comments(List<NotesLikesCommentsEntity> notes_likes_comments) {
        this.notes_likes_comments = notes_likes_comments;
    }

    public static class TipEntity {
        private int id;
        private List<String> texts;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getTexts() {
            return texts;
        }

        public void setTexts(List<String> texts) {
            this.texts = texts;
        }
    }

    public static class UserEntity {
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

    public static class TripDaysEntity {
        private int id;
        private String trip_date;
        private int day;
        private int updated_at;
        /**
         * id : 178
         * name_zh_cn : 罗马
         */

        private DestinationEntity destination;


        private List<NodesEntity> nodes;

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

        public DestinationEntity getDestination() {
            return destination;
        }

        public void setDestination(DestinationEntity destination) {
            this.destination = destination;
        }

        public List<NodesEntity> getNodes() {
            return nodes;
        }

        public void setNodes(List<NodesEntity> nodes) {
            this.nodes = nodes;
        }

        public static class DestinationEntity {
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

        public static class NodesEntity {
            private int id;
            private int row_order;
            private int score;
            private Object comment;
            private Object tips;
            private Object entry_id;
            private float lat;
            private float lng;
            private Object entry_type;
            private boolean user_entry;
            private Object entry_name;
            private Object attraction_type;
            private int updated_at;


            private List<NotesEntity> notes;

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

            public Object getEntry_id() {
                return entry_id;
            }

            public void setEntry_id(Object entry_id) {
                this.entry_id = entry_id;
            }

            public float getLat() {
                return lat;
            }

            public void setLat(float lat) {
                this.lat = lat;
            }

            public float getLng() {
                return lng;
            }

            public void setLng(float lng) {
                this.lng = lng;
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

            public List<NotesEntity> getNotes() {
                return notes;
            }

            public void setNotes(List<NotesEntity> notes) {
                this.notes = notes;
            }

            public static class NotesEntity {
                private int id;
                private int row_order;
                private String layout;
                private int col;
                private String description;
                private int updated_at;

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

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }
            }
        }
    }

    public static class NotesLikesCommentsEntity {
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
