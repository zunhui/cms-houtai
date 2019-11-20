package com.briup.apps.cms.bean;

public class Logs {
    private Integer id;

    private String content;

    private Long actionTime;

    private Long userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getActionTime() {
        return actionTime;
    }

    public void setActionTime(Long actionTime) {
        this.actionTime = actionTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}