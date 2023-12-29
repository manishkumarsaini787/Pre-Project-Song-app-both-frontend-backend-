package com.example.SpotifyApplication.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document

public class User {

    private String firstName;

    private String lastName;
    @Id
    private String email;

    private String password;

    private List<PlayList> playlist;

}
