package com.movie.crawling.Enum;

public enum DownloadStatusEnum {

    DOWNLOAD_SUCCESS("1", "下载成功"),
    DOWNLOAD_FAILED("0", "下载失败");

    private String status;
    private String desc;

    private DownloadStatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
