package cn.aka.pojo;

public class SecurityVo {
    private Integer userid;
    private Integer roleid;
    private String username;
    private String company;
    private Integer dataid;
    private String searchStarttime;
    private String searchEndtime;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public String getSearchStarttime() {
        return searchStarttime;
    }

    public void setSearchStarttime(String searchStarttime) {
        this.searchStarttime = searchStarttime;
    }

    public String getSearchEndtime() {
        return searchEndtime;
    }

    public void setSearchEndtime(String searchEndtime) {
        this.searchEndtime = searchEndtime;
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
