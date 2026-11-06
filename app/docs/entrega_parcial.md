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

### Cabecera (TopBar)

Este componente alberga el título de la página y un icono de ajustes.
Este elemento estará dentro de un composable (componente) `Scaffold`, al igual que los demás elementos que componen la página.

En su diseño podemos ver una `Column` para el texto **"RiegameApp"** y el título **"Mis plantas"**, y fuera de la `Column` tenemos el `SettingsButton`.

- **Cabecera:** [cabecera.png](res/entrega_parcial_cabecera.png)

### Contenido interior del Scaffold

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

### Card de plantas

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

### Botón de añadir planta (FAB)

El último elemento visible en la página es el botón de añadir planta. Este se encuentra fuera de la `LazyColumn`, aunque dentro del `Scaffold`.

Está compuesto por un `FloatingActionButton` circular que contiene un `Icon` de tipo `Add`. Se incluye en el parámetro `floatingActionButton` del `Scaffold`, por lo que no forma parte de la `LazyColumn` y permanece visible mientras el usuario desplaza el listado.

Su posición es la esquina inferior derecha y su callback `onClick` comunica al nivel superior que debe abrirse la pantalla de creación de una planta.

- **Botón añadir planta:** [entrega_parcial_boton_agegar_planta.png](res/entrega_parcial_boton_agegar_planta.png)