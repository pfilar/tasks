package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    // Wewnątrz klasy TrelloController występuje iteracja po zwróconych tablicach.
    // Rozbuduj iterację o filtrowanie, pozwalając wyświetlić tylko i wyłącznie takie tablice, które posiadają pola id i name
    // oraz których nazwa zawiera w sobie słowo Kodilla.

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        //module 22
        //trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
        //Task22.2

        trelloBoards.stream()
                .filter(board -> !board.getId().isEmpty()&&!board.getName().isEmpty())
                .filter(board -> board.getName().contains("Kodilla"))
                .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
    }
}
