package com.example.miravereda.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.example.miravereda.API.Connector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase las cuales van a heredar aquellas clases que tengan que hacer cualquier tipo de llamada
 */
public class BaseActivity extends AppCompatActivity {

    protected Connector connector;
    protected ExecutorService executor = Executors.newSingleThreadExecutor();
    protected Handler handler = new Handler(Looper.getMainLooper());
    protected MyProgressBar progressBar;

    /**
     * Lanzamos la app y la enlazamos con su layout
     * @param savedInstanceState Contenedor donde se va a almacenar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connector = Connector.getConector();
        progressBar = new MyProgressBar(this);
    }

    /**
     * Ejecuta la llamada del callInterface
     * @param callInterface
     */
    protected void executeCall(CallInterface callInterface){
        executor.execute(() -> {
            callInterface.doInBackground();
            handler.post(() -> {
                callInterface.doInUI();
            });
        });
    }

    /**
     * Muestra el progressBar
     */
    public void showProgress(){
        progressBar.show();
    }

    /**
     * Oculta el progressBar
     */
    public void hideProgress(){
        progressBar.hide();
    }

    /**
     * Sobreescribimos el metodo para asociar a la barra de progreso al ContraintLayout o RelativeLayout
     * y asi poder centrarla y manipular la visibilidad del resto de componentes del ViewGroup
     * @param layout link de la vista
     */
    @Override
    public void setContentView(int layout){
        super.setContentView(layout);
        ViewGroup rootView = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
        progressBar.initControl(rootView);
        hideProgress();
    }

}
