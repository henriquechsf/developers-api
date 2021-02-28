package br.com.gazin.developers.api.resources;

import br.com.gazin.developers.api.dto.DesenvolvedorDTO;
import br.com.gazin.developers.domain.model.Desenvolvedor;
import br.com.gazin.developers.domain.service.DesenvolvedorService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/developers")
public class DesenvolvedorController {

   private ModelMapper mapper;
   private DesenvolvedorService service;

    public DesenvolvedorController(ModelMapper mapper, DesenvolvedorService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DesenvolvedorDTO>> getAll() {
        List<Desenvolvedor> desenvolvedores = service.getAll();
        List<DesenvolvedorDTO> listDTO = desenvolvedores
                .stream().map(dev -> mapper.map(dev, DesenvolvedorDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DesenvolvedorDTO>> getPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Desenvolvedor> desenvolvedores = service.getPage(page, limit, orderBy, direction);

        Page<DesenvolvedorDTO> pageDTO = desenvolvedores
                .map(dev -> mapper.map(dev, DesenvolvedorDTO.class));

        return ResponseEntity.ok().body(pageDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesenvolvedorDTO> getById(@PathVariable Long id) {
        Desenvolvedor desenvolvedor = service.getById(id);
        DesenvolvedorDTO dto = mapper.map(desenvolvedor, DesenvolvedorDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DesenvolvedorDTO> save(@Valid @RequestBody DesenvolvedorDTO dto) {
        Desenvolvedor desenvolvedor = mapper.map(dto, Desenvolvedor.class);
        Desenvolvedor desenvolvedorSalvo = service.save(desenvolvedor);
        return ResponseEntity.ok().body(mapper.map(desenvolvedorSalvo, DesenvolvedorDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesenvolvedorDTO> update(@PathVariable Long id, @Valid @RequestBody DesenvolvedorDTO dto) {
        Desenvolvedor desenvolvedor = mapper.map(dto, Desenvolvedor.class);
        Desenvolvedor desenvolvedorAtualizado = service.update(id, desenvolvedor);
        return ResponseEntity.ok().body(mapper.map(desenvolvedorAtualizado, DesenvolvedorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
