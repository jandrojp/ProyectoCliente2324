package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.miravereda.API.Connector;
import com.example.miravereda.activities.model.Usuario;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.CallInterface;

import java.util.List;
import java.util.Optional;

import es.ieslavereda.miravereda.R;;

public class ContrasenyaActivity extends BaseActivity {

    private Button actualizarContrasenya;
    private List<Usuario> usuarios;
    private EditText usuarioActualizar;
    private EditText nuevaContrasenya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenya);

        actualizarContrasenya = findViewById(R.id.bttnActualizarContrasenya);
        usuarioActualizar = findViewById(R.id.txtUser);
        nuevaContrasenya = findViewById(R.id.txtPassword);

        actualizarContrasenya.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {
                        int result = 0;

                        @Override
                        public void doInBackground() {
                            usuarios =  Connector.getConector().getAsList(Usuario.class, "usuarios");
                            String user = usuarioActualizar.getText().toString();
                            String pass = nuevaContrasenya.getText().toString();

                            if (!usuarioActualizar.getText().toString().isEmpty() && !nuevaContrasenya.getText().toString().isEmpty()) {
                                Optional<Usuario> optional = usuarios.stream().filter(usu -> usu.usuario.equals(user)).findFirst();

                                if (optional.isPresent()) {
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
                                    result = 1;
                                }

                            }

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

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