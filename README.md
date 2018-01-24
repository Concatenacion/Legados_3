Wrapper web de una aplicación legada en MSDOS
=============
[![Build Status](https://travis-ci.org/Concatenacion/Legados_3.svg?branch=master)](https://travis-ci.org/Concatenacion/Legados_3)

Esta aplicación desarrollada en Java, sera utilizada como wrapper sobre una aplicación legada en MSDOS, permitiendo obtener los datos almacenados en la base de dicha aplicación legada.

El back-end de la aplicación web se ha desarrollado en el framework Spark, y se ha basado en el código de [Building a simple RESTful API with Spark][1].

El front-end a su vez se ha basado en [todoapp-spark][2], se ha realizado mediante AngularJs.

La obtención de datos de la aplicación MSDOS se obtienen mediante pantallazos guardados en jpgs. Para obtener los datos de dichos pantallazos se ha utilizado la API que ofrece Google, la cual permite obtener el texto dada una imagen.

Colaborador: Santiago Morón Borraz

[1]: http://www.mscharhag.com/2014/06/building-simple-restful-api-with-spark.html
[2]: https://github.com/shekhargulati/todoapp-spark
