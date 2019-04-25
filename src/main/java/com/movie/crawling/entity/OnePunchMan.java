package com.movie.crawling.entity;

import java.io.Serializable;

public class OnePunchMan implements Serializable{

    private static final long serialVersionUID = 1L;

    private String errno;

    private String errmsg;

    private DataEntity data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OnePunchMan{" +
                "errno='" + errno + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}
