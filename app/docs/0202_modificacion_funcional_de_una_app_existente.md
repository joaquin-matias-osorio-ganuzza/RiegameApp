# A2.2 · Modificación funcional de una app existente

## 1. Ejecución de la aplicación y localización de la pantalla a modificar

Ejecuté la aplicación y me dirigí a la pantalla donde quería realizar una modificación, algo visible y sencillo.

**Captura:**  
[Captura de pantalla para modificar](res/0202_captura_pantalla_para_modificar.png)

En la captura se ve un `nav` con una lista de secciones en el que, al hacer clic en una de ellas, el usuario es redirigido a una nueva pantalla.

---

## 2. Localización del código donde realizar la modificación

Lo siguiente que hice fue localizar el código exacto donde debía empezar para realizar la modificación.

Lo primero que quise localizar fue el título y el icono que se estaban utilizando para mostrar cada opción en el `nav`. Localicé el primer fichero, `strings.xml`, ya que me di cuenta de que la aplicación sigue las buenas prácticas y dicho fichero se encuentra en la ruta `res/values/strings.xml`.

Pensé que, si localizaba esto primero, luego, realizando la búsqueda de su uso, daría con el fichero que lo pinta en pantalla, y así fue.

**Captura:**  
[Captura del fichero strings.xml](res/0202_captura_fichero_strings.png)

---

## 3. Implementación del cambio

### 3.1. Localización de `NavigationItem`

La búsqueda me llevó a un fichero llamado `NavigationItem`, que es el fichero principal del cambio y se encuentra en la siguiente ruta del proyecto:

```text
com/example/jetnews/ui/navigation/NavigationItem.kt
```

En este fichero vi una estructura que pude identificar rápidamente. La clase `NavigationItem` declarada en este fichero sirve para definir la información de cada elemento del menú de navegación: a qué pantalla corresponde, qué icono muestra y qué texto aparece debajo o al lado del icono.

Es como una clase de datos (modelo) que representa cada elemento del menú de navegación de la aplicación. Su objetivo es agrupar en un único objeto toda la información necesaria para representar una opción del menú.


### 3.2. Añadir un nuevo `navigationItem`

Una vez estudiada la lógica de su uso y su implementación, decidí añadir un nuevo bloque, es decir, un nuevo item o `navigationItem`. Para que esto funcionase, tuve que añadir los parámetros necesarios para crear el item.

Cada parámetro tiene una responsabilidad:

| Parámetro | Función en Ajustes |
|---|---|
| `navKey` | Identifica el destino al que corresponde la opción. |
| `iconResourceId` | Indica qué icono se debe representar. |
| `iconContentDescriptionResourceId` | Proporciona una descripción accesible del icono. |
| `labelResourceId` | Indica el texto que identifica la opción del menú. |

**Captura:**
[0202_captura_fichero_navigationitem.png](res/0202_captura_fichero_navigationitem.png)

En la captura se ve nuestro nuevo Item creado siguiendo la estructura recomendada.

### 3.3. Creación de `SettingsKey`

El siguiente paso fue crear los elementos necesarios:

- `SettingsKey`, que se encuentra en el fichero `SettingScreen`: identifica la pantalla.
- Creamos un objeto en el que intervienen tres elementos:
    - `SettingsKey` es el identificador para el destino Ajustes.
    - `NavKey` es la interfaz de Navigation 3 que permite utilizarlo como clave de navegación.
    - `@Serializable` permite serializar ese objeto, algo útil para los mecanismos de navegación y restauración de estado que utilizan serialización.

La relación queda así:

- `NavigationItem` contiene el icono, la etiqueta y `SettingsKey`.
- `SettingsKey` identifica el destino de Ajustes.

**Captura:**
[0202_captura_settings_key.png](res/0202_captura_settings_key.png)

### 3.4. Creación de la pantalla visual (`SettingsScreen2`)

A continuación definí el contenido visual. Para ello creé un fichero llamado `SettingsScreen2`, que contiene una función `@Composable`. Esta función construye la interfaz visual:

- `Box` ocupa todo el espacio disponible.
- `Alignment.Center` centra su contenido.
- `Text` muestra el mensaje.

Esta es la pantalla propiamente dicha. No necesita `ViewModel`, porque no gestiona datos ni lógica de negocio, y tampoco necesita `Scaffold` para mostrar únicamente un texto.

**Captura:**
[0202_captura_settings_screen.png](res/0202_captura_settings_screen.png)

### 3.5. Registro de la entrada con `settingsEntry()`

Pero existe una diferencia importante: definir `SettingsScreen()` no hace que Navigation 3 sepa cuándo debe mostrarla. Para ello necesitamos crear `settingsEntry()` y conectar el destino con la pantalla.

Esta función es la pieza que conecta la clave con el contenido. La instrucción:

```kotlin
entry<SettingsKey> {
    SettingsScreen()
}
```

le indica al proveedor de entradas de Navigation 3 que, cuando deba representar una entrada identificada por `SettingsKey`, debe ejecutar `SettingsScreen()`.

Hay dos conceptos que conviene distinguir:

- `SettingsKey` identifica el destino.
- `settingsEntry()` registra la asociación entre ese destino y su interfaz.

### 3.6. Integración en `JetnewsNavDisplay`

Por último, en el fichero `JetnewsNavDisplay` he importado:

```kotlin
import com.example.jetnews.ui.settings.settingsEntry
```

Y dentro del proveedor de entradas he incluido:

```kotlin
val entryProvider = entryProvider {
    // Entradas existentes
    homeEntry(...)
    postEntry(...)
    interestsEntry(...)

    settingsEntry()
}
```

La llamada `settingsEntry()` registra la nueva entrada junto a las que ya existían.

Después, mi código pasa ese proveedor a:

```kotlin
val navEntries = navigationState.toDecoratedEntries(
    entryProvider = entryProvider
)
```

Y esas entradas se utilizan en el sistema que termina mostrando el contenido mediante `NavDisplay`.

De esta forma, cuando la navegación llegue a `SettingsKey`, el sistema podrá encontrar la entrada registrada y mostrar `SettingsScreen()`.


**Captura:**
[0202_captura_entry_provider.png](res/0202_captura_entry_provider.png)

---

## 4. Resultado y justificación del cambio

Pensé que, dado que la aplicación no cuenta con una sección de ajustes básicos, podía implementar una nueva opción llamada `Settings` (Ajustes en castellano). El usuario, al hacer clic en pantalla, será redirigido a una nueva pantalla muy básica donde solo aparecerá un texto que dice: «Estás en la pantalla de ajustes».

Escogí tocar esta parte del código porque me pareció muy útil aprender cómo se realiza una operación muy básica en una aplicación móvil: hacer clic en un elemento y ser redirigido a otra pantalla. Dado que estamos estudiando un nuevo paradigma como Jetpack Compose, me pareció práctico realizar este cambio.