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

                        @Override
                        public void doInBackground() {
                            usuarios =  Connector.getConector().getAsList(Usuario.class, "usuarios");
                            String user = usuarioActualizar.getText().toString();
                            String pass = nuevaContrasenya.getText().toString();
                            long resultado = 1;

                            if (!user.isEmpty() && !pass.isEmpty()) {
                              //  resultado = usuarios.stream().filter(usu -> usu.dni.equals(user) || usu.usuario.equals(nuevoUsuario)).count();
                            }
                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }
        );
    }

}