package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.*;
import com.proyecto.cinegalaxy.repositories.*;
import com.proyecto.cinegalaxy.request.CompraRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FuncionRepository funcionRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private TipoEntradaRepository tipoEntradaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Compra> getCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compra> getCompraById(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    @Transactional
    public Compra crearCompra(CompraRequest request) {

        // 1. Crear compra
        Compra compra = new Compra();
        compra.setFechaCompra(LocalDateTime.now());
        compra.setSubtotal(request.getTotalEntradas());
        compra.setTotal(request.getTotal());
        compra.setEstado("CONFIRMADA");
        compra.setCodigoQr("CG-" + System.currentTimeMillis());

        // 2. Usuario o invitado
        if (request.getUsuarioId() != null) {
            usuarioRepository.findById(request.getUsuarioId())
                    .ifPresent(compra::setUsuario);
        } else if (request.getInvitado() != null) {
            compra.setInvitadoNombre(request.getInvitado().get("nombre"));
            compra.setInvitadoEmail(request.getInvitado().get("email"));
            compra.setInvitadoTel(request.getInvitado().get("telefono"));
        }

        // 3. Función
        if (request.getFuncionId() != null) {
            funcionRepository.findById(request.getFuncionId())
                    .ifPresent(compra::setFuncion);
        }

        compraRepository.save(compra);

        // 4. Detalle entradas
        if (request.getTiposConCantidad() != null) {
            for (Map<String, Object> item : request.getTiposConCantidad()) {
                Long tipoEntradaId = Long.valueOf(item.get("tipoEntradaId").toString());
                List<?> asientosIds = (List<?>) item.get("asientosIds");
                Double precioUnitario = Double.valueOf(item.get("precioUnitario").toString());

                TipoEntrada tipoEntrada = tipoEntradaRepository.findById(tipoEntradaId).orElse(null);
                if (tipoEntrada == null || asientosIds == null) continue;

                for (Object asientoIdObj : asientosIds) {
                    Long asientoId = Long.valueOf(asientoIdObj.toString());
                    Asiento asiento = asientoRepository.findById(asientoId).orElse(null);
                    if (asiento == null) continue;

                    DetalleEntrada detalle = new DetalleEntrada();
                    detalle.setCompra(compra);
                    detalle.setAsiento(asiento);
                    detalle.setTipoEntrada(tipoEntrada);
                    detalle.setPrecioUnitario(precioUnitario);
                    detalle.setEstado(1);
                    detalleEntradaRepository.save(detalle);
                }
            }
        }

        // 5. Detalle productos
        if (request.getCarrito() != null) {
            for (Map<String, Object> item : request.getCarrito()) {
                Long productoId = Long.valueOf(item.get("productoId").toString());
                Integer cantidad = Integer.valueOf(item.get("cantidad").toString());
                Double precioUnitario = Double.valueOf(item.get("precioUnitario").toString());

                Producto producto = productoRepository.findById(productoId).orElse(null);
                if (producto == null) continue;

                DetalleProducto detalle = new DetalleProducto();
                detalle.setCompra(compra);
                detalle.setProducto(producto);
                detalle.setCantidad(cantidad);
                detalle.setPrecioUnitario(precioUnitario);
                detalle.setSubtotal(precioUnitario * cantidad);
                detalleProductoRepository.save(detalle);
            }
        }

        return compra;
    }


}
