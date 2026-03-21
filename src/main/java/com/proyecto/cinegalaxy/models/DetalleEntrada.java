package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_entrada")
public class DetalleEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleEntradaId;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "asiento_id", nullable = false)
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "tipo_entrada_id", nullable = false)
    private TipoEntrada tipoEntrada;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "estado")
    private Integer estado;

    public Long getDetalleEntradaId() { return detalleEntradaId; }
    public void setDetalleEntradaId(Long detalleEntradaId) { this.detalleEntradaId = detalleEntradaId; }

    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }

    public Asiento getAsiento() { return asiento; }
    public void setAsiento(Asiento asiento) { this.asiento = asiento; }

    public TipoEntrada getTipoEntrada() { return tipoEntrada; }
    public void setTipoEntrada(TipoEntrada tipoEntrada) { this.tipoEntrada = tipoEntrada; }

    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }

}
