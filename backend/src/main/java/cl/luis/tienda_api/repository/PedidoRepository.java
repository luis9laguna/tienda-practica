package cl.luis.tienda_api.repository;

import cl.luis.tienda_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}