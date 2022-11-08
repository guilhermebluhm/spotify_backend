package com.spotify_unifor.spotify_unifor.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty(required = true)
    @Column(length = 50)
    private String nome;
    @JsonProperty(required = true)
    private String email;
    @Column(length = 100)
    private String senha;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate dtNascimento;
    @Column(length = 1)
    private String genero;

    public Usuario(String nome, String email, String senha, LocalDate dtNascimento, String genero) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtNascimento = dtNascimento;
        this.genero = genero;
    }

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    List<Playlist> lista_playlist = new ArrayList<>();

    public void adicionarPlayListUsuario(Playlist playlist){
        this.lista_playlist.add(playlist);
    }

}
