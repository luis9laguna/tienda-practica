package cl.luis.tienda_api.controller;

import cl.luis.tienda_api.model.Categoria;
import cl.luis.tienda_api.repository.CategoriaRepository;
import cl.luis.tienda_api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Categoria> listarTodo() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return categoriaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria categoriaDetalles) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setNombre(categoriaDetalles.getNombre());
                    return ResponseEntity.ok(categoriaRepository.save(categoria));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (productoRepository.existsByCategoriaId(id)) {
            return ResponseEntity.status(409).body("No puedes borrar esta categoría porque tiene productos asignados.");
        }

        if (!categoriaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}