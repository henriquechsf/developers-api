package br.com.gazin.developers.domain.service;

import br.com.gazin.developers.domain.model.Desenvolvedor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DesenvolvedorService {
    List<Desenvolvedor> getAll();

    Desenvolvedor getById(Long id);

    Page<Desenvolvedor> getPage(Integer page, Integer limit, String orderBy, String direction);

    Desenvolvedor save(Desenvolvedor desenvolvedor);

    Desenvolvedor update(Long id, Desenvolvedor desenvolvedor);

    void delete(Long id);

}
