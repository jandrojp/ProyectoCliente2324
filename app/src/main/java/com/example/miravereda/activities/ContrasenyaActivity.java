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
                        Usuario u = null;

                        @Override
                        public void doInBackground() {
                            usuarios =  Connector.getConector().getAsList(Usuario.class, "usuarios");
                            String user = usuarioActualizar.getText().toString();
                            String pass = nuevaContrasenya.getText().toString();


                            if (!user.isEmpty() && !pass.isEmpty()) {


                                for (Usuario us : usuarios) {
                                    if (us.usuario.equals(user)) {
                                        u = new Usuario(us.dni,
                                                us.usuario,
                                                pass,
                                                us.nombre,
                                                us.apellidos,
                                                us.email,
                                                us.domicilio,
                                                us.codigo_postal,
                                                us.fecha_nacimiento,
                                                us.tarjeta_credito);
                                    }
                                }
                            }

                            if (u != null) {
                                u = Connector.getConector().put(Usuario.class, u, "usuarios");
                            }
                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            if (u != null) {
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