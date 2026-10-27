A1.1 · Estudio comparativo de tecnologías de desarrollo móvil
1. Introducción

A la hora de desarrollar una aplicación móvil existen diferentes tecnologías y estrategias. La elección de una u otra depende de factores como las plataformas a las que se quiere llegar, el rendimiento necesario, el acceso a las funciones del dispositivo, el presupuesto disponible y el mantenimiento posterior.

En este estudio se comparan tres tecnologías de familias diferentes:

Android nativo con Kotlin
Flutter
Progressive Web App (PWA)

Las tres permiten crear aplicaciones utilizables desde dispositivos móviles, pero tienen filosofías diferentes. Android nativo está especializado en el ecosistema Android, Flutter permite desarrollar aplicaciones multiplataforma con una única base de código y una PWA utiliza tecnologías web para ofrecer una experiencia similar a una aplicación instalada.

| Aspecto            | Android nativo                                                    | Flutter                                                      | PWA                                                              |
| ------------------ | ----------------------------------------------------------------- | ------------------------------------------------------------ | ---------------------------------------------------------------- |
| Familia            | Desarrollo nativo                                                 | Multiplataforma                                              | Tecnologías web                                                  |
| Lenguaje principal | Kotlin                                                            | Dart                                                         | HTML, CSS y JavaScript/TypeScript                                |
| Herramientas       | Android Studio, Android SDK, Gradle, Jetpack                      | Flutter SDK, Dart SDK, Android Studio/VS Code                | Navegador, VS Code/WebStorm, frameworks web opcionales           |
| Plataformas        | Android, Wear OS, Android TV, tablets, etc.                       | Android, iOS, Web, Windows, macOS y Linux                    | Navegadores en Android, iOS, Windows, macOS, Linux, etc.         |
| Rendimiento        | Muy alto                                                          | Alto, cercano al nativo en muchos escenarios                 | Variable; depende del navegador y de la aplicación               |
| Acceso al hardware | Excelente                                                         | Alto mediante plugins y código nativo                        | Limitado respecto a una app nativa                               |
| Código compartido  | Bajo si se quiere también iOS                                     | Muy alto                                                     | Muy alto                                                         |
| Coste inicial      | Medio/alto                                                        | Medio                                                        | Bajo/medio                                                       |
| Mantenimiento      | Mayor si se desarrollan varias plataformas                        | Relativamente reducido                                       | Reducido                                                         |
| Instalación        | Google Play u otros medios                                        | Google Play, App Store, etc.                                 | Desde el navegador, y en algunos casos como aplicación instalada |
| Mejor escenario    | Aplicaciones Android que necesitan máximo control del dispositivo | Aplicaciones para Android + iOS con una única base de código | Servicios que necesitan llegar rápidamente a muchos dispositivos |

3. Tecnología 1: Android nativo con Kotlin
   3.1. Lenguaje y herramientas

El desarrollo nativo para Android se realiza actualmente principalmente con Kotlin. Google recomienda Kotlin para los proyectos nuevos de Android, mientras que Java continúa siendo compatible.

La herramienta principal es Android Studio, el IDE oficial de desarrollo para Android. También se utilizan:

Android SDK.
Gradle para la compilación.
Jetpack y Jetpack Compose para crear interfaces modernas.
Android Emulator para realizar pruebas.
Android Debug Bridge (ADB).
APIs específicas de Android.

Android Studio permite desarrollar y probar aplicaciones destinadas a diferentes dispositivos Android, como teléfonos, tablets, dispositivos plegables, Wear OS y Android TV.

3.2. Plataformas soportadas

Su principal objetivo es el ecosistema Android. Esto incluye:

Smartphones Android.
Tablets Android.
Wear OS.
Android TV.
Dispositivos plegables.
Otros dispositivos basados en Android.

Por tanto, si el objetivo es únicamente Android, no existe la necesidad de utilizar una tecnología multiplataforma.

3.3. Rendimiento y acceso al hardware

Una de las principales ventajas del desarrollo nativo es el alto rendimiento y el acceso directo a las APIs del sistema operativo.

Una aplicación Android nativa puede utilizar directamente funcionalidades como:

