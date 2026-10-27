A1.3 · Análisis de limitaciones de un dispositivo

Dispositivo analizado (propio): Motorola Moto G84 5G (8 GB RAM / 256 GB) 

1. Especificaciones técnicas

He recopilado los datos de mi dispositivo, el Motorola Moto G84 5G. Las especificaciones clave son las siguientes:

    Procesador: Qualcomm Snapdragon 695 5G, un chip de ocho núcleos (OctaCore) a 2.2 GHz.

    Memoria RAM: 8 GB (con posibilidad de expandir hasta 2 GB adicionales mediante RAM Boost).

    Almacenamiento: 256 GB internos. Según la ficha oficial, el sistema ocupa una parte, dejando unos 240 GB disponibles para el usuario.

    Pantalla: 6.55 pulgadas, tipo pOLED, con resolución Full HD+ (2400 x 1080 píxeles), una densidad de 402 ppp y una frecuencia de refresco de 120 Hz.

    Versión de Android: Android 13 (T).

    Nivel de API: Correspondiente a Android 13, que es el API 33.

2. Sensores disponibles

Para listar los sensores, lo más sencillo es instalar una aplicación de diagnóstico. Yo he usado Device Info, pero cualquiera similar sirve. Los sensores que reporta el sistema para este modelo son:

    Acelerómetro

    Giroscopio

    Sensor de proximidad

    Sensor de luz ambiental

    Brújula (magnetómetro)

    Lector de huellas dactilares (integrado en la pantalla)

    Desbloqueo facial

Además, la documentación técnica menciona un Sensor de SAR (para regular la potencia de radiofrecuencia) y un Concentrador de sensores (Sensor Hub).

3. Estado de la batería y consumo

La batería de este Moto G84 tiene una capacidad de 5000 mAh y soporta carga rápida de 33W.

Para ver el estado y el consumo, podemos ir a Ajustes → Batería. Ahí el sistema muestra un gráfico de las últimas 24 horas y una lista de las aplicaciones que más energía han consumido. En mi caso, para un uso normal (redes sociales, navegación, algo de vídeo y mensajería), la batería llega al final del día sin problemas. Las aplicaciones que más consumen suelen ser las que hacen un uso intensivo de la pantalla (que es de 120 Hz) y de la red (vídeo en streaming, navegación con muchas pestañas).

4. Conclusiones de diseño para mi aplicación

A partir de los datos recogidos, estas son tres decisiones de diseño que tomaría para mi futura aplicación. Cada una está apoyada en un dato concreto de mi dispositivo.

- Cuidado con el uso de memoria en segundo plano.
   Mi móvil tiene 8 GB de RAM, pero una parte importante se la come el sistema operativo y los servicios de Motorola. Cuando empiece a programar, tengo que ser consciente de que Android cierra procesos en segundo plano cuando la memoria empieza a escasear. Si mi app necesita hacer algo mientras no está abierta (por ejemplo, comprobar si hay mensajes nuevos), no puedo dejar un hilo abierto consumiendo RAM sin control. Decisión: diseñaré la app para que, cuando pase a segundo plano, libere todo lo que pueda y no mantenga procesos pesados. Si necesito hacer tareas periódicas, investigaré cuál es la forma correcta de hacerlo en Android (el curso ya nos irá enseñando las herramientas adecuadas), pero mi punto de partida será siempre "no consumir más de lo necesario".
- Adaptar los recursos gráficos a la pantalla.
   La pantalla de mi Moto G84 es de 6.55 pulgadas con resolución 2400 x 1080 y una densidad de 402 ppp. Eso significa que los píxeles son muy pequeños y que una imagen de baja resolución se vería borrosa. Pero también significa que si pongo una imagen enorme sin comprimir, va a ocupar mucho espacio y a consumir más memoria al mostrarla. Decisión: usaré imágenes vectoriales (como los archivos SVG o los VectorDrawable de Android) para iconos y elementos simples, porque se adaptan a cualquier densidad sin perder calidad y ocupan muy poco. Para fotos o imágenes complejas, prepararé varias versiones en distintas resoluciones y las colocaré en las carpetas drawable-xxhdpi, drawable-xhdpi, etc., para que Android elija la más adecuada. Esto es algo que ya hacíamos en desarrollo web con las imágenes responsive, así que me resulta familiar.
- Reducir el consumo de batería evitando el GPS constante.
   La batería es de 5000 mAh, que está muy bien, pero el GPS es uno de los mayores consumidores de energía en cualquier móvil. Si mi app va a usar la ubicación, no puedo permitirme el lujo de tener el GPS encendido todo el tiempo en alta precisión. Decisión: siempre que sea posible, usaré la ubicación aproximada (basada en red) en lugar del GPS de alta precisión. Solo activaré el GPS cuando el usuario esté realizando una acción concreta que realmente lo necesite (por ejemplo, calcular una ruta). Además, aprovecharé el sensor de proximidad para pausar la reproducción de audio o vídeo cuando el usuario se aleje del dispositivo, un detalle pequeño pero que ayuda a no gastar batería sin sentido.