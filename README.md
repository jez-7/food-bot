# food-bot 🤖 

food-bot es un sistema inteligente de gestión de pedidos vía WhatsApp diseñado para automatizar la atención al cliente en locales gastronómicos. Utiliza Inteligencia Artificial para interpretar lenguaje natural, permitiendo que los clientes realicen pedidos de forma conversacional sin fricciones.


## 🚀 Características Principales:

• Procesamiento de Lenguaje Natural (NLP): Integración con modelos de IA (Gemini/OpenAI) para transformar mensajes de texto caóticos en datos estructurados (JSON).

• Arquitectura Hexagonal (Ports & Adapters): Desacoplamiento total entre la lógica de negocio y las tecnologías externas (WhatsApp API, DB, IA).

• Alta Concurrencia: Implementación basada en Java 21 y Virtual Threads (Project Loom) para manejar cientos de pedidos simultáneos con un consumo mínimo de recursos.

• Resiliencia con Redis: Sistema de colas asincrónicas para gestionar Rate Limits de las APIs de IA y garantizar que ningún pedido se pierda en horas pico.

• Panel de Control (PWA): Interfaz para que el comercio gestione productos, precios y visualice pedidos en tiempo real.



## 🏗️ Arquitectura del Sistema: 

✅ El proyecto sigue los principios de la Clean Architecture y Arquitectura Hexagonal, asegurando que el núcleo del negocio sea testeable e independiente de frameworks.

Estructura de Paquetes:

• domain: Entidades puras y puertos (interfaces). El corazón del sistema.

• application: Casos de uso y orquestación de la lógica.

• infrastructure: Adaptadores para el mundo exterior (Spring Boot, WhatsApp Meta API, Redis, PostgreSQL).



## 🛠️ Stack Tecnológico:

• Lenguaje: Java 21 (Virtual Threads)

• Framework: Spring Boot 4

• Base de Datos: PostgreSQL (Persistencia) & Redis (Mensajería Asíncrona)

• IA: Google Gemini API  

• Comunicación: WhatsApp Business API (Meta)

• Despliegue: Docker & AWS (EC2)
