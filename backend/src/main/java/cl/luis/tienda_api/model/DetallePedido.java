package cl.luis.tienda_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DETALLE_PEDIDO")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "PRODUCTO_ID")
    private Producto producto;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO")
    private Double precioUnitario;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
}