# Trabajo Practico APY2 TP2
Trabajo practico Nro 2º de algoritmos y programacion 2 UNTREF 2018 [Batalla Romana]

## Para poder ejecutarlo

#### Opcion 1
1. Ejecutar el archivo BatallaRomana.jar que se encuentra en BatallaRomana/dist/
2. Jugar!

#### Opcion 2
1. Importar el proyecto a NetBeans (Especificamente ya que se ha programado en el mismo y hay librerias que son internas de este, que fueron utilizadas)
2. Correr/Ejecutar la clase Juego(Que contiene el main)
3. Jugar!

## Decisiones de diseño

## Lista de archivos [Los archivos no mencionados forman parte de Netbeans]

#### Juego: Clase concreta, en la cual se aplica patrón singleton, donde se tratan todas las excepciones y contiene el juego en sí mismo. Se utiliza static main para iniciar el menú  principal de juego. Su función es de establecer un puente entre la lógica y las interfaces.
#### Batalla: Clase concreta, en la cual se aplica patrón singleton, que contiene a los jugadores y se encarga de definir quién ataca y quien defiende.
#### Lector: Clase concreta, en la cual se aplica patrón singleton, contiene a la clase lectorDeArchivo, es la clase encargada, por medio de su metodo principal, el generar Legiones a parti de lo entregado(leido) por el lectorDeArchivos
#### LectorDeArchivos: Clase concreta encargar de recibir y leer  archivos de texto con formatos FCP y FC, que identifican cada una de las legiones prefabricadas.(Aclaracion pequeña correccion al formato tanto FC como FCP , los nombres de legiones van sin “” y sin dejar espacios entre caracteres).
#### Jugador: Clase concreta que posee los métodos:

“atacar”. Este método se encarga de realizar la acción de atacar hacia un ejército enemigo específico (pasado por parámetro).

“atacarAUnTipoDeGuerrrero”. Este método privado se encarga Que se utiliza para atacar un tipo específico de soldado/guerrero perteneciente al ejército enemigo. En caso de que aun quede ataque/daño por realizar este se extiende al siguiente guerrero del mismo tipo.

“calcularAtaqueDelEjercito”. Este método define el  ataque a realizar contra el ejercito enemigo.
 
#### Ejército: Es la clase Component del composite. También es una clase abstracta padre que especifica el comportamiento común a todas las instancias, tanto simples como compuestas. En estas se encuentras las clases hijas denominadas:
- Auxiliar
- Centurión
- Legionario
- Legión

Legión: Es la clase Compuesta. También es una clase concreta que  hereda e implementa la clase Ejército (Component). Muestra el tipo de guerrero que está luchando en ese momento. Posee sus características fundamentales: costo, capacidad de ataque, capacidad de vida , contar guerreros y daño que realiza al enemigo.

#### Auxiliar: Es la clase hoja de la clase abstracta Ejército, la cual posee los cálculos de ataque con el método calcularAtaque, cuenta con el método “contarGuerrero” que se cuenta a si mismo,  tiene un precio que se obtiene con el método getCosto, y tiene el método “restarVida” que se encarga  de ejecutar el daño que reciba por parte del enemigo. Implementa al Component (Ejército).
#### Centurión: Es la clase hoja de la clase abstracta Ejército, la cual posee los cálculos de ataque con el método calcularAtaque, cuenta con el método “contarGuerrero” que se cuenta a si mismo,  tiene un precio que se obtiene con el método getCosto, y tiene el método “restarVida” que se encarga  de ejecutar el daño que reciba por parte del enemigo. Implementa al Component (Ejército).
#### Legionario: Es la clase hoja de la clase abstracta Ejército, la cual posee los cálculos de ataque con el método calcularAtaque, cuenta con el método “contarGuerrero” que se cuenta a si mismo,  tiene un precio que se obtiene con el método getCosto, y tiene el método “restarVida” que se encarga  de ejecutar el daño que reciba por parte del enemigo. Implementa al Component (Ejército).

(Estos ultimos 3, cuentan ademas con el metodo getCostoClase() es el mismo metodo con la diferencia del otro que no es estatico)

#### TipoDeGuerrero: Enum que limita la creación de objetos al Component (hojas del Composite y la clase Composite (Legión))

# Clases del paquete interfaces:
Son clases que utilizan ciertas librerias para poder mostrar en pantallas formularios java.
Los pocos metodos que estas poseen son clickJButton que haran ejecutar metodos de la clase Juego.

## Lista de archivos
- src/BatallaRomana/Batalla.java
- src/BatallaRomana /Ejercito.java
- src/BatallaRomana/Jugador.java
- src/BatallaRomana/Legion.java
- src/BatallaRomana/MenuPrincipal.java
- src/BatallaRomana/TipoDeGuerrero.java
- src/BatallaRomana/Auxiliar.java
- src/BatallaRomana/Centurion.java
- src/BatallaRomana/Legionario.java
- src/Lector/Lector.java
- src/Lector/LectorDeArchivos.java
- src/Interfaces/ComprarEjercito.java
- src/Interfaces/CrearJugador.java
- src/Interfaces/LanzarDado.java
- src/Interfaces/Mensajero.java
- src/Interfaces/MenuDeGuerra.java
- src/Interfaces/MenuPrincipal.java
- src/Archivos/archivo.txt
- src/Archivos/hqdefault.jpg
- src/Archivos/rometotwar_thumb.jpg

### Excepciones
- src/excepciones/ErrorDatosVacioDeJugador.java
- src/excepciones/ErrorCompraNegativa.java
- src/excepciones/ErrorPlataInsuficiente.java
- src/excepciones/ErrorValorNulo.java
### Test
- test/pruebasUnitarias/testAuxiliar
- test/pruebasUnitarias/testCenturion
- test/pruebasUnitarias/testLegionario
