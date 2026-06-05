package cl.luis.tienda_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PRECIO")
    private Double precio;

    @Column(name = "STOCK")
    private Integer stock = 0;

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}