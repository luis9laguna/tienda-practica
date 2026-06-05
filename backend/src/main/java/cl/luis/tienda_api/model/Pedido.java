package cl.luis.tienda_api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    private Date fecha = new Date();

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @Column(name = "STATUS")
    private String status = "PENDIENTE";

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}