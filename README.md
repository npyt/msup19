# msup19

- [X] Estructuras de datos y transformaciones (23/4)
- [X] Operaciones básicas (7/5)
- [ ] Operaciones avanzadas (21/5)
- [ ] Suma fasores (30/5)
- [ ] Interfaz gráfica (17/6)

Indice
---
- [Enunciado](#enunciado)
- [EDT Estructura Datos y Transformaciones](#edt-estructura-datos-y-transformaciones)
- [OB Operaciones Básicas](#ob-operaciones-básicas)
- [OA Operaciones Avanzadas](#oa-operaciones-avanzadas)
- [SF Suma Fasores](#sf-suma-fasores)
- [IG Interfaz Gráfica](#ig-interfaz-gráfica)
- [Manual de usuario](#manual-de-usuario)

---

# Enunciado
 El trabajo práctico consiste en el desarrollo de una aplicación NCOM (Números Complejos) que
permita realizar un conjunto de operaciones con números complejos.
Dentro de las operaciones, NCOM deberá ser capaz de:
- Suma, resta, multiplicación y cociente de números complejos
- Potencia y radicación natural de un número complejo.
- Cálculo de raíces n-ésimas y primitivas.
- Suma de Fasores.

# EDT Estructura Datos y Transformaciones
Modelar una estructura de datos que permita representar a un número complejo en su forma
binómica y en su forma polar, y la transformación entre ambas formas de expresión.
Para esta primera etapa es aconsejable definir la estructura en forma binómica y luego desarrollar
funciones y/o procedimientos que permitan el cálculo del módulo y el argumento de un número
complejo en dicha forma para facilitar su pasaje a forma polar. Por último, se podrá formular un
procedimiento que permita el pasaje inverso, es decir, de forma polar a binómica. Es importante
considerar qué cuadrante se encuentra el número complejo en función de su argumento para
poder realizar su transformación a forma binómica.
Se asumen que la representación del argumento de un número complejo es en radianes con un
intervalo que contemplen el primer giro positivo. Por lo mencionado anteriormente se
recomienda elaborar algún procedimiento que corrija los argumentos de los números complejos
que no se encuentren dentro del primer giro positivo.

# OB Operaciones Básicas
Desarrollar procedimientos y funciones que permitan realizar la suma, resta, multiplicación y
cociente de números complejos.
Siempre será necesario distinguir entre ambas formas de expresar un número complejo y realizar
los pasajes necesarios para poder realizar cada una de las operaciones de la forma más
conveniente.
Se aconseja desarrollar las funciones auxiliares necesarias para resolver todas las operaciones. Por
ejemplo, podría desarrollarse la función complemento de un complejo para poder realizar la
división en forma binómica.

# OA Operaciones Avanzadas
Desarrollar procedimientos y funciones que permitan realizar la potencia y radicación natural de
un número complejo.
Dentro de esta etapa se incluye el cálculo de las raíces n-ésimas de la unidad y el cálculo de las
raíces primitivas en función del criterio de máximo común divisor.
En el caso de la radicación se deberán calcular todas las raíces asociadas a un número complejo.
Las mismas podrán ser almacenadas o listadas en forma vectorial.

# SF Suma Fasores
Desarrollar un procedimiento que realice (en caso de que sea posible) la suma de dos funciones
sinusoidales previa verificación de frecuencias. Se deberá tener en cuenta el pasaje de senos a
cosenos o viceversa en los casos que fuese necesario.

# IG Interfaz Gráfica
Se deberá presentar al usuario un listado en forma de menú en el cuál pueda seleccionar el tipo
de operación que desea realizar y su posterior ingreso de datos.
Para la suma, resta, multiplicación, división se deberán solicitar 2 números complejos, los cuales
podrán ser ingresados en cualquiera de sus formas indistintamente. Quedará a cargo de la
aplicación el control de validación de datos de entrada como así también la solicitud de un nuevo
ingreso. Se deberá mostrar en pantalla el resultado de la operación.
El formato utilizado para la forma binómica será: (a,b) siendo a la parte real del número complejo
y b su parte imaginaria.
El formato utilizado para la forma polar será: [a;b] siendo a el módulo del número complejo y b su
argumento.
Para el cálculo de suma o resta de Fasores se deberán ingresar dos funciones y para cada función
sinusoidal su amplitud, frecuencia y fase. Se deberá mostrar en pantalla el resultado de la suma
de ambas funciones. Para facilitar el ingreso de datos se aconseja realizar una consulta al usuario
por etapas, preguntando si la función es un seno o un coseno, luego su frecuencia, su fase y por
último su amplitud.

# Manual de usuario
Se deberá entregar junto al desarrollo del trabajo práctico, un manual de usuario el cual describa
la totalidad de funcionalidades que se encuentran disponible dentro del sistema. Debe estar
acompañado de gráficos, validaciones otorgadas, navegabilidad del sistema, etc.

