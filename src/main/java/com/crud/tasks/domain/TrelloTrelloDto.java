package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloTrelloDto {

    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;

    public TrelloTrelloDto() {
    }

    public TrelloTrelloDto(int board, int card) {
        this.board = board;
        this.card = card;
    }

    public int getBoard() {
        return board;
    }

    public int getCard() {
        return card;
    }
}
