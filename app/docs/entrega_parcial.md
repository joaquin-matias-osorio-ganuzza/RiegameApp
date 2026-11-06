## Entrega parcial

### Diseño de alta fidelidad de al menos una página de listado

- **Página de listado:**
  - [pagina_de_listado_1.png](res/entrega_parcial_pagina_de_listado_1.png)
  - [pagina_de_listado_2.png](res/entrega_parcial_pagina_de_listado_2.png)

### Diseño de alta fidelidad de al menos una página de detalle

- **Página de detalle:**
  - [pagina_detalle_1.png](res/entrega_parcial_pagina_detalle_1.png)
  - [pagina_detalle_2.png](res/entrega_parcial_pagina_detalle_2.png)
  - [pagina_detalle_3.png](res/entrega_parcial_pagina_detalle_3.png)

---

## Estudio de los componentes

### Página de listado

#### Cabecera (TopBar)

Este componente alberga el título de la página y un icono de ajustes.
Este elemento estará dentro de un composable (componente) `Scaffold`, al igual que los demás elementos que componen la página.

En su diseño podemos ver una `Column` para el texto **"RiegameApp"** y el título **"Mis plantas"**, y fuera de la `Column` tenemos el `SettingsButton`.

- **Cabecera:** [cabecera.png](res/entrega_parcial_cabecera.png)

#### Contenido interior del Scaffold

En este apartado tenemos un `Content` compuesto por una `LazyColumn`. El primer elemento visible se trata de una notificación composable.

Un elemento desplazable, se desplaza junto con la lista que hay debajo de esta. Resume el estado actual de las plantas.

Esta `Card` se compone de la siguiente manera:

- Una `Card`.
- Una `Row` dentro de la tarjeta.
- Un `Box` para el fondo del icono.
- Un `Icon` dentro del `Box`.
- Un `Spacer`.
- Una `Column` para los dos textos.
- Dos `Text` separados por un pequeño `Spacer`.

- **Card de notificación:** [card_de_notificacion.png](res/entrega_parcial_card_de_notificacion.png)

La siguiente sección que aparece después de la notificación es el contador de plantas, y ubicación de las plantas dentro del hogar.

Este elemento está compuesto por:

- Una `Row` como contenedor principal.
- Un `Text` para el título **"En casa"**.
- Un `Spacer` con `weight(1f)` para ocupar el espacio intermedio.
- Un segundo `Text` para el contador **"4 plantas"**.

- **Contador y texto informativo de ubicación de las plantas:** [ubicacion_y_contador.png](res/entrega_parcial_ubicacion_y_contador.png)

#### Card de plantas

Esta sección se compone de la siguiente forma:

- Una `Card` como contenedor exterior.
- Una `Row` dentro de la tarjeta para distribuir la imagen y la información horizontalmente.
- Un `Box` para contener la fotografía y superponer la ubicación.
- Un `AsyncImage` dentro del `Box`.
- Una `Surface` sobre la imagen para mostrar la ubicación.
- Un `Text` dentro de la `Surface`.
- Un `Spacer` horizontal entre la fotografía y la información.
- Una `Column` para organizar el nombre y la información de riego.
- Un `Text` para el nombre de la planta.
- Un `Spacer` vertical flexible.
- Una `Row` inferior para el estado de riego y el botón.
- Dos `Text` para mostrar **"Regar:"** y la fecha.
- Un `Spacer` flexible para empujar el botón hacia la derecha.
- Un `IconButton` con el icono de gota.

- **Tarjeta de las plantas:** [tarjeta_de_plantas.png](res/entrega_parcial_tarjeta_de_plantas.png)

#### Botón de añadir planta (FAB)

El último elemento visible en la página es el botón de añadir planta. Este se encuentra fuera de la `LazyColumn`, aunque dentro del `Scaffold`.

Está compuesto por un `FloatingActionButton` circular que contiene un `Icon` de tipo `Add`. Se incluye en el parámetro `floatingActionButton` del `Scaffold`, por lo que no forma parte de la `LazyColumn` y permanece visible mientras el usuario desplaza el listado.

Su posición es la esquina inferior derecha y su callback `onClick` comunica al nivel superior que debe abrirse la pantalla de creación de una planta.

- **Botón añadir planta:** [boton_agregar_planta.png](res/entrega_parcial_boton_agregar_planta.png)

---

### Página de detalle

Está compuesto por una `LazyColumn` que ocupa todo el espacio disponible.
Cada sección de la página se introduce como un elemento independiente de la `LazyColumn`.
La pantalla no utiliza `Scaffold`, menú lateral ni componentes de navegación, ya que su responsabilidad se limita a representar visualmente el detalle de una planta y comunicar las interacciones mediante callbacks.

#### Cabecera superior

La parte superior contiene:

- Una flecha hacia atrás.
- El nombre de la planta.
- Un icono de lápiz.

Se realiza exactamente con:

- Una `Row` como contenedor.
- Un `IconButton` para la flecha.
- Un `Icon` de tipo `ArrowBack` dentro del primer botón.
- Un `Text` central con `weight(1f)`.
- Un segundo `IconButton` para editar.
- Un `Icon` de tipo `Edit` dentro del segundo botón.

