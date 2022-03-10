package cn.aka.pojo;

public class SharesVo {
    private String securityname;
    private String sharesname;
    private String holder;
    private Integer userid;
    private Integer roleid;
    // 数据库从哪一条数据开始查
    private Integer start;
    // 每页显示数据条数
    private Integer size;

    public String getSecurityname() {
        return securityname;
    }

    public void setSecurityname(String securityname) {
        this.securityname = securityname;
    }

    public String getSharesname() {
        return sharesname;
    }

    public void setSharesname(String sharesname) {
        this.sharesname = sharesname;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

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
