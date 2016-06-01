package com.roy.coffeetrip.bean.hunter;

import java.util.List;

/**
 * Created by ${Roy} on 16/5/23.
 */
public class HunterContentBean {
    private int id;
    private String name_zh_cn;
    private String name_en;
    private int poi_count;
    private int plans_count;
    private int articles_count;
    private int contents_count;
    private int destination_trips_count;
    private boolean locked;
    private boolean wiki_app_publish;
    private int updated_at;
    private String image_url;
    private int guides_count;
    private IntroEntity intro;


    private List<DestinationContentsEntity> destination_contents;

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

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getPoi_count() {
        return poi_count;
    }

    public void setPoi_count(int poi_count) {
        this.poi_count = poi_count;
    }

    public int getPlans_count() {
        return plans_count;
    }

    public void setPlans_count(int plans_count) {
        this.plans_count = plans_count;
    }

    public int getArticles_count() {
        return articles_count;
    }

    public void setArticles_count(int articles_count) {
        this.articles_count = articles_count;
    }

    public int getContents_count() {
        return contents_count;
    }

    public void setContents_count(int contents_count) {
        this.contents_count = contents_count;
    }

    public int getDestination_trips_count() {
        return destination_trips_count;
    }

    public void setDestination_trips_count(int destination_trips_count) {
        this.destination_trips_count = destination_trips_count;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isWiki_app_publish() {
        return wiki_app_publish;
    }

    public void setWiki_app_publish(boolean wiki_app_publish) {
        this.wiki_app_publish = wiki_app_publish;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getGuides_count() {
        return guides_count;
    }

    public void setGuides_count(int guides_count) {
        this.guides_count = guides_count;
    }

    public IntroEntity getIntro() {
        return intro;
    }

    public void setIntro(IntroEntity intro) {
        this.intro = intro;
    }

    public List<DestinationContentsEntity> getDestination_contents() {
        return destination_contents;
    }

    public void setDestination_contents(List<DestinationContentsEntity> destination_contents) {
        this.destination_contents = destination_contents;
    }

    public static class IntroEntity {
        /**
         * description : 日本，由北海道、本州、四国、九州四个大岛和各小岛组成的东亚岛国。日剧，动漫，铁路，日料，樱花，枫叶，温泉……这些美好的关键词拼出对日本旅行最初的向往。
         * photo_url : http://p.chanyouji.cn/95934/1389868262641p18ed9l94c1p071jd91ao3dmd1gli2.jpg
         */

        private List<NotesEntity> notes;

        public List<NotesEntity> getNotes() {
            return notes;
        }

        public void setNotes(List<NotesEntity> notes) {
            this.notes = notes;
        }

        public static class NotesEntity {
            private String description;
            private String photo_url;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }
        }
    }

    public static class DestinationContentsEntity {
        private String name;
        private String description_html;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription_html() {
            return description_html;
        }

        public void setDescription_html(String description_html) {
            this.description_html = description_html;
        }
    }
}
