package com.crud.tasks.domain;

import lombok.*;

//@Data
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String content;

    public TaskDto() {
    }

    public TaskDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

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
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
