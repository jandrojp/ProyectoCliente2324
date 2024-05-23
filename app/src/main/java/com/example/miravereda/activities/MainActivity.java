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

/**
 * Actividad principal de la aplicación que muestra las opciones de inicio de sesión y registro.
 */
public class MainActivity extends BaseActivity {

    private Button crearCuenta;
    private Button iniciarSesion;
    private Button recordarContrasenya;
    private EditText usuarioTxt;
    private EditText contrasenyaTxt;
    private List<Usuario> usuarios;

    /**
     * Método llamado al crear la actividad. Se encarga de inicializar la interfaz de usuario y los componentes.
     *
     * @param savedInstanceState Objeto donde se almacena el estado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aplicación de la preferencia de tema
        ThemeSetup.applyPreferenceTheme(getApplicationContext());
        // Aplicación de la preferencia de idioma
        IdiomSetUp.applyPreferenceIdiom(getApplicationContext());

        // Inicialización de los componentes de la interfaz de usuario
        crearCuenta = findViewById(R.id.bttnCrearCuenta);
        recordarContrasenya = findViewById(R.id.bttnRecordarContrasenya);
        iniciarSesion = findViewById(R.id.bttnIniciarSesion);
        usuarioTxt = findViewById(R.id.txtUser);
        contrasenyaTxt = findViewById(R.id.txtPassword);

        // Configuración del botón para ir a la actividad de recordar contraseña
        recordarContrasenya.setOnClickListener(view -> {
            Intent intent = new Intent(this, ContrasenyaActivity.class);
            startActivity(intent);
        });

        // Configuración del botón para iniciar sesión
        iniciarSesion.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {
                        long resultado = 0;

                        @Override
                        public void doInBackground() {
                            // Obtención de la lista de usuarios
                            usuarios =  Connector.getConector().getAsList(Usuario.class, "usuarios");

                            String usuario = usuarioTxt.getText().toString();
                            String contrasenya = contrasenyaTxt.getText().toString();

                            // Verificación de que los campos de usuario y contraseña no estén vacíos
                            if (!usuarioTxt.getText().toString().isEmpty() && !contrasenyaTxt.getText().toString().isEmpty()) {
                                // Comprobación de credenciales en la lista de usuarios
                                resultado = usuarios.stream().filter(usu -> usu.usuario.equals(usuario) && usu.contrasenya.equals(contrasenya)).count();
                            }

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            // Redirección a la actividad principal si las credenciales son correctas
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

        // Configuración del botón para ir a la actividad de crear cuenta
        crearCuenta.setOnClickListener(view -> {
            Intent intent = new Intent(this, CrearCuentaActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Método para crear un nuevo menú.
     *
     * @param menu Menú que se va a inflar.
     * @return Devuelve true para mostrar el menú.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Método que maneja las opciones del menú.
     *
     * @param item Elemento del menú seleccionado.
     * @return Devuelve true si la opción del menú fue manejada, de lo contrario, devuelve el resultado del método base.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.configuracion):
                // Ir a la actividad de preferencias
                Intent intentPreferenciasActivity = new Intent(this, PreferenciasActivity.class);
                startActivity(intentPreferenciasActivity);
                return true;
            case (R.id.exit):
                // Salir de la aplicación
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
