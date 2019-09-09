package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
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

    public TrelloBoardDto(String name, String id, List<TrelloListDto> lists) {
        this.name = name;
        this.id = id;
        this.lists = lists;
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
