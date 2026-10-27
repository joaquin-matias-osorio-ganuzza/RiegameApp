# Plantilla: propuesta del Proyecto A

---

## 0 · Datos

| |                                 |
|---|---------------------------------|
| **Nombre de la app** | RiegameApp                      |
| **Autor/a** | [Joaquin Matias Osorio Ganuzza] |
| **Fecha** | [06/10/2026]                    |

---

## 1 · La idea en una frase

> Una app que permite a personas con plantas en casa recordar cuándo y cuánto regarlas, teniendo en cuenta el tiempo que hace en su zona, para que no se les mueran por olvido o por exceso de agua.

---

## 2 · El problema

> Mucha gente tiene plantas en casa, en la terraza o en el jardín, pero no lleva un control de cuándo las ha regado. El resultado es que unas veces se pasan de agua y otras se olvidan durante semanas. Además, el riego no depende solo del calendario: si ha llovido mucho o si ha hecho mucho calor, la planta necesita menos o más agua. Hoy en día esto se resuelve con alarmas genéricas del móvil que no tienen en cuenta nada de esto, o directamente con la memoria de cada uno, que suele fallar.

---

## 3 · Personas usuarias

> Mi usuaria principal se llama Marta, tiene 38 años, trabaja en una oficina y tiene un balcón con unas diez macetas entre plantas aromáticas, cactus y alguna flor. No es una experta en jardinería, pero le gusta tener plantas y se frustra cuando se le mueren. Usa el móvil a diario con soltura, sobre todo WhatsApp y apps de compras. Abriría RiegameApp un par de veces al día: por la mañana para ver qué toca regar y por la noche para anotar lo que ha hecho. Le dedicaría menos de cinco minutos cada vez. Si la app fallara o no le avisara bien, dejaría de usarla a la semana, así que las notificaciones tienen que ser fiables y no molestar.

---

## 4 · Funcionalidades

### Imprescindibles (sin esto la app no tiene sentido)

| # | Funcionalidad |
|---|---------------|
| F1 | Registrar plantas con nombre, foto y frecuencia de riego (cada cuántos días). |
| F2 | Ver una lista de mis plantas con el estado de cada una (toca regar, regada hace poco, etc.). |
| F3 | Recibir un aviso cuando toca regar una planta. |
| F4 | Consultar el tiempo de mi zona para ajustar el riego (si va a llover, no hace falta regar). |

### Opcionales (si sobra tiempo)

| # | Funcionalidad                                                                                   |
|---|-------------------------------------------------------------------------------------------------|
| O1 | Historial de riegos por planta, para ver si me estoy pasando o quedando corto.                  |
| O2 | Añadir notas de voz o texto a cada planta (por ejemplo, "esta necesita poca agua en invierno"). |

---

## 5 · Pantallas

| Pantalla | Para qué sirve | Se llega desde |
|----------|----------------|----------------|
| Lista de plantas | Ver todas mis plantas y su estado | (arranque) |
| Detalle de planta | Ver la ficha completa de una planta, su foto, su frecuencia y su historial | Lista de plantas |
| Añadir / editar planta | Crear una planta nueva o modificar una existente | Lista de plantas |
| Tiempo | Ver el tiempo de mi zona para decidir si regar o no | Lista de plantas |
| Ajustes | Configurar la hora de los avisos y la ciudad para el tiempo | Lista de plantas |

---

## 6 · Bocetos

> Los bocetos los haré a mano en papel y los adjuntaré como imágenes en la carpeta `docs/res` del proyecto. Los nombres de los archivos serán:
> - `boceto_agregar_planta.jpg`:[boceto_agregar_planta.jpg](../res/boceto_agregar_planta.jpg)
> - `boceto_lista_plantas.jpg`: [boceto_lista_plantas.jpg](../res/boceto_lista_plantas.jpg)
> - `boceto_detalle_planta.jpg`: [boceto_detalle_planta.jpg](../res/boceto_detalle_planta.jpg)

---

## 7 · Qué datos guarda la app

| Tipo de dato | Campos | Ejemplo |
|--------------|--------|---------|
| Planta | id, nombre, foto, frecuencia de riego (días), fecha del último riego, notas | "Albahaca", foto, cada 2 días, última vez ayer, "le gusta el sol" |
| Riego | id, id de planta, fecha, cantidad aproximada | Riego de la albahaca el 28/09/2026, un vaso |
| Ajustes | ciudad para el tiempo, hora de los avisos | "Sevilla", avisos a las 9:00 |

---

## 8 · Encaje con los requisitos del módulo

> Apartado obligatorio: ninguna casilla puede quedar vacía.

| Requisito | Dónde encaja en tu app | Tema |
|-----------|------------------------|------|
| **Persistencia de datos** — la información sobrevive al cerrar la app | Las plantas, los riegos y los ajustes se guardan en una base de datos local, para que al cerrar y volver a abrir la app siga todo ahí. | 4 |
| **Servicio web** — la app consulta datos por internet | La pantalla de "Tiempo" consulta una API pública de meteorología para saber si va a llover o si va a hacer mucho calor en la ciudad del usuario. | 5 |
| **Sensor o localización** | Uso la ubicación del móvil para saber en qué ciudad está el usuario y pedir el tiempo de esa zona. Así no tiene que escribirla a mano. | 6 |
| **Contenido multimedia** — foto, audio, vídeo o animación | Cada planta puede tener una foto hecha con la cámara del móvil, y opcionalmente una nota de voz con cuidados especiales. | 7 |

---

## 9 · Riesgos

| Lo que me preocupa | Plan B |
|--------------------|--------|
| Que la API del tiempo falle o cambie y la app no pueda consultar el tiempo. | Dejar la consulta del tiempo como algo opcional: si falla, la app sigue funcionando con los datos locales y solo muestra un aviso de que no se pudo consultar. |
| Que las notificaciones no lleguen a la hora prevista en algunos móviles (por el ahorro de batería del fabricante). | Usar el sistema estándar de notificaciones de Android y probar en el emulador y en mi Moto G84. Si veo que falla, avisar al usuario de que revise los permisos de la app. |
| Que el proyecto se me vaya de las manos y no me dé tiempo a todo. | He dejado las funcionalidades opcionales (historial y notas de voz) para el final. Si no llego, la app sigue siendo útil sin ellas. |

---

## Antes de entregar

- [x] La idea cabe en una frase.
- [x] El público es una persona concreta, no «todo el mundo».
- [x] Hay **3 o 4** funcionalidades imprescindibles, no diez.
- [x] Cada funcionalidad imprescindible tiene su pantalla.
- [x] Hay bocetos de las pantallas principales.
- [x] **Las cuatro casillas del apartado 8 están rellenas.**
- [x] Está identificado al menos un riesgo con su plan B.