- **Cabecera superior página de detalle:** [pagina_detalle_cabecera.png](res/entrega_parcial_pagina_detalle.png)

#### Fotografía de la planta

La segunda sección es la fotografía grande de la planta.
Está compuesta por:

- Un `Box` como contenedor.
- Un `AsyncImage` que ocupa todo el `Box`.
- Un segundo `Box` superpuesto para el degradado.
- Un componente alineado en la esquina inferior derecha.

El `Box` permite superponer los tres elementos:

- La imagen.
- El degradado.
- La etiqueta **"Saludable"**.

- **Imagen central de la planta:** [imagen_planta_detalle.png](res/entrega_parcial_imagen_planta_detalle.png)

#### Estado de la planta

La etiqueta **"Saludable"** aparece sobre la imagen.

Se realizará exactamente con:

- Una `Surface` como fondo redondeado.
- Una `Row` dentro de la `Surface`.
- Un `Box` circular como indicador.
- Un `Spacer` horizontal.
- Un `Text` con el estado.

#### Información de la planta

Después de la imagen se muestra:

- El texto **"Tu planta"**.
- El nombre **"Monstera"**.
- La ubicación.
- La frecuencia de riego.

Se realizará exactamente con:

- Una `Column` como contenedor.
- Un `Text` pequeño para **"Tu planta"**.
- Un `Spacer`.
- Un `Text` grande para **"Monstera"**.
- Un `Spacer`.
- Una `Row`.
- Dos componentes que usan una función que crea una card, se colocan dentro de la `Row`.

La `Column` ocupa todo el ancho.

Las dos tarjetas ocuparán el mismo espacio.

Cada dato se representa mediante una tarjeta pequeña.

Se realizará exactamente con:

- Una `Card`.
- Una `Column`.
- Un `Text` para la etiqueta.
- Un `Spacer`.
- Un `Text` para el valor.

- **Información planta:** [informacion_planta.png](res/entrega_parcial_informacion_planta.png)

#### Botón principal de riego

Se realizará exactamente con:

- Un `Button` como contenedor.
- Una `Row` dentro del botón.
- Un `Icon` de gota.
- Un `Spacer` horizontal.
- Un `Text` principal.
- Un `Spacer`.
- Una `Surface` pequeña.
- Un `Text` con **"Hoy"** dentro de la `Surface`.

La `Surface` final crea la pequeña etiqueta **"Hoy"**.

Al marcar la planta como regada, visualmente puede cambiar a:

> Regada hoy ✓

Esto se controla con un estado visual.

- **Botón de riego:** [boton_de_riego.png](res/entrega_parcial_boton_de_riego.png)

#### Herramientas de cuidado

La sección contiene dos tarjetas:

- Medición de luz.
- Información del clima.

Se realizará exactamente con:

- Una `Row`.
- Un componente (función creada específicamente para ser reutilizada).
- Un `Spacer` horizontal.
- Un segundo componente reutilizable.

##### Tarjeta de herramienta 

Cada herramienta se realizará exactamente con:

- Una `Card`.
- Una `Row`.
- Un `Box` para el fondo del icono.
- Un `Icon`.
- Un `Spacer`.
- Una `Column`.
- Un `Text` secundario.
- Un `Spacer` vertical pequeño.
- Un `Text` principal.

- **Herramientas de cuidado:** [herramientas_de_cuidado.png](res/entrega_parcial_herramientas_de_cuidado.png)

#### Cabecera del historial

Se realizará exactamente con:

- Una `Row`.
- Una `Column` en el lado izquierdo.
- Un `Text` para **"Cuidados recientes"**.
- Un `Spacer` vertical.
- Un `Text` para **"Historial de riegos"**.
- Un `Spacer` horizontal.
- Un `Text` en el lado derecho con **"Últimos 30 días"**.

- **Cabecera del historial:** [cabecera_de_historial.png](res/entrega_parcial_cabecera_de_historial.png)

#### Tarjeta del historial

El historial completo se realizará exactamente con:

- Una `Card`.
- Una `Column`.
- Varios componentes (funciones específicamente creadas) reutilizables.
- Un `HorizontalDivider` entre cada registro.

##### Elemento del historial: `WateringHistoryItem`

Cada registro se realizará exactamente con:

- Una `Row`.
- Un `Box` para el fondo del icono.
- Un `Icon` de gota.
- Un `Spacer` horizontal.
- Una `Column`.
- Un `Text` para la fecha.
- Un `Spacer` vertical pequeño.
- Un `Text` para el tiempo relativo.
- Un `Spacer`.
- Un `Text` para la cantidad de agua.

- **Tarjeta del historial:** [tarjeta_historial.png](res/entrega_parcial_tarjeta_historial.png)

#### Composición visual del modo de edición

Al pulsar el lápiz, la sección de información puede sustituir sus textos por campos editables.
No es necesario cambiar toda la página.

- **Modo edición:** [modo_edicion.png](res/entrega_parcial_modo_edicion.png)