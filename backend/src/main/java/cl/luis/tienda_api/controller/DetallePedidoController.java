package cl.luis.tienda_api.controller;

import cl.luis.tienda_api.model.DetallePedido;
import cl.luis.tienda_api.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @GetMapping
    public List<DetallePedido> listarTodo() {
        return detallePedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> buscarPorId(@PathVariable Long id) {
        return detallePedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetallePedido crear(@RequestBody DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> actualizar(@PathVariable Long id, @RequestBody DetallePedido detalleDetalles) {
        return detallePedidoRepository.findById(id)
                .map(detalle -> {
                    detalle.setPedido(detalleDetalles.getPedido());
                    detalle.setProducto(detalleDetalles.getProducto());
                    detalle.setCantidad(detalleDetalles.getCantidad());
                    detalle.setPrecioUnitario(detalleDetalles.getPrecioUnitario());
                    return ResponseEntity.ok(detallePedidoRepository.save(detalle));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!detallePedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        detallePedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}