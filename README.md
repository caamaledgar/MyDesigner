# MyDesigner

Diseño inicial de pantallas de proyecto de Aplicaciones Móviles para Android, del Instituto Tecnólogico de Chiná, Campeche

Utilizando Fragmentes, Shapes y Glide para incluir imágenes desde Internet 


En la carpeta res/drawable, crear un Android Resouce File, El Resource File debe ser de tipo Drawable

![](https://github.com/caamaledgar/documentationPtojects/blob/main/MyDesigner/myshape.png)


Ejemplos de SHAPE

Círculo
 ````
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="@color/white"/>

</shape>
 ````

Rectángulo con las esquinas superiores redondeadas
 ````
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/white"/>
    <corners android:topRightRadius="50dp"
        android:topLeftRadius="50dp"/>

</shape>
````

Rectángulo con las esquinas inferior izquierda redondeada
````
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/white"/>
    <corners android:bottomLeftRadius="100dp"
        />

</shape>
````

![](https://github.com/caamaledgar/documentationPtojects/blob/main/MyDesigner/rectangle_round.png)

En nuestros archivos XML se incluyen como un elemento imágen nuestras formas

````
    <ImageView
        android:id="@+id/imgFondo"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginBottom="100dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0"
        app:srcCompat="@drawable/rectangle_round_bottom_left" />
````

El atributo que utilizará nuestra Shape es app:srcCompat

````
app:srcCompat="@drawable/rectangle_round_bottom_left" />
````

![](https://github.com/caamaledgar/documentationPtojects/blob/main/MyDesigner/disennoXML.png)


Con algunos diseños básicos de formas, se  pueden generar diseños agradables para los usuarios.


Modelo No. 1

![](https://github.com/caamaledgar/documentationPtojects/blob/main/MyDesigner/Inicio1.png)


Modelo No. 2

![](https://github.com/caamaledgar/documentationPtojects/blob/main/MyDesigner/inicio2.png)


Modelo No. 3

![](https://github.com/caamaledgar/documentationPtojects/blob/main/MyDesigner/inicio3.png)












