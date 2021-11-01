package br.com.springboot.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class Usuario {
    @NotNull
    private Integer id;

    @Size(max=100)
    @NotNull
    private String nome;

    private String sobrenome;

    @Size(max=10)
    @NotNull
    private String senha;

    @Email
    @NotNull
    private String email;

    private LocalDate dataCriacao;
}
