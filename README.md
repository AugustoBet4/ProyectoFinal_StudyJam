Proyecto Final - Study Jam II 2016
===
<div align="center">
    <center>
        <img src="http://developerstudyjams.com/images/masthead.png" width="400px"/>
    </center>
</div>

Repositorio Proyecto Final del Study Jam Android Development for Beginners II 2016, llevado a cabo en la ciudad de La Paz, Bolivia a cargo del <a target="_blank" href="http://www.gdg.androidbolivia.com">GDG Android Bolivia</a> .

Nombre Aplicación.
---
El nombre de la aplicación es: Recetario Navideño

Objetivo
---
Listar,Agregar,Almacenar recetas navideñas ingresadas por el usuario.

Caracteristicas
---
* Agregar recetas propias del usuario (Opicion de eliminar recetas en base al nombre).
* Agregar imagenes usando la galeria.

Wireframes
---
Puedes visualizar los Wireframes de este proyecto.

https://ninjamock.com/s/8C34G

Compatibilidad
---
Esta aplicación es compatible con versiones de Android 5.0.1 o superior.

Uso
---------
Para probar este ejemplo clona este repositorio de la siguiente forma:
>
>     $ git clone https://github.com/AugustoBet4/ProyectoFinal_StudyJam.git

Luego de ello dentro de Android Studio:

* File --> New --> Import Project
* Seleccionas la ruta donde hiciste el `clone` del proyecto.
* Build --> Rebuild Project
* Run

Corrida previa
---
Aca te muestro cual es el funcionamiento de mi aplicación a grandes rasgos.
<div align="center">
    <center>
        <table border="0">
            <tr>
                <td><img src="https://github.com/AugustoBet4/ProyectoFinal_StudyJam/raw/master/img/menu.png" width="250"></td>
                <td><img src="https://github.com/AugustoBet4/ProyectoFinal_StudyJam/raw/master/img/añadir.gif" width="250"></td>
                <td><img src="https://github.com/AugustoBet4/ProyectoFinal_StudyJam/raw/master/img/detalle.gif" width="250"></td>
            </tr>
        </table>
    </center>
</div>
<br>

Descripción técnica
---
En este proyecto de utilizáron los siguientes componentes tanto en el `diseño` como en la `funcionalidad`:

**`Vista:`**
* LinearLayout (Vertical) para la alineación de las vistas principales.
* RelativeLayout, para el acomodamiento de la pantalla list: ListActivity.
* EditTexts, para recabar información acerca de los nombres de las recetas, ingredientes, preparacion.
.
.
.

**`Funcionalidad:`**
* CustomArray adapter para la creacion del ListView de las recetas.
* Uso de archivos de texto para guardar las recetas de los usuarios.
.
.
.

Autor(a)
---
José Augusto López Postigo

Contactos
---
augusto.bet4@gmail.com

[Facebook](https://www.facebook.com/augusto.bet4) <br>
[Twitter](https://twitter.com/6u7o)<br>
[Github](https://github.com/AugustoBet4)<br>