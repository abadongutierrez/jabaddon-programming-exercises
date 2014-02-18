# Problema: Peg Game

Existe un viejo juego en el que una pelota (usualmente de metal) se deja caer desde la parte superior de un tablero vertical, escogiendo una de varias posiciones desde donde soltarla. En el tablero hay pijas (obstáculos) contra los que la pelota rebotará conforme cae por efecto de la gravedad. Siempre que la pelota choca contra una pija, rebotará hacia la izquierda o la derecha con igual probabilidad (0.5). La única excepción es cuando choca contra una pija que se encuentra en el extremo derecho o izquierdo del tablero, en cuyo caso siempre rebota en dirección hacia el centro del tablero. Cuando nuestro tablero fue creado, tenía todas las pijas en su lugar. Sin embargo, es un tablero viejo y ahora le faltan algunas pijas. El objetivo del juego, es lograr que la pelota caiga hasta el fondo del tablero en un lugar específico.

Tu tarea es, dado un tablero de juego, determinar el lugar óptimo para soltar la pelota, tal que maximice la probabilidad de que caiga en un lugar específico.

La siguiente figura muestra un ejemplo de un tablero con 5 filas y 5 columnas ('x' indica una pija, '.' indica espacio vacío):

```
  x.x.x.x.x 
   x...x.x 
  x...x.x.x 
   x.x...x 
  x.x.x.x.x
   G
```
   
Nota que la fila superior tiene 5 pijas, la siguiente tiene 4, la siguiente 5, etc. Con 5 columnas, existen 4 opciones dónde dejar caer la pelota (indexando desde 0). Nota también que en este ejemplo, faltan 3 pijas. Por convención, diremos que la fila de la parte superior es la fila 0, y la pija que se encuentra más a la izquierda se encuentra en la columna 0, de tal manera que las pijas faltantes se encuentran en (1,1), (2,1) y (3,2). En este ejemplo, el mejor lugar para soltar la pelota es en la columna 1 (la que está más a la izquierda), la cual te da un 50% de probabilidad de que caiga en el objetivo.

Entradas:

Número de filas y columnas, (filas impares)
Posicion de pijas faltantes (no hay faltantes en 1a fila)
Columna de salida
Salida:

Las columna con más probabilidad de ganar.