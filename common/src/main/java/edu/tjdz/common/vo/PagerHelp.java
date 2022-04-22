package edu.tjdz.common.vo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class PagerHelp implements Serializable {

    private int totalCount;
    private Object data;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PagerHelp() {
    }

    public PagerHelp(int totalCount, Object data) {
        this.totalCount = totalCount;
        this.data = data;
    }
}
