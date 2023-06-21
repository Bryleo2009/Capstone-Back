package com.ofsystem;

import com.ofsystem.Capstone.Model.Producto.Producto;
import com.ofsystem.Capstone.Service.Imple.Producto.ProductoServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Prueba {
    @Autowired
    private ProductoServiceImpl productoService;

    @Test
    public void testRegistroMasivo() {
        // Obtener el producto por ID
        Producto producto = productoService.listarxID(1);

        // Verificar si el producto existe
        if (producto != null) {
            // El producto existe
            System.out.println("El producto existe");
        } else {
            // El producto no existe
            System.out.println("El producto no existe");
        }

        // Verificar que el producto no sea nulo
        Assert.assertNotNull(producto);

    }
}
