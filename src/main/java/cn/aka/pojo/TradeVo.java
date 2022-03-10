package cn.aka.pojo;

public class TradeVo {
    private Integer userid;
    private Integer roleid;
    private String sharesname;
    private Integer dataid;
    private String starttime;
    private String endtime;

    // 数据库从哪一条数据开始查
    private Integer start;
    // 每页显示数据条数
    private Integer size;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getSharesname() {
        return sharesname;
    }

    public void setSharesname(String sharesname) {
        this.sharesname = sharesname;
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
