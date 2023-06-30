package com.example.myapplication.shorts;

public class videomodel
{
  String desc,title,url, cmt, hearth;


    public videomodel(String desc, String title, String url, String cmt, String hearth) {
        this.desc = desc;
        this.title = title;
        this.url = url;
        this.cmt = cmt;
        this.hearth = hearth;
    }
    videomodel()
    {

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getHearth() {
        return hearth;
    }

    public void setHearth(String hearth) {
        this.hearth = hearth;
    }

}
