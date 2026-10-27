## A1.2.1 · Puesta en marcha del entorno

Para realizar esta tarea partiremos de capturas en las que mostraremos que nuestro entorno está operativo.

> No realizaremos el proceso de instalación paso a paso, ya que todo este proceso se realizó con mucha anterioridad.

### Explicación de las capturas de SDK Manager

- Captura [0102_sdk_platforms.png](res/0102_sdk_platforms.png): se puede comprobar que tenemos instalado el SDK.
- Captura [0102_sdk_tools.png](res/0102_sdk_tools.png): se puede comprobar que tenemos instalados el emulador y las herramientas de compilación.
- Captura [0102_licencias_aceptadas.png](res/0102_licencias_aceptadas.png): al ejecutar `sdkmanager --licenses`, el sistema devuelve el mensaje `Warning: The --licenses option is no longer needed`. Esto indica que el sistema de licencias del SDK se gestiona automáticamente en las versiones modernas de Android Studio, por lo que no es necesaria ninguna acción adicional por mi parte.

## A1.2.2 · Crea un proyecto nuevo vacío y ejecútalo

- Captura [0102_ejecucion.png](res/0102_ejecucion.png): se muestra la ejecución de nuestro proyecto.

## A1.2.3 · Crea al menos tres AVD con perfiles claramente distintos entre sí: por ejemplo, un teléfono actual, un teléfono pequeño y antiguo, y una tablet

- Para crear los 3 AVD, nos dirigimos a **Tools > Device Manager** y, haciendo clic en el símbolo **+**, seleccionamos **Create Virtual Device**.
    - Para el primer dispositivo escogemos **Pixel 8**: [0102_seleccion_pixel8.png](res/0102_seleccion_pixel8.png).
    - Instalación del Pixel 8: [0102_instalacion_finalizada_pixel8.png](res/0102_instalacion_finalizada_pixel8.png).
    - Device Manager del Pixel 8: [0102_device_manager_pantalla_pixel8.png](res/0102_device_manager_pantalla_pixel8.png).
    - Datos de configuración: API 34+, resolución 2400, 420 dpi.
    - Ejecución del Pixel 8: [0102_ejecucion_pixel8.png](res/0102_ejecucion_pixel8.png).

- Para el segundo AVD, creamos un nuevo perfil de hardware, ya que no tenemos el **Nexus 5** (un dispositivo antiguo): [0102_creado_nexus5.png](res/0102_creado_nexus5.png).
    - Realizamos el proceso de configuración con API 28, 1920x1080 y 480 dpi.
    - Creación del perfil de hardware Nexus 5: [0102_configuracion_nexus5.png](res/0102_configuracion_nexus5.png).
    - Configuración del Nexus 5: [0102_configuracion_nexus5.png](res/0102_configuracion_nexus5.png).
    - Vista del dispositivo creado en Device Manager: [0102_creado_nexus5.png](res/0102_creado_nexus5.png).
    - Selección del Nexus 5: [0102_seleccion_nexus5.png](res/0102_seleccion_nexus5.png).
    - Ejecución del Nexus 5: [0102_ejecucion_nexus5.png](res/0102_ejecucion_nexus5.png).

- Para el tercer AVD, escogemos crear un **Pixel Tablet** con API 33+, resolución 2560 y 320 dpi.
    - Configuración del Pixel Tablet: [0102_configuracion_pixel_tablet.png](res/0102_configuracion_pixel_tablet.png).
    - Vista del dispositivo creado en Device Manager: [0102_creacion_pixel_tablet.png](res/0102_creacion_pixel_tablet.png).
    - Selección del Pixel Tablet: [0102_seleccion_pixel_tablet.png](res/0102_seleccion_pixel_tablet.png).
    - Ejecución del Pixel Tablet: [0102_ejecucion_pixel_tablet.png](res/0102_ejecucion_pixel_tablet.png).

- **Diferencias:** hemos podido comprobar que, al ejecutar cada dispositivo, el Pixel Tablet resultó más adaptativo, especialmente al girarlo. También comprobamos que el tamaño de pantalla de cada dispositivo es distinto. En el Nexus 5, al ser una versión más antigua, pudimos comprobar que la pantalla es más cuadrada y no tan rectangular como la de los smartphones actuales.




