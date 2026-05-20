#  Everwood Cloud

Plataforma web para la gestión de conversaciones históricas y generación de FAQs, desarrollada como Proyecto Integrador.

---

##  Descripción

Everwood Cloud permite cargar, almacenar y consultar archivos de conversaciones históricas (CSV, JSON, TXT) provenientes de canales como WhatsApp. El sistema registra metadatos de cada carga, controla el estado de los archivos y mantiene trazabilidad completa del proceso.

---

##  Funcionalidades

- ✅ Carga de archivos CSV, JSON y TXT con validación de formato y tamaño
- ✅ Almacenamiento en la nube mediante Supabase Storage
- ✅ Registro de metadatos: nombre, tipo, tamaño, fecha, responsable y estado
- ✅ Historial de archivos con estados: `CARGADO`, `PENDIENTE`, `ERROR`
- ✅ Mensajes de confirmación y error en tiempo real
- ✅ Eliminación de archivos desde la interfaz
- ✅ Dashboard con métricas: total de archivos, cargados, errores y almacenamiento

---

##  Tecnologías

| Capa | Tecnología |
|------|-----------|
| Backend | Java 17 + Spring Boot |
| Frontend | Thymeleaf + CSS personalizado |
| Base de datos | PostgreSQL (Supabase) |
| Almacenamiento | Supabase Storage |
| Build | Maven |

---

##  Estructura del proyecto

```
src/
└── main/
    ├── java/org/example/proyecto_integrador_cloud_/
    │   ├── controller/
    │   │   └── ArchivoController.java
    │   ├── model/
    │   │   └── ArchivoEntity.java
    │   ├── repository/
    │   │   └── ArchivoRepository.java
    │   └── services/
    │       ├── ArchivoService.java
    │       └── SupabaseService.java
    └── resources/
        ├── static/css/
        │   └── style.css
        ├── templates/
        │   └── index.html
        └── application.properties
```

---

##  Configuración

Crea o edita el archivo `src/main/resources/application.properties` con tus credenciales:

```properties
# Base de datos
spring.datasource.url=jdbc:postgresql://<HOST>:<PORT>/<DB>
spring.datasource.username=<USUARIO>
spring.datasource.password=<CONTRASEÑA>
spring.jpa.hibernate.ddl-auto=update

# Supabase
supabase.url=https://<TU_PROYECTO>.supabase.co
supabase.key=<TU_API_KEY>
supabase.bucket=<NOMBRE_DEL_BUCKET>

# Tamaño máximo de archivo
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
```

>  No subas el `application.properties` con credenciales reales al repositorio. Agrégalo al `.gitignore`.

---

##  Cómo ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/everwood-cloud.git
cd everwood-cloud

# Ejecutar con Maven
./mvnw spring-boot:run
```

Luego abre el navegador en: [http://localhost:8080](http://localhost:8080)


---

##  Autor

**Kevin Cardozo**  
Proyecto Integrador — 2026
