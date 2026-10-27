# Tarea A2.3 · Experimento de ciclo de vida (Proyecto Jetnews)

**Objetivo:** Observar de primera mano las transiciones de estado de una Activity mediante el uso de trazas `Log.d` en los callbacks del ciclo de vida y la implementación de `onSaveInstanceState` para la persistencia de estado.

---

## 1. Modificación del código en `MainActivity.kt`

Para realizar el experimento, modifiqué la clase `MainActivity` del proyecto Jetnews. Añadí un `TAG` específico (`JetnewsLifecycle`) para poder filtrar los logs fácilmente en Logcat. Además, implementé un contador manual (`contadorGuardados`) y sobrescribí `onSaveInstanceState` para comprobar visualmente si la restauración de estado funciona al recrearse la Activity.

---

## 2. Registro de situaciones en Logcat

A continuación, detallo las capturas de Logcat (filtradas por `tag:JetnewsLifecycle`) para cada una de las situaciones solicitadas, junto con su correspondiente explicación técnica.

### 📱 Situación 1: Arranque normal de la app

*Captura: [0203_app_arrancada.png](res/0203_app_arrancada.png)

*   **Explicación:** Al abrir la app desde cero, el sistema crea la Activity (`onCreate`). Al no haber un estado guardado previo, el Logcat registra el mensaje *"arranque limpio (sin estado previo)"*. Posteriormente, la Activity se hace visible (`onStart`) y pasa a primer plano interactivo (`onResume`).

### 🔄 Situación 2: Girar la pantalla

*Captura: [0203_app_pantalla_girada.png](res/0203_app_pantalla_girada.png)

*   **Explicación:** Al girar el emulador, el sistema detecta un cambio de configuración (orientación). Android destruye la Activity actual (`onPause` -> `onStop` -> `onSaveInstanceState` -> `onDestroy`) y crea una nueva instancia de forma inmediata (`onCreate` -> `onStart` -> `onResume`).
*   **Comprobación de `onSaveInstanceState`:** En la captura se observa cómo el contador incrementa (`guardando contadorGuardados=2`) y, justo después de la recreación, aparece el log *"estado restaurado -> contadorGuardados=2"*. Esto **demuestra empíricamente que el estado sobrevive a la rotación de pantalla**.

### 🏠 Situación 3: Pulsar el botón de inicio (Home) y volver a la app

*Captura: [0203_app_pulsado_boton_home.png](res/0203_app_pulsado_boton_home.png)

*Captura: [0203_abriendo_app_nuevamente_estando_en_segundo_plano.png](res/0203_abriendo_app_nuevamente_estando_en_segundo_plano.png)

*   **Explicación:** Al pulsar Home, la app pasa a segundo plano. En el Logcat se observa `onPause`, `onStop` y el guardado del estado (`guardando contadorGuardados=2`). En este punto, **no se llama a `onDestroy` inmediatamente**, la app queda viva en memoria.
*   **Muerte del proceso (Process Death):** En este experimento en particular, se puede observar un lapso de tiempo (del 21:49 al 21:51). Durante este tiempo, el sistema operativo Android (para optimizar recursos) decidió destruir el proceso de la app en segundo plano (`onDestroy called`).
*   **Reapertura:** Al volver a abrir la app, el sistema tuvo que crearla desde cero (`onCreate called`), pero gracias a la implementación de `onSaveInstanceState`, **se recuperó el estado previo** (`estado restaurado -> contadorGuardados=2`). Finalmente, la app volvió a ser visible (`onStart` y `onResume`). Esto demuestra que el guardado de estado es vital para sobrevivir a la muerte del proceso en segundo plano.

### ❌ Situación 4: Cerrar completamente la app y reabrirla

*Captura: [0203_cerrando_app.png](res/0203_cerrando_app.png)

*Captura: [0203_arrancando_app_nuevamente.png](res/_despues_de_cerrar.png)

*   **Explicación:** Al abrir la pantalla de "Recientes" y deslizar la app hacia arriba, el sistema elimina el proceso de memoria. En el Logcat vemos el esperado `onDestroy called`.
*   **Reapertura:** Al volver a tocar el icono de la app, el sistema crea una Activity totalmente nueva. En el Logcat se observa el `onCreate` seguido de **"arranque limpio (sin estado previo)"**. Esto confirma que, al cerrar la app deliberadamente, el estado guardado se descarta por completo y se inicia un ciclo de vida desde cero.

---

## 3. Conclusión del experimento

La conclusión principal es que `onSaveInstanceState` es fundamental para conservar datos volátiles (como el estado de la UI o variables) cuando la Activity se recrea debido a cambios de configuración, como puede ser una rotación de pantalla.

Asimismo, he comprendido la diferencia crítica entre que una app pase a segundo plano (donde permanece retenida en memoria por el sistema y se reanuda sin perder su estado, saltándose el `onCreate`) y que sea cerrada definitivamente por el usuario (donde el proceso muere y arranca desde cero en la próxima apertura).