package br.com.springboot.controllers;

import br.com.springboot.model.Usuario;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/{id}")
    public Usuario userID(@PathVariable("id") Integer id) {

       Optional<Usuario> userFind = usuarios.stream().filter(usuario -> usuario.getId() == id).findFirst();

       if (userFind.isPresent()){
           return userFind.get();
       }else   {
           return null;
       }

    }
    @GetMapping("/name/{nome}")
    public Usuario userName(@PathVariable("nome") String nome) {

        Optional<Usuario> userFindNome = usuarios.stream().filter(usuario -> usuario.getNome().equals(nome)).findFirst();

        if (userFindNome.isPresent()){
            return userFindNome.get();
        }else   {
            return null;
        }
    }

    @PostMapping("/")
    public Usuario user(@RequestBody Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }

    @GetMapping("/list")
    public List<Usuario> list(){
        return usuarios;
    }

    @PutMapping("/{id}")
    public String userPut(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {

        Usuario usuarioPut = userID(id);

        if (usuarioPut != null){

            usuarioPut.setId(id);
            usuarioPut.setNome(usuario.getNome());
            usuarioPut.setSobrenome(usuario.getSobrenome());
            usuarioPut.setSenha(usuario.getSenha());
            usuarioPut.setDataCriacao(usuario.getDataCriacao());
            usuarioPut.setEmail(usuario.getEmail());

            usuarios.set(id-1, usuarioPut);

            return "Usuario alterado com sucesso";
        }else   {
            return "Falha ao Alterar Usuário";
        }
    }

    @DeleteMapping("/{id}")
    public String userDelete(@PathVariable("id") Integer id) {

        Usuario usuarioDelete = userID(id);

        if (usuarioDelete != null){
            usuarios.remove(id - 1);

            return "Usuario Deletado com sucesso";
        }else   {
            return "Falha ao Deletar Usuário";
        }
    }
}
