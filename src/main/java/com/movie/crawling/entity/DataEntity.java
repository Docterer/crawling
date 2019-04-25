package com.movie.crawling.entity;

import java.util.List;

public class DataEntity {

    private int id;
    private String title;
    private int numberStart;
    private int numberEnd;
    private int animeID;
    private int isImgBed;
    private String imgBed;
    private List<ContentImg> contentImg;
    private String contentBefore;
    private String contentAfter;
    private long time;
    private long updateTime;
    private int authorID;
    private int sourceID;
    private String url;
    private int chapter;
    private int needLogin;
    private int sticky;
    private String authorName;
    private String naimeName;
    private String authorizeComics;
    private int wxShowComics;
    private String iosShowComics;
    private String androidShowComics;
    private String sourceName;
    private String partName;

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

    public int getNumberStart() {
        return numberStart;
    }

    public void setNumberStart(int numberStart) {
        this.numberStart = numberStart;
    }

    public int getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(int numberEnd) {
        this.numberEnd = numberEnd;
    }

    public int getAnimeID() {
        return animeID;
    }

    public void setAnimeID(int animeID) {
        this.animeID = animeID;
    }

    public int getIsImgBed() {
        return isImgBed;
    }

    public void setIsImgBed(int isImgBed) {
        this.isImgBed = isImgBed;
    }

    public String getImgBed() {
        return imgBed;
    }

    public void setImgBed(String imgBed) {
        this.imgBed = imgBed;
    }

    public List<ContentImg> getContentImg() {
        return contentImg;
    }

    public void setContentImg(List<ContentImg> contentImg) {
        this.contentImg = contentImg;
    }

    public String getContentBefore() {
        return contentBefore;
    }

    public void setContentBefore(String contentBefore) {
        this.contentBefore = contentBefore;
    }

    public String getContentAfter() {
        return contentAfter;
    }

    public void setContentAfter(String contentAfter) {
        this.contentAfter = contentAfter;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getSourceID() {
        return sourceID;
    }

    public void setSourceID(int sourceID) {
        this.sourceID = sourceID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(int needLogin) {
        this.needLogin = needLogin;
    }

    public int getSticky() {
        return sticky;
    }

    public void setSticky(int sticky) {
        this.sticky = sticky;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNaimeName() {
        return naimeName;
    }

    public void setNaimeName(String naimeName) {
        this.naimeName = naimeName;
    }

    public String getAuthorizeComics() {
        return authorizeComics;
    }

    public void setAuthorizeComics(String authorizeComics) {
        this.authorizeComics = authorizeComics;
    }

    public int getWxShowComics() {
        return wxShowComics;
    }

    public void setWxShowComics(int wxShowComics) {
        this.wxShowComics = wxShowComics;
    }

    public String getIosShowComics() {
        return iosShowComics;
    }

    public void setIosShowComics(String iosShowComics) {
        this.iosShowComics = iosShowComics;
    }

    public String getAndroidShowComics() {
        return androidShowComics;
    }

    public void setAndroidShowComics(String androidShowComics) {
        this.androidShowComics = androidShowComics;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberStart=" + numberStart +
                ", numberEnd=" + numberEnd +
                ", animeID=" + animeID +
                ", isImgBed=" + isImgBed +
                ", imgBed='" + imgBed + '\'' +
                ", contentImg=" + contentImg +
                ", contentBefore='" + contentBefore + '\'' +
                ", contentAfter='" + contentAfter + '\'' +
                ", time=" + time +
                ", updateTime=" + updateTime +
                ", authorID=" + authorID +
                ", sourceID=" + sourceID +
                ", url='" + url + '\'' +
                ", chapter=" + chapter +
                ", needLogin=" + needLogin +
                ", sticky=" + sticky +
                ", authorName='" + authorName + '\'' +
                ", naimeName='" + naimeName + '\'' +
                ", authorizeComics='" + authorizeComics + '\'' +
                ", wxShowComics=" + wxShowComics +
                ", iosShowComics='" + iosShowComics + '\'' +
                ", androidShowComics='" + androidShowComics + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", partName='" + partName + '\'' +
                '}';
    }
}
