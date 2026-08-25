# Implementación de un Backend con Framework

El sistema necesita un backend robusto que pueda manejar solicitudes de usuarios, controlar variables de entorno, generar registros de logs y conectarse a una base de datos utilizando un ORM. El backend debe ser escalable y capaz de manejar un alto volumen de solicitudes.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Sólida Experiencia en Frameworks |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 5-6 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del Entorno

**Objetivo:** Configurar el entorno de desarrollo y desplegar el backend básico.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identifica las variables de entorno necesarias para el backend.
- Configura el entorno de desarrollo para que pueda manejar estas variables.

**Entregable:** Backend básico desplegado y funcionando con variables de entorno.

<details>
<summary>Pistas de conocimiento</summary>

- Las variables de entorno son cruciales para la configuración del backend.
- El entorno de desarrollo debe ser escalable y robusto.

</details>

### Fase 2: Implementación del Enrutamiento de Solicitudes

**Objetivo:** Implementar el enrutamiento de solicitudes y asegurar que el backend pueda manejar diferentes tipos de solicitudes.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Diseña la estructura de enrutamiento para manejar diferentes tipos de solicitudes.
- Implementa el enrutamiento y verifica que el backend pueda manejar solicitudes GET, POST, PUT y DELETE.

**Entregable:** Backend con enrutamiento de solicitudes implementado y funcionando.

<details>
<summary>Pistas de conocimiento</summary>

- El enrutamiento de solicitudes es fundamental para la funcionalidad del backend.
- Cada tipo de solicitud debe ser manejado de manera eficiente.

</details>

### Fase 3: Generación de Registros de Logs

**Objetivo:** Implementar la generación de registros de logs para el backend.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identifica los puntos clave en el backend donde se deben generar logs.
- Implementa la generación de logs y verifica que los logs sean claros y útiles para el diagnóstico.

**Entregable:** Backend con generación de logs implementada y funcionando.

<details>
<summary>Pistas de conocimiento</summary>

- Los logs son esenciales para el diagnóstico y la depuración del backend.
- Los logs deben ser claros y contener información relevante.

</details>

### Fase 4: Conexión con Base de Datos

**Objetivo:** Implementar la conexión con una base de datos utilizando un ORM.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura la conexión con la base de datos utilizando un ORM.
- Implementa las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.

**Entregable:** Backend con conexión a la base de datos y operaciones CRUD implementadas y funcionando.

<details>
<summary>Pistas de conocimiento</summary>

- La conexión con la base de datos es crucial para la funcionalidad del backend.
- Las operaciones CRUD deben ser implementadas de manera eficiente y segura.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un ORM y por qué es importante en la conexión con la base de datos?
- **paraQueSirve**: ¿Para qué sirve el enrutamiento de solicitudes en un backend?
- **comoSeUsa**: ¿Cómo se implementa la generación de logs en un backend?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar el enrutamiento de solicitudes y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la configuración del entorno de desarrollo para un backend robusto?

## Criterios de Evaluacion

- Configurar el entorno de desarrollo con variables de entorno.
- Implementar el enrutamiento de solicitudes y manejar diferentes tipos de solicitudes.
- Implementar la generación de registros de logs.
- Configurar la conexión con la base de datos utilizando un ORM y implementar operaciones CRUD.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
