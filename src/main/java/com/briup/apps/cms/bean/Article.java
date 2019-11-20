package com.briup.apps.cms.bean;

public class Article {
    private Long id;

    private String title;

    private String content;

    private String source;

    private Long publishTime;

    private Long readTimes;

    private String status;

    private Long thumpUp;

    private Long thumpDown;

    private Long authorId;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Long getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Long readTimes) {
        this.readTimes = readTimes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getThumpUp() {
        return thumpUp;
    }

    public void setThumpUp(Long thumpUp) {
        this.thumpUp = thumpUp;
    }

    public Long getThumpDown() {
        return thumpDown;
    }

    public void setThumpDown(Long thumpDown) {
        this.thumpDown = thumpDown;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}