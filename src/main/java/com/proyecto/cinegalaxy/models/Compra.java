package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compraId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "funcion_id", nullable = true)
    private Funcion funcion;

    @Column(name = "invitado_nombre")
    private String invitadoNombre;

    @Column(name = "invitado_email")
    private String invitadoEmail;

    @Column(name = "invitado_tel")
    private String invitadoTel;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo_qr")
    private String codigoQr;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalleEntrada> detalleEntradas;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalleProducto> detalleProductos;

    public Long getCompraId() { return compraId; }
    public void setCompraId(Long compraId) { this.compraId = compraId; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Funcion getFuncion() { return funcion; }
    public void setFuncion(Funcion funcion) { this.funcion = funcion; }

    public String getInvitadoNombre() { return invitadoNombre; }
    public void setInvitadoNombre(String invitadoNombre) { this.invitadoNombre = invitadoNombre; }

    public String getInvitadoEmail() { return invitadoEmail; }
    public void setInvitadoEmail(String invitadoEmail) { this.invitadoEmail = invitadoEmail; }

    public String getInvitadoTel() { return invitadoTel; }
    public void setInvitadoTel(String invitadoTel) { this.invitadoTel = invitadoTel; }

    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }

    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCodigoQr() { return codigoQr; }
    public void setCodigoQr(String codigoQr) { this.codigoQr = codigoQr; }

    public List<DetalleEntrada> getDetalleEntradas() { return detalleEntradas; }
    public void setDetalleEntradas(List<DetalleEntrada> detalleEntradas) { this.detalleEntradas = detalleEntradas; }

    public List<DetalleProducto> getDetalleProductos() { return detalleProductos; }
    public void setDetalleProductos(List<DetalleProducto> detalleProductos) { this.detalleProductos = detalleProductos; }

}
