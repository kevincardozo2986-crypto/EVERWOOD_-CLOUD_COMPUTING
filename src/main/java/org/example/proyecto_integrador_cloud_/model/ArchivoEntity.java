package org.example.proyecto_integrador_cloud_.model;
<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchivoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombreArchivo;

        private String tipoArchivo;

        private Long tamano;

        private LocalDateTime fechaCarga;

        private String responsable;

        private String estado;

        private String observaciones;

        private String urlArchivo;

=======

public class ArchivoEntity {
>>>>>>> 0c09dfb5478d00fb63d7e58eaf35816ded759bfb
}
