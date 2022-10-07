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

        Glide.with(view)
                .load(urlLogoPrincipal)
                .error(view.getContext().getDrawable(android.R.drawable.presence_offline))
                .fitCenter()
                .into(imageView);

    }


}
