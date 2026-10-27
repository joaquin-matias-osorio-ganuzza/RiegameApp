# A2.1 · Análisis de una app de código abierto

**Proyecto analizado:** JetNews (repositorio `android/compose-samples`)

---

## 1. ¿Cuántas Activities tiene y qué destinos de navegación contiene?

JetNews tiene **1 sola Activity** (`MainActivity`) y **3 destinos de navegación** principales:

*   **Home:** Pantalla principal de lista de noticias.
*   **Interests:** Pantalla de selección de temas de interés.
*   **Post:** Pantalla de detalle de un artículo.

> **Enfoque moderno:** Utiliza **Navigation 3** (basado en estado). Las pantallas se definen con llaves (`HomeKey`, `InterestsKey`, `PostKey`) y se registran en el archivo `ui/JetnewsNavDisplay.kt` mediante un `entryProvider`, todo dentro de una única Activity.

---

## 2. ¿Usa Services, Broadcast Receivers o Content Providers?

*   **Services:** No.
*   **Broadcast Receivers:** **Sí.** Usa `JetnewsGlanceAppWidgetReceiver` para actualizar el widget de pantalla de inicio (Glance App Widget). Escucha la acción del sistema `android.appwidget.action.APPWIDGET_UPDATE`.
*   **Content Providers:** No.

---

## 3. ¿Qué contiene su AndroidManifest.xml?

*   **Componentes declarados:**
    *   `Application`: `JetnewsApplication`
    *   `Activity`: `MainActivity`
    *   `Receiver`: `JetnewsGlanceAppWidgetReceiver`

*   **Permisos solicitados:** Ninguno.

*   **Actividad de arranque:** `.ui.MainActivity` (tiene el `intent-filter` con `MAIN` y `LAUNCHER`). Además, soporta **Deep Links** mediante un segundo `intent-filter` para enlaces `https://developer.android.com/jetnews`.

---

## 4. ¿Cómo está organizada la estructura de paquetes?

El paquete base es `com.example.jetnews` y está organizado por capas y características:

```text
com.example.jetnews/
├── data/                 # Repositorios y fuentes de datos (Posts, Interests)
├── model/                # Clases de datos (ej. Post)
├── ui/                   # Toda la interfaz gráfica (Compose)
│   ├── components/       # Elementos reutilizables (AppNavRail, SnackbarHost)
│   ├── home/             # Pantalla principal (Screen y ViewModel)
│   ├── interests/        # Pantalla de intereses (Screen y ViewModel)
│   ├── post/             # Pantalla de detalle (Screen y ViewModel)
│   ├── navigation/       # Lógica de navegación (Navigator, NavigationState)
│   ├── theme/            # Temas visuales y colores
│   └── utils/            # Utilidades varias
└── glance/               # Código específico del widget de pantalla de inicio