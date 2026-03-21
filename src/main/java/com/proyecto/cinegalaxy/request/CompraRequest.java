package com.proyecto.cinegalaxy.request;

import java.util.List;
import java.util.Map;

public class CompraRequest {

    private Long usuarioId;
    private Long funcionId;
    private Map<String, String> invitado;
    private List<Map<String, Object>> tiposConCantidad;
    private List<Map<String, Object>> carrito;
    private Double totalEntradas;
    private Double totalDulceria;
    private Double total;
    private String metodoPago;

    public CompraRequest() {}

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getFuncionId() { return funcionId; }
    public void setFuncionId(Long funcionId) { this.funcionId = funcionId; }

    public Map<String, String> getInvitado() { return invitado; }
    public void setInvitado(Map<String, String> invitado) { this.invitado = invitado; }

    public List<Map<String, Object>> getTiposConCantidad() { return tiposConCantidad; }
    public void setTiposConCantidad(List<Map<String, Object>> tiposConCantidad) { this.tiposConCantidad = tiposConCantidad; }

    public List<Map<String, Object>> getCarrito() { return carrito; }
    public void setCarrito(List<Map<String, Object>> carrito) { this.carrito = carrito; }

    public Double getTotalEntradas() { return totalEntradas; }
    public void setTotalEntradas(Double totalEntradas) { this.totalEntradas = totalEntradas; }

    public Double getTotalDulceria() { return totalDulceria; }
    public void setTotalDulceria(Double totalDulceria) { this.totalDulceria = totalDulceria; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}
