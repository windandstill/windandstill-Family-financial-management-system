package cn.aka.pojo;

public class Result {
    private String incomer; // 收入人
    private String starttime; // 有效开始时间
    private String endtime; // 有效截止时间
    private Integer roleid; // 创建人角色
    private Integer userid; // 创建人ID
    private String payer; // 支出人

    public String getIncomer() {
        return incomer;
    }

    public void setIncomer(String incomer) {
        this.incomer = incomer;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }
}
