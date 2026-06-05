package cl.luis.tienda_api.repository;

import cl.luis.tienda_api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}