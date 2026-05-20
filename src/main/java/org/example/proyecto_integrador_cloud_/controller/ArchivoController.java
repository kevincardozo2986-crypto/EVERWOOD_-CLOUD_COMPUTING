package org.example.proyecto_integrador_cloud_.controller;
<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.example.proyecto_integrador_cloud_.model.ArchivoEntity;
import org.example.proyecto_integrador_cloud_.repository.ArchivoRepository;
import org.example.proyecto_integrador_cloud_.services.ArchivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArchivoController {
    private final ArchivoService archivoService;
    private final ArchivoRepository archivoRepository;

    @GetMapping("/")
    public String inicio(Model model) {

        model.addAttribute("archivos", archivoRepository.findAll());
        List<ArchivoEntity> archivos = archivoRepository.findAll();
        long totalArchivos = archivos.size();

        long archivosCargados = archivos.stream()
                .filter(a -> "CARGADO".equals(a.getEstado()))
                .count();

        long archivosError = archivos.stream()
                .filter(a -> "ERROR".equals(a.getEstado()))
                .count();

        long tamanoTotal = archivos.stream()
                .mapToLong(ArchivoEntity::getTamano)
                .sum();

        model.addAttribute("archivos", archivos);

        model.addAttribute("totalArchivos", totalArchivos);

        model.addAttribute("archivosCargados", archivosCargados);

        model.addAttribute("archivosError", archivosError);

        model.addAttribute("tamanoTotal", tamanoTotal / 1024);

        return "index";
    }
    @PostMapping("/eliminar/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminarArchivo(@PathVariable Long id) {
        try {
            ArchivoEntity archivo = archivoRepository.findById(id).orElseThrow();
            archivoService.eliminarArchivo(archivo.getNombreArchivo());
            archivoRepository.deleteById(id);
            return ResponseEntity.ok("Archivo eliminado");
        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body("No se pudo eliminar");
        }
    }

    @PostMapping("/subir")
    @ResponseBody
    public ResponseEntity<?> subirArchivo(
            @RequestParam("archivo") MultipartFile file) {

        try {

            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Debe seleccionar un archivo");
            }

            String nombreArchivo = file.getOriginalFilename();

            if (nombreArchivo == null || nombreArchivo.isBlank()) {
                return ResponseEntity.badRequest()
                        .body("Archivo inválido");
            }

            nombreArchivo = nombreArchivo.toLowerCase();

            List<String> extensionesPermitidas =
                    List.of(".txt", ".csv", ".json");

            boolean valido = extensionesPermitidas
                    .stream()
                    .anyMatch(nombreArchivo::endsWith);

            if (!valido) {

                return ResponseEntity.badRequest()
                        .body("Solo se permiten TXT, CSV y JSON");
            }

            if (file.getSize() > 5000000) {

                return ResponseEntity.badRequest()
                        .body("El archivo supera el tamaño permitido");
            }

            String urlArchivo = archivoService.subirArchivo(file);

            ArchivoEntity archivo = new ArchivoEntity();

            archivo.setNombreArchivo(file.getOriginalFilename());
            archivo.setTipoArchivo(file.getContentType());
            archivo.setTamano(file.getSize());
            archivo.setFechaCarga(LocalDateTime.now());
            archivo.setResponsable("Grupo 1");
            archivo.setEstado("CARGADO");
            archivo.setObservaciones("Archivo subido correctamente");
            archivo.setUrlArchivo(urlArchivo);

            archivoRepository.save(archivo);

            return ResponseEntity.ok("Archivo subido correctamente");

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
=======

public class ArchivoController {
>>>>>>> 0c09dfb5478d00fb63d7e58eaf35816ded759bfb
}
