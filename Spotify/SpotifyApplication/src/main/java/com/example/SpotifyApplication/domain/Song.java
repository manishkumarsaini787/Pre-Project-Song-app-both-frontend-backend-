package com.example.SpotifyApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Song {
    @Id
    private String name;
    private String artistName;
    private double duration;
    private String path;
    private String image;



}
