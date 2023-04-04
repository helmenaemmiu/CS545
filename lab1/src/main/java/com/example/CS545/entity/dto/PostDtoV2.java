package com.example.CS545.entity.dto;

import lombok.Data;

@Data
public class PostDtoV2 {
    String title;

    public String getTitle() {
        return title + " V2";
    }

    String content;
    String author;
}
