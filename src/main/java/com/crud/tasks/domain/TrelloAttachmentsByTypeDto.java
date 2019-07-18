package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloAttachmentsByTypeDto {

    @JsonProperty("trello")
    private TrelloTrelloDto trello;

    public TrelloAttachmentsByTypeDto() {
    }

    public TrelloAttachmentsByTypeDto(TrelloTrelloDto trello) {
        this.trello = trello;
    }

    public TrelloTrelloDto getTrello() {
        return trello;
    }
}