Cámara.
GPS.
Bluetooth.
NFC.
Sensores.
Biometría.
Almacenamiento.
Notificaciones.
Servicios en segundo plano.

Por ejemplo, Android proporciona APIs específicas para trabajar con la cámara mediante Camera2 y otras APIs del sistema.

Esto resulta especialmente importante en aplicaciones que realizan operaciones intensivas o necesitan controlar con precisión el hardware.

3.4. Coste de desarrollo y mantenimiento

El principal inconveniente es que el desarrollo nativo puede resultar más caro cuando se necesita crear la misma aplicación para diferentes sistemas operativos.

Como referencia del mercado español, existen empresas de desarrollo que trabajan aproximadamente en rangos de 25-99 $/hora, y aparecen proyectos de aplicaciones desde varios miles hasta decenas de miles de dólares, dependiendo de su complejidad.

Para expresar una estimación sencilla en euros, podríamos considerar aproximadamente:

Aplicación Android de complejidad media: 15.000-30.000 €

Por ejemplo, una aplicación con:

Registro de usuarios.
Inicio de sesión.
Base de datos.
Notificaciones.
Varias pantallas.
Conexión con una API.
Diseño personalizado.

podría situarse aproximadamente en ese rango.

El mantenimiento podría suponer aproximadamente 2.000-6.000 € anuales, dependiendo de la frecuencia de actualizaciones, corrección de errores, nuevas funcionalidades y cambios en Android.

Estos valores son orientativos, no tarifas oficiales. El precio real depende mucho del alcance y del equipo contratado.

3.5. Caso de uso real en el que Android nativo es la mejor opción
Aplicación de control de un dispositivo industrial mediante Bluetooth

Imaginemos una empresa que fabrica una máquina industrial que debe ser controlada desde un teléfono Android.

La aplicación necesita:

Conectarse mediante Bluetooth.
Leer datos de sensores.
Enviar órdenes a la máquina.
Trabajar durante largos periodos en segundo plano.
Recibir notificaciones.
Utilizar la cámara para escanear códigos.
Funcionar de forma estable incluso con poca conexión a Internet.

En este caso, Android nativo es una opción especialmente adecuada porque la aplicación depende mucho de las funciones propias del sistema operativo y del hardware.

Al utilizar directamente las APIs de Android, los desarrolladores tienen un mayor control sobre Bluetooth, sensores, cámara, procesos en segundo plano y otras funciones del dispositivo.

Por tanto, aunque desarrollar una aplicación nativa pueda requerir más trabajo que una solución multiplataforma, el control del hardware y la integración con Android pueden justificar ese coste adicional.

4. Tecnología 2: Flutter
   4.1. Lenguaje y herramientas

Flutter es un framework multiplataforma desarrollado por Google.

Utiliza principalmente el lenguaje de programación Dart. El framework permite desarrollar aplicaciones para diferentes plataformas utilizando una misma base de código.

Las herramientas habituales son:

Flutter SDK.
Dart SDK.
Android Studio o Visual Studio Code.
Flutter DevTools.
Plugins de Flutter.
Emuladores y dispositivos físicos.

Una de sus principales ventajas es el Hot Reload, que permite visualizar rápidamente los cambios realizados durante el desarrollo.

Además, Flutter permite utilizar plugins para acceder a funcionalidades específicas de Android e iOS y, cuando es necesario, también permite escribir código específico de cada plataforma.

4.2. Plataformas soportadas

Una de las características principales de Flutter es su capacidad multiplataforma.

Actualmente permite desarrollar aplicaciones para:

Android.
iOS.
Web.
Windows.
macOS.
Linux.

El objetivo es utilizar una misma base de código para varias plataformas.

Esto puede reducir considerablemente el trabajo cuando una empresa necesita publicar una aplicación tanto en Android como en iOS.

4.3. Rendimiento y acceso al hardware

Flutter ofrece un rendimiento elevado y utiliza compilación a código nativo para las aplicaciones de producción. Dart puede utilizar compilación AOT (Ahead-of-Time) para generar código nativo.

Además, existen numerosos plugins para acceder a funcionalidades del dispositivo.

Por ejemplo, una aplicación Flutter puede utilizar:

Cámara.
GPS.
Bluetooth.
Notificaciones.
Almacenamiento.
Sensores.
Biometría.

