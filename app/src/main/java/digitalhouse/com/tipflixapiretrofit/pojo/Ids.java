package digitalhouse.com.tipflixapiretrofit.pojo;

import com.google.gson.annotations.SerializedName;

public class Ids {

    @SerializedName("trakt")
    private Integer trakt;
    @SerializedName("slug")
    private String slug;
    @SerializedName("imdb")
    private String imdb;
    @SerializedName("tmdb")
    private Integer tmdb;

    public Integer getTrakt() {
        return trakt;
    }

    public void setTrakt(Integer trakt) {
        this.trakt = trakt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public Integer getTmdb() {
        return tmdb;
    }

    public void setTmdb(Integer tmdb) {
        this.tmdb = tmdb;
    }

}