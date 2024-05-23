package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miravereda.API.Connector;
import com.example.miravereda.activities.model.Usuario;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.CallInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import es.ieslavereda.miravereda.R;

public class CrearCuentaActivity extends BaseActivity {

    private EditText etNombre;
    private EditText etApellidos;
    private EditText etDNI;
    private EditText etEmail;
    private EditText etDomicilio;
    private EditText etCP;
    private EditText etFechaNacimiento;
    private EditText etTarjeta;
    private EditText etUsuario;
    private EditText etContrasenya;
    private Button crearCuenta;
    private List<Usuario> usuarios;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etDNI = findViewById(R.id.etDNI);
        etEmail = findViewById(R.id.etEmail);
        etDomicilio = findViewById(R.id.etDomicilio);
        etCP = findViewById(R.id.etCodigoPostal);
        etTarjeta = findViewById(R.id.etTarjetaCredito);
        etUsuario = findViewById(R.id.etUsuario);
        etContrasenya = findViewById(R.id.etContrasenya);
        crearCuenta = findViewById(R.id.bttnCrear);
        floatingActionButton = findViewById(R.id.fabRet);

        floatingActionButton.setOnClickListener(view -> finish());

        crearCuenta.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {
                        long resultado = 1;

                        @Override
                        public void doInBackground() {
                            usuarios = Connector.getConector().getAsList(Usuario.class, "usuarios");
                            String nuevoDni = etDNI.getText().toString();
                            String nuevoUsuario = etUsuario.getText().toString();


                            if (!etDNI.getText().toString().isEmpty() && !etUsuario.getText().toString().isEmpty()
                                    && !etContrasenya.getText().toString().isEmpty()) {
                                resultado = usuarios.stream().filter(usu -> usu.dni.equals(nuevoDni) || usu.usuario.equals(nuevoUsuario)).count();
                            }

                            if (resultado == 0) {

                                Usuario u = new Usuario(nuevoDni,
                                        nuevoUsuario,
                                        etContrasenya.getText().toString(),
                                        etNombre.getText().toString(),
                                        etApellidos.getText().toString(),
                                        etEmail.getText().toString(),
                                        etDomicilio.getText().toString(),
                                        etCP.getText().toString(),
                                        null,
                                        etTarjeta.getText().toString());

                                u = Connector.getConector().post(Usuario.class, u, "usuarios");

                            }

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            if (resultado == 0) {
                                Toast.makeText(getApplicationContext(), "Enhorabuena, su usuario ha sido creado", Toast.LENGTH_LONG).show();
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
