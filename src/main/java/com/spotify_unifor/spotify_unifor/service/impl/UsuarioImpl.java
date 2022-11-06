package com.spotify_unifor.spotify_unifor.service.impl;

import com.spotify_unifor.spotify_unifor.model.Playlist;
import com.spotify_unifor.spotify_unifor.model.Usuario;
import com.spotify_unifor.spotify_unifor.repository.UsuarioRepository;
import com.spotify_unifor.spotify_unifor.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    private PlaylistImpl impl;

    @Autowired
    private UsuarioRepository usr_repository;

    @Override
    public List<Usuario> getAllUsers() {
        return this.usr_repository.findAll();
    }

    @Override
    public Usuario getSpecifyUser(Integer id) {
        return this.usr_repository.findById(id).orElseThrow(() -> new RuntimeException("erro"));
    }

    @Override
    public Usuario saveUser(Usuario usuario) {
        return this.usr_repository.save(usuario);
    }

    @Override
    public Usuario updateUser(Integer id, Usuario usuario) {
        Optional<Usuario> byId = this.usr_repository.findById(id);
        if(byId.isPresent()){
            //TODO REFATORAR ISSO AQUI
            byId.get().setNome(usuario.getNome());
            byId.get().setSenha(usuario.getSenha());
            byId.get().setGenero(usuario.getGenero());
            byId.get().setEmail(usuario.getEmail());
            byId.get().setGenero(usuario.getGenero());
            return this.usr_repository.save(byId.get());
        }
        throw new RuntimeException("ops...");
    }

    @Override
    public void deleteUser(Integer id) {
        Usuario specifyUser = this.getSpecifyUser(id);
        this.usr_repository.delete(specifyUser);
    }

    @Override
    @Transactional
    public Usuario addPlaylist(Integer idPlaylist, Integer idUsuario) {
        Playlist specifyPlaylist = this.impl.getSpecifyPlaylist(idPlaylist);
        Optional<Usuario> byId = this.usr_repository.findById(idUsuario);

        specifyPlaylist.setUsuario(byId.get());
        byId.get().adicionarPlayListUsuario(specifyPlaylist);

        return byId.get();
    }
}