Sin embargo, existe una diferencia importante respecto al desarrollo nativo: si una funcionalidad concreta no está disponible mediante un plugin, puede ser necesario escribir código específico para Android o iOS. Flutter contempla precisamente este tipo de integración con código de cada plataforma.

4.4. Coste de desarrollo y mantenimiento

La principal ventaja económica de Flutter aparece cuando queremos desarrollar para Android e iOS simultáneamente.

En lugar de mantener dos proyectos independientes, se puede compartir gran parte del código.

Como referencia, empresas que ofrecen desarrollo Flutter en España aparecen actualmente con tarifas aproximadas de 25-99 $/hora, dependiendo de la empresa y del nivel de especialización.

En euros, para una aplicación de complejidad media destinada a Android e iOS, una estimación razonable podría ser:

Aplicación Flutter de complejidad media: 18.000-35.000 €

Por ejemplo, podría incluir:

Registro y autenticación.
Perfiles de usuario.
Base de datos.
Consumo de una API.
Notificaciones.
Varias pantallas.
Diseño personalizado.
Publicación en Android e iOS.

El mantenimiento podría situarse aproximadamente en 3.000-7.000 € al año, dependiendo de la aplicación.

Aunque el desarrollo inicial pueda tener un precio similar al nativo, el ahorro puede aparecer posteriormente al mantener una base de código compartida para varias plataformas.

4.5. Caso de uso real en el que Flutter es la mejor opción
Aplicación de reservas para un gimnasio

Imaginemos una cadena de gimnasios que quiere crear una aplicación para sus clientes.

La aplicación permite:

Registrarse e iniciar sesión.
Consultar las clases disponibles.
Reservar clases.
Cancelar reservas.
Recibir notificaciones.
Consultar el perfil.
Realizar pagos.
Consultar el calendario.

La empresa quiere que la aplicación esté disponible tanto para Android como para iPhone.

En este caso, Flutter resulta especialmente interesante porque gran parte de la aplicación puede desarrollarse utilizando una única base de código.

Si se hiciera de forma completamente nativa, sería necesario mantener una aplicación Android y otra iOS, con sus correspondientes proyectos, pruebas y mantenimiento.

Con Flutter, la empresa puede compartir una gran parte de la lógica y de la interfaz entre ambas plataformas. Esto reduce la duplicación de trabajo y facilita que las dos versiones evolucionen de forma coordinada.

Por tanto, para una aplicación empresarial convencional que necesita estar disponible en Android e iOS pero que no depende de un uso extremadamente específico del hardware, Flutter es una alternativa muy adecuada.

5. Tecnología 3: Progressive Web App (PWA)
   5.1. Lenguaje y herramientas

Una PWA (Progressive Web App) es una aplicación construida utilizando tecnologías web, principalmente:

HTML.
CSS.
JavaScript o TypeScript.

También puede utilizar frameworks como:

React.
Angular.
Vue.
Svelte.

Las herramientas necesarias son relativamente sencillas:

Visual Studio Code u otro editor.
Navegador web.
Node.js y npm, si se utiliza un framework.
DevTools del navegador.
Web App Manifest.
Service Worker.

El manifest permite definir aspectos de instalación y comportamiento de la aplicación. Los service workers pueden utilizarse para proporcionar funcionamiento offline y determinadas operaciones en segundo plano.

5.2. Plataformas soportadas

Una PWA tiene una gran ventaja: no está ligada a un sistema operativo concreto.

Puede funcionar en navegadores de:

Android.
iOS/iPadOS.
Windows.
macOS.
Linux.
ChromeOS.

Además, en los sistemas y navegadores compatibles, puede instalarse y aparecer como una aplicación independiente en el dispositivo.

Sin embargo, hay diferencias entre navegadores y sistemas operativos. Por ejemplo, las capacidades de instalación y determinadas APIs no son exactamente iguales en Android, iOS y escritorio.

5.3. Rendimiento y acceso al hardware

El rendimiento de una PWA puede ser bueno para aplicaciones web convencionales, pero normalmente tiene más limitaciones que una aplicación nativa cuando se necesitan funcionalidades específicas del dispositivo.

Una PWA puede acceder a determinadas funciones del dispositivo mediante APIs web, siempre que el navegador y el sistema operativo las soporten.

Por ejemplo:

Geolocalización.
Cámara en determinados escenarios.
Notificaciones.
Almacenamiento local.
Funcionalidad offline.
Algunas funciones de archivos y hardware.

Pero el acceso no es tan completo ni uniforme como en una aplicación nativa.

Por este motivo, una PWA no sería la opción más apropiada para una aplicación que necesite un control muy avanzado de Bluetooth, sensores, procesamiento en segundo plano o hardware específico.

5.4. Coste de desarrollo y mantenimiento

Las PWA pueden resultar más económicas cuando la aplicación consiste principalmente en interfaces, formularios, consultas de datos y servicios online.

Además, una misma aplicación puede utilizarse desde diferentes dispositivos sin desarrollar una aplicación independiente para Android y otra para iOS.

Para una PWA de complejidad media, podemos estimar aproximadamente:

Coste de desarrollo: 8.000-20.000 €

El mantenimiento podría situarse aproximadamente en:

1.500-4.000 € al año

La cifra dependerá de si existe backend, sistema de usuarios, pagos, panel de administración, notificaciones, etc.

El mercado español de desarrollo de software muestra que las tarifas de empresas especializadas pueden variar bastante; por ejemplo, en directorios actuales aparecen proveedores que trabajan aproximadamente desde 25-49 €/h hasta 50-99 €/h o más, por lo que estas cifras deben entenderse como estimaciones de un proyecto de tamaño medio y no como precios fijos.

5.5. Caso de uso real en el que una PWA es la mejor opción
Sistema de consulta y reserva de citas para un centro deportivo

Imaginemos un centro deportivo que quiere ofrecer a sus clientes un sistema para:

Consultar horarios.
Reservar actividades.
Consultar sus reservas.
Cancelar una reserva.
Consultar información del centro.
Recibir determinadas notificaciones.
Consultar el servicio desde el móvil y desde un ordenador.

En este caso, una PWA puede ser una opción especialmente apropiada porque no es imprescindible acceder a funciones avanzadas del hardware del teléfono.

El cliente podría simplemente entrar en una dirección web, iniciar sesión y utilizar el servicio. Si su navegador lo permite, además puede instalar la PWA en la pantalla de inicio y utilizarla con una apariencia similar a una aplicación.

Esto también facilita que un usuario pueda utilizar el mismo servicio desde:

Su móvil Android.
Su iPhone.
Un ordenador Windows.
Un Mac.

Por ejemplo, un cliente podría consultar las clases desde su ordenador y posteriormente utilizar el mismo sistema desde su móvil sin tener que instalar una aplicación específica desde Google Play o App Store.

Por tanto, para servicios de información, reservas, comercio electrónico, gestión de clientes o aplicaciones empresariales que no necesitan un acceso intensivo al hardware, una PWA puede reducir los costes de desarrollo y distribución manteniendo una buena experiencia de usuario.

6. Comparación de costes

Para comparar las tres tecnologías, podemos plantear una aplicación de complejidad media, con usuario, login, base de datos, conexión con una API, varias pantallas, diseño personalizado y notificaciones.

| Tecnología     | Plataformas                        | Coste aproximado de desarrollo | Mantenimiento anual aproximado |
| -------------- | ---------------------------------- | -----------------------------: | -----------------------------: |
| Android nativo | Android                            |            **15.000-30.000 €** |              **2.000-6.000 €** |
| Flutter        | Android + iOS                      |            **18.000-35.000 €** |              **3.000-7.000 €** |
| PWA            | Multiplataforma mediante navegador |             **8.000-20.000 €** |              **1.500-4.000 €** |


Estas cantidades son estimaciones orientativas para España, no presupuestos cerrados. El coste puede aumentar bastante si se añaden funcionalidades como pagos, geolocalización avanzada, inteligencia artificial, sistemas de administración, integración con otros servicios, diseño UX/UI complejo o requisitos de seguridad.

Como referencia externa, directorios de empresas de desarrollo que operan en España muestran actualmente tarifas de aproximadamente 25-99 $/hora en numerosos proveedores y proyectos que pueden partir de varios miles de euros/dólares y alcanzar decenas de miles dependiendo del alcance.


