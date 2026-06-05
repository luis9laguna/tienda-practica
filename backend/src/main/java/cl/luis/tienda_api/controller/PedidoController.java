package cl.luis.tienda_api.controller;

import cl.luis.tienda_api.model.Pedido;
import cl.luis.tienda_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listarTodo() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Long id, @RequestBody Pedido pedidoDetalles) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setFecha(pedidoDetalles.getFecha());
                    pedido.setUsuario(pedidoDetalles.getUsuario());
                    pedido.setStatus(pedidoDetalles.getStatus());
                    return ResponseEntity.ok(pedidoRepository.save(pedido));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}