# Repositorio de trabajo
### para la generacion de reportes desde una base de datos
- En la clase frmpTitulo se encuentra una libreria llamada FiveCodMover, la cual su
	funcionamiento es el de poder mover un frame en estado "undecorated".
	Para ello se ocupa dos eventos mousePressed y mouseDragged.

- **frmpTitulo:** Es un JPanel Form el cual su funcion es proporcionar una barra de titulo
	cuando se activa la propiedad undecorated en JFrame, reemplazando a la original.

- **TextPrompt:** Esta clase es de [Rob Camick](https://tips4java.wordpress.com/2009/11/29/text-prompt/ "Rob Camick") la cual modifica un JTextComponent como un
	JTextField para que este pueda tener el efecto de placeholder. ***Modificacion:***
```java
//En la linea 49 hubo una pequeña modificacion
//Originalmente el valor era LEADING, pero se modico a CENTER
setHorizontalAlignment(JLabel.CENTER);
```

- **JButtonNew:** Esta clase dibuja un boton, esta compuesto por un JPanel y un JLabel en su
	interior esto para tener mejor personalizacion que con un boton ordinarion.

- **MetodosG:** Esta es una clase que contiene metodos en general: 
```java
charsToString(char[] chars) //convierte una coleccion de char en string
```
```java
setplaceHolder(javax.swing.text.JTextComponent txtComponent, String Texto, int estiloFuente, float Alpha) // Configura el placeholder en el JTextComponent
```
```java
getIcono(String ruta) //Obtiene el 'Icono' de una imagen
```
```java
getImage(String ruta) //Obtiene la Image de una ruta
```

------------

## Paquete conexiones
1. Contiene la clase *Conectar.java* la cual hace la conexion a la base de datos mysql
	esta clase tiene 3 eventos correctaConexion, erroneaConexion, ClaseNoEncontrada. Esto Para
	tener una mejor interaccion con el usuario.