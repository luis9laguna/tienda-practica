package cl.luis.tienda_api.repository;

import cl.luis.tienda_api.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}