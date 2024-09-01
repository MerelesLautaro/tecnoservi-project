## Gestión de Tareas para una Empresa de Servicios de Internet por Cable

## Resumen

La empresa **"Tecnoservi"** es una contratista que se encarga de ofrecer servicios de internet por cable a clientes residenciales y comerciales. La empresa cuenta con un equipo de empleados que trabajan en grupos de hasta 2 personas, denominados *"equipos de trabajo"*. Cada equipo de trabajo se encarga de realizar tareas específicas para los clientes, como conexión, desconexión, servicio domiciliario y reconexión. El objetivo es crear un sistema de gestión de tareas que permita a la empresa asignar órdenes a los equipos de trabajo, visualizar el estado actual de cada orden y mejorar la eficiencia en la gestión de tareas y órdenes.

## Flujo de Trabajo

Cada tarea asignada a un equipo de trabajo pasa por un flujo de trabajo que consta de cuatro estados:

1. **Creado**: La orden es creada y asignada a un equipo de trabajo.
2. **En proceso**: El equipo de trabajo comienza a realizar la tarea asignada.
3. **Finalizado**: La tarea es completada con éxito.
4. **No realizado**: La tarea no se puede completar debido a algún problema o circunstancia imprevista.

## Órdenes

Cada orden tiene los siguientes atributos:

- **Número de orden**: Un identificador único para la orden.
- **Dirección**: La dirección del cliente donde se debe realizar la tarea.
- **Tareas a realizar**: La tarea específica que se debe realizar (conexión, desconexión, servicio domiciliario o reconexión).
- **Cliente**: El nombre del cliente que requiere la tarea.
- **Fecha**: La fecha en que se debe realizar la tarea.
- **Equipos**: La fecha en que se debe realizar la tarea.

## Requisitos del Sistema

El sistema que se debe crear debe permitir:

- Asignar órdenes a equipos de trabajo.
- Visualizar el estado actual de cada orden (creado, en proceso, finalizado o no realizado).
- Actualizar el estado de una orden según avance el trabajo.
- Mostrar la información detallada de cada orden, incluyendo la dirección, tarea a realizar, cliente y fecha.
- Permitir la gestión de los equipos de trabajo, incluyendo la asignación de tareas y la visualización del estado de cada equipo.

## Objetivos del Sistema

El sistema debe ayudar a la empresa **"Tecnoservi"** a:

- Mejorar la eficiencia en la gestión de tareas y órdenes.
- Reducir el tiempo de respuesta a los clientes.
- Incrementar la satisfacción del cliente mediante la realización de tareas de manera eficiente y efectiva.
- Proporcionar una visión clara del estado de cada orden y equipo de trabajo.
