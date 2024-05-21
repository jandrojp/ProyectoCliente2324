package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miravereda.API.Connector;
import com.example.miravereda.activities.model.Usuario;
import com.example.miravereda.activities.preferencias.IdiomSetUp;
import com.example.miravereda.activities.preferencias.PreferenciasActivity;
import com.example.miravereda.activities.preferencias.ThemeSetup;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.CallInterface;

import java.util.List;

import es.ieslavereda.miravereda.R;

public class MainActivity extends BaseActivity {

    private Button crearCuenta;
    private Button iniciarSesion;
    private Button recordarContrasenya;
    private EditText usuarioTxt;
    private EditText contrasenyaTxt;
    private List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThemeSetup.applyPreferenceTheme(getApplicationContext());
        IdiomSetUp.applyPreferenceIdiom(getApplicationContext());

        crearCuenta = findViewById(R.id.bttnCrearCuenta);
        recordarContrasenya = findViewById(R.id.bttnRecordarContrasenya);
        iniciarSesion = findViewById(R.id.bttnIniciarSesion);
        usuarioTxt = findViewById(R.id.txtUser);
        contrasenyaTxt = findViewById(R.id.txtPassword);

        recordarContrasenya.setOnClickListener(view -> {
            Intent intent = new Intent(this, ContrasenyaActivity.class);
            startActivity(intent);
        });


        iniciarSesion.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {
                        long resultado = 0;

                        @Override
                        public void doInBackground() {
                            usuarios =  Connector.getConector().getAsList(Usuario.class, "usuarios");

                            String usuario = usuarioTxt.getText().toString();
                            String contrasenya = contrasenyaTxt.getText().toString();

                            if (!usuarioTxt.getText().toString().isEmpty() && !contrasenyaTxt.getText().toString().isEmpty()) {
                                resultado = usuarios.stream().filter(usu -> usu.usuario.equals(usuario) && usu.contrasenya.equals(contrasenya)).count();
                            }

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            if (resultado == 1) {
                                Intent intent = new Intent(getApplicationContext(), RecyclerActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Algo ha ido mal. Revisa los campos", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
        );






        crearCuenta.setOnClickListener(view -> {
            Intent intent = new Intent(this, CrearCuentaActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.configuracion):
                Intent intentPreferenciasActivity = new Intent(this, PreferenciasActivity.class);
                startActivity(intentPreferenciasActivity);
                return true;
            case (R.id.exit):
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }






}