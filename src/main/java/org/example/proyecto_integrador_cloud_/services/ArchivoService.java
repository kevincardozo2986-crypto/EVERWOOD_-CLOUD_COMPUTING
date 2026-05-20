package org.example.proyecto_integrador_cloud_.services;

<<<<<<< HEAD
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArchivoService {

    // Supabase integration is disabled for local development.
    // The local run uses only the database and does not upload files to remote storage.

    public void eliminarArchivo(String fileName) {
        // No remote deletion while Supabase is disabled.
    }

    public String subirArchivo(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isBlank()) {
            fileName = "archivo";
        }
        return "/uploads/" + fileName;
    }
}
=======
public class ArchivoServie {
}
>>>>>>> 0c09dfb5478d00fb63d7e58eaf35816ded759bfb
