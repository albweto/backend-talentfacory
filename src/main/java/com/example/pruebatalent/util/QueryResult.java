package com.example.pruebatalent.util;

import java.util.List;

public class QueryResult {

    private int totalRecordado;
    private List<Object> objectList;

    public int getTotalRecordado() {
        return totalRecordado;
    }

    public void setTotalRecordado(int totalRecordado) {
        this.totalRecordado = totalRecordado;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }
}
