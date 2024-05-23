package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.miravereda.API.Connector;
import com.example.miravereda.activities.model.Usuario;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.CallInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import java.util.Optional;
import es.ieslavereda.miravereda.R;;

/**
 * Actividad para actualizar la contraseña del usuario.
 */
public class ContrasenyaActivity extends BaseActivity {

    private Button actualizarContrasenya;
    private List<Usuario> usuarios;
    private EditText usuarioActualizar;
    private EditText nuevaContrasenya;
    private FloatingActionButton fabReturn;

    /**
     * Método llamado al crear la actividad. Se encarga de inicializar la interfaz de usuario y los componentes.
     *
     * @param savedInstanceState Objeto donde se almacena el estado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenya);

        // Inicialización de los componentes de la interfaz de usuario
        actualizarContrasenya = findViewById(R.id.bttnActualizarContrasenya);
        usuarioActualizar = findViewById(R.id.txtUser);
        nuevaContrasenya = findViewById(R.id.txtPassword);
        fabReturn = findViewById(R.id.fabRet);

        // Configuración del botón flotante para regresar
        fabReturn.setOnClickListener(view -> finish());

        // Configuración del botón para actualizar la contraseña
        actualizarContrasenya.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {
                        int result = 0;

                        @Override
                        public void doInBackground() {
                            // Obtención de la lista de usuarios
                            usuarios =  Connector.getConector().getAsList(Usuario.class, "usuarios");
                            String user = usuarioActualizar.getText().toString();
                            String pass = nuevaContrasenya.getText().toString();

                            // Verificación de que los campos no estén vacíos
                            if (!usuarioActualizar.getText().toString().isEmpty() && !nuevaContrasenya.getText().toString().isEmpty()) {
                                // Búsqueda del usuario en la lista
                                Optional<Usuario> optional = usuarios.stream().filter(usu -> usu.usuario.equals(user)).findFirst();

                                if (optional.isPresent()) {
                                    // Si el usuario existe, se actualiza la contraseña
                                    Usuario usuarioSeleccionado = optional.get();

                                    Usuario u = new Usuario(usuarioSeleccionado.dni,
                                            usuarioSeleccionado.usuario,
                                            pass,
                                            usuarioSeleccionado.nombre,
                                            usuarioSeleccionado.apellidos,
                                            usuarioSeleccionado.email,
                                            usuarioSeleccionado.domicilio,
                                            usuarioSeleccionado.codigo_postal,
                                            usuarioSeleccionado.fecha_nacimiento,
                                            usuarioSeleccionado.tarjeta_credito);

                                    u = Connector.getConector().put(Usuario.class, u, "usuarios");
                                    result = 1; // Indicador de éxito
                                }

                            }

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            // Mostrar mensaje de éxito o error según el resultado
                            if (result == 1) {
                                Toast.makeText(getApplicationContext(), "Tu contraseña ha sido actualizada", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Algo ha ido mal. Revisa los campos", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
        );
    }
}