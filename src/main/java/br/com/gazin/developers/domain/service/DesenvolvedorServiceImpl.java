package br.com.gazin.developers.domain.service;

import br.com.gazin.developers.domain.exception.EntidadeNaoEncontradaException;
import br.com.gazin.developers.domain.model.Desenvolvedor;
import br.com.gazin.developers.domain.repository.DesenvolvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedorServiceImpl implements DesenvolvedorService {

    @Autowired
    DesenvolvedorRepository repository;

    @Override
    public List<Desenvolvedor> getAll() {
        return repository.findAll();
    }

    @Override
    public Desenvolvedor getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("ID não encontrado"));
    }

    @Override
    public Desenvolvedor save(Desenvolvedor desenvolvedor) {
        return repository.save(desenvolvedor);
    }

    @Override
    public Desenvolvedor update(Long id, Desenvolvedor desenvolvedor) {
        if(!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("ID não encontrado");
        }
        desenvolvedor.setId(id);

        return repository.save(desenvolvedor);
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("ID não encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public Page<Desenvolvedor> getPage(Integer page, Integer limit, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, limit, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
}
