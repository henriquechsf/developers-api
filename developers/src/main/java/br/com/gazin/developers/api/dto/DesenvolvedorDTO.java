package br.com.gazin.developers.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DesenvolvedorDTO {
    private Long id;
    @NotNull(message = "Nome é um campo obrigatório")
    @Length(min = 4, max = 50)
    private String nome;

    @NotNull(message = "Sexo é um campo obrigatório")
    private Character sexo;

    @NotNull(message = "Idade é um campo obrigatório")
    private Integer idade;

    @NotNull(message = "Hobby é um campo obrigatório")
    private String hobby;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate nascimento;
}
