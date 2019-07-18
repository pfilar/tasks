package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrelloBoardDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;

    public TrelloBoardDto() {
    }

    public TrelloBoardDto(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<TrelloListDto> getLists() {
        return lists;
    }
}
