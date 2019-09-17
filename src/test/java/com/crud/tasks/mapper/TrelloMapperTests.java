package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTests {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardTest() {
        //Given
        TrelloListDto trelloListDtoFirst = new TrelloListDto();
        TrelloListDto trelloListDtoSecond = new TrelloListDto();
        List<TrelloListDto> trelloListOfDto = new ArrayList<>();
        trelloListOfDto.add(trelloListDtoFirst);
        trelloListOfDto.add(trelloListDtoSecond);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("id_board_1", "name_board_1", trelloListOfDto);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("id_board_2", "name_board_2", trelloListOfDto);
        List<TrelloBoardDto> trelloBoardDtosList = new ArrayList<>();
        trelloBoardDtosList.add(trelloBoardDto1);
        trelloBoardDtosList.add(trelloBoardDto2);

        //When
        List<TrelloBoard> trelloBoardsList = trelloMapper.mapToBoards(trelloBoardDtosList);

        //Then
        assertEquals(2, trelloBoardsList.size());
        assertEquals("id_board_1", trelloBoardsList.get(0).getId());
        assertEquals("name_board_2", trelloBoardsList.get(1).getName());
    }

    @Test
    public void mapToBoardTestDto(){
        //Given
        TrelloList trelloListDtoFirst = new TrelloList("id_list_1", "name_list", true);
        TrelloList trelloListDtoSecond = new TrelloList("id_list_2", "name_list", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloListDtoFirst);
        trelloLists.add(trelloListDtoSecond);

        TrelloBoard trelloBoard1 = new TrelloBoard("id_1", "name_1", trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("id_2", "name_2", trelloLists);
        List<TrelloBoard> trelloBoardsList = new ArrayList<>();
        trelloBoardsList.add(trelloBoard1);
        trelloBoardsList.add(trelloBoard2);

        //When
        List<TrelloBoardDto> trelloBoardList = trelloMapper.mapToBoardsDto(trelloBoardsList);

        //Then
        assertEquals(2, trelloBoardList.size());
        assertEquals("id_1", trelloBoardList.get(0).getId());
        assertEquals("name_2", trelloBoardList.get(1).getName());
    }

    @Test
    public void mapToListTest(){
        //Given
        TrelloListDto trelloListDtoFirst = new TrelloListDto("id_list_1", "name_list_1", true);
        TrelloListDto trelloListDtoSecond = new TrelloListDto("id_list_2", "name_list_2", true);
        List<TrelloListDto> trelloListOfDto = new ArrayList<>();
        trelloListOfDto.add(trelloListDtoFirst);
        trelloListOfDto.add(trelloListDtoSecond);

        //When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListOfDto);

        //Then
        assertEquals(2, trelloListList.size());
        assertEquals("id_list_1", trelloListList.get(0).getId());
        assertEquals("name_list_2", trelloListList.get(1).getName());
    }

    @Test
    public void mapToListTestDto(){
        //Given
        TrelloList trelloListDtoFirst = new TrelloList("id_list_1", "name_list_1", true);
        TrelloList trelloListDtoSecond = new TrelloList("id_list_2", "name_list_2", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloListDtoFirst);
        trelloLists.add(trelloListDtoSecond);

        //When
        List<TrelloListDto> trelloListDtosList = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(2, trelloListDtosList.size());
        assertEquals("id_list_1", trelloListDtosList.get(0).getId());
        assertEquals("name_list_2", trelloListDtosList.get(1).getName());
    }

    @Test
    public void mapToCardTest(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("name", trelloCard.getName());
        assertEquals("description", trelloCard.getDescription());
        assertEquals("pos", trelloCard.getPos());
        assertEquals("listId", trelloCard.getListId());
    }

    @Test
    public void mapToCardTestDto(){

        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("name", trelloCardDto.getName());
        assertEquals("description", trelloCardDto.getDescription());
        assertEquals("pos", trelloCardDto.getPos());
        assertEquals("listId", trelloCardDto.getListId());
    }



}
