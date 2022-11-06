package com.spotify_unifor.spotify_unifor.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, unique = true)
    private String nomePlaylist;

    public Playlist(Integer id, String nomePlaylist) {
        this.id = id;
        this.nomePlaylist = nomePlaylist;
    }

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cart_item")
    @JsonManagedReference
    private List<Musica> lista_musicas = new ArrayList<>();

    public void setarMusica(Musica musica){
        this.lista_musicas.add(musica);
    }
}
