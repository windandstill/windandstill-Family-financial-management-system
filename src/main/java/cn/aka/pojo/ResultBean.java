package cn.aka.pojo;

import java.util.List;

public class ResultBean<T> {
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
