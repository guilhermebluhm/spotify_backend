package com.spotify_unifor.spotify_unifor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Musica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 100)
    private String nome;
    @Column(length = 100)
    private String link;

    public Musica(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    @ManyToOne
    @JsonBackReference
    private Playlist playlist;

}
