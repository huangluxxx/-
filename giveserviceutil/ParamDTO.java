package com.property.management.giveserviceutil;

import java.util.ArrayList;

/**
 * 作者：黄璐
 * 版本：1.0
 */
public class ParamDTO {
    private ArrayList<Integer> ids;

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "ParamDTO{" +
                "ids=" + ids +
                '}';
    }
}
