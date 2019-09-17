package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCardDto {

    @NonNull
    @JsonProperty("id")
    private String id;

    @NonNull
    @JsonProperty("name")
    private String name;

    @NonNull
    @JsonProperty("shortUrl")
    private String shortUrl;

    @JsonProperty("badges")
    private BadgesDto badges;
}
