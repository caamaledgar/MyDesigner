# MyDesigner

Diseño inicial de pantallas de proyecto de Aplicaciones Móviles para Android, del Instituto Tecnólogico de Chiná, Campeche

Utilizando Fragmentos, Shapes y Glide para incluir imágenes desde Internet 

**##Paso 1**
En la carpeta res/drawable, crear un Android Resouce File, El Resource File debe ser de tipo Drawable

![](https://github.com/caamaledgar/documentationProjects/blob/main/MyDesigner/myshape.png)


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

![](https://github.com/caamaledgar/documentationProjects/blob/main/MyDesigner/rectangle_round.png)

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

![](https://github.com/caamaledgar/documentationProjects/blob/main/MyDesigner/disennoXML.png)



**##Paso 2**
Usar un estándar para el manejo de nuestros temas y colores

Con la herramienta de Google de Material Design [Color Tool](https://material.io/resources/color) podemos generar una plantilla de colores que integraremos a nuestro proyecto, sin ser expertos en diseño.

![](https://github.com/caamaledgar/documentationProjects/blob/main/MyDesigner/colorToolMaterialDesign.png)

En el botón Exportar, podremos generar los patrones básicos de los colores y los temas


colors.xml
````
<resources>
  <color name="primaryColor">#00bcd4</color>
  <color name="primaryLightColor">#62efff</color>
  <color name="primaryDarkColor">#008ba3</color>
  <color name="secondaryColor">#311b92</color>
  <color name="secondaryLightColor">#6746c3</color>
  <color name="secondaryDarkColor">#000063</color>
  <color name="primaryTextColor">#000000</color>
  <color name="secondaryTextColor">#ffffff</color>
  
  <!-- Colores básicos que se incluyen para una gama de colores de utilidad -->
    <color name="blueGray100">#CFD8DC</color>
    <color name="gray200">#EEEEEE</color>
    <color name="yellow200">#FFFF00</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>  
</resources>
````


themes.xml

````
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.MyDesigner" parent="Theme.MaterialComponents.DayNight.NoActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/primaryColor</item>
        <item name="colorOnPrimary">@color/white</item>
        <item name="colorPrimaryDark">@color/primaryDarkColor</item>
        <item name="colorAccent">@color/secondaryColor</item>
        <item name="colorSecondary">@color/secondaryColor</item>
        <item name="colorOnSecondary">@color/black</item>
        <item name="colorSecondaryVariant">@color/secondaryLightColor</item>
    </style>
</resources>
````

themes.xml (nigth)
````
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.MyDesigner" parent="Theme.MaterialComponents.DayNight.NoActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/primaryColor</item>
        <item name="colorOnPrimary">@color/black</item>
        <item name="colorPrimaryDark">@color/primaryDarkColor</item>
        <item name="colorAccent">@color/secondaryColor</item>
        <item name="colorSecondary">@color/secondaryColor</item>
        <item name="colorOnSecondary">@color/white</item>
        <item name="colorSecondaryVariant">@color/secondaryLightColor</item>
    </style>
</resources>
````

Esta configuración prepara nuestro proyecto Android para poder cambiar de manera dinamica los colores bajo un patron definido.




El tratamiento de la imágen principal se realizó con la libreria Glide

**##Paso 3**
En el archivo build.gradle de la app, se añade las dependencias de glide
    
````
dependencies{
    // Glide
    implementation 'com.github.bumptech.glide:glide:4.14.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.14.0'
}
````

**##Paso 4 **
Incluir en archivo AndroidManifiest.xml la funcionalidad para visualizar archivos desde Internet

````
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.INTERNET" />
````



**##Paso 5**
Añadir la funcionalidad en nuestros fragments/activities para consumir imágenes desde una URL

Para nuestro proyecto se crea una clase de utilerias Utils.java, dentro del paquete Utils, con el objetivo de poder utilizar esta funcinalidad desde cualquier fragmento.


````
package com.example.mydesigner.Utils;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mydesigner.R;

public class Utils {
    public void imagenPrincipal(View view){
        // Generar Imagen
        String urlLogoPrincipal;
        ImageView imageView = view.findViewById(R.id.imgLogo);
        urlLogoPrincipal = "https://itchina.edu.mx/wp-content/uploads/2019/10/itchina-1.jpg";
        //urlLogoPrincipal = "http://procesadordetex.wdfiles.com/local--files/nav:side/1395715081-logoChinaF.png";
        //urlLogoPrincipal = "https://itchina.edu.mx/wp-content/themes/tecchina_ok/assets/files/main/img/pleca_tecnm.jpg";

        // Glide.with(this) Cuando se utiliza desde un Activity
        Glide.with(view)
                .load(urlLogoPrincipal)
                .error(view.getContext().getDrawable(android.R.drawable.presence_offline))
                //.error(getApplicationContext().getDrawable(android.R.drawable.presence_offline)) Cuando se utiliza desde un Activity
                .fitCenter()
                .into(imageView);

    }
}
````

Nota: Para utilizar Glide en un Activity 
````
        Glide.with(this)
                .load(urlLogoPrincipal)
                .error(getApplicationContext().getDrawable(android.R.drawable.presence_offline))
                .fitCenter()
                .into(imageView);

````


Como punto final,  mandaremos a llamar a la clase instanciandola en nuestos fragmentos

````
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Utils utils = new Utils();
        utils.imagenPrincipal(view);
    }
    
````




Con algunos diseños básicos de formas, se  pueden generar diseños agradables para los usuarios.


**Modelo No. 1**

![](https://github.com/caamaledgar/documentationProjects/blob/main/MyDesigner/Inicio1.png)


**Modelo No. 2**

![](https://github.com/caamaledgar/documentationProjects/blob/main/MyDesigner/inicio2.png)


**Modelo No. 3**

![](https://github.com/caamaledgar/documentationProjects/blob/main/MyDesigner/inicio3.png)












