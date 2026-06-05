package cl.luis.tienda_api.repository;

import cl.luis.tienda_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}