package cl.duoc.pedidos360.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    // Este endpoint lo puede ver cualquier usuario que haya iniciado sesión (Cualquier token válido)
    @GetMapping
    public String listarPedidos() {
        return "Lista de pedidos 360 (Acceso concedido a usuario autenticado)";
    }

    // Este endpoint SOLO lo puede ver un usuario que tenga el rol "ADMIN" en Cognito
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String panelAdmin() {
        return "Panel de Administración (Acceso concedido solo a rol ADMIN)";
    }
}