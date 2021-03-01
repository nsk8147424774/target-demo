package com.target.IncidentProject.constants;

import java.util.HashMap;
import java.util.Map;

public enum StatusType {

    STATUS_NEW_REQUEST(1L, "new request"),
    STATUS_WORK_IN_PROGRESS(2L, "work in progress"),
    STATUS_COMPLETE(3L, "complete"),
    STATUS_CLOSE(4L, "close");

    private Long id;
    private String mesage;

    StatusType(Long i , String s){

        this.id = i;
        this.mesage = s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    private static final Map<Long, StatusType> byId = new HashMap<Long, StatusType>();
    static {
        for (StatusType e : StatusType.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

    public static StatusType getById(Long id) {
        return byId.get(id);
    }
}
