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
        etFechaNacimiento = findViewById(R.id.etDate);
        etTarjeta = findViewById(R.id.etTarjetaCredito);
        etUsuario = findViewById(R.id.etUsuario);
        etContrasenya = findViewById(R.id.etContrasenya);
        crearCuenta = findViewById(R.id.bttnCrear);

        crearCuenta.setOnClickListener(view -> {

            if (etNombre.getText().toString().isEmpty() ||
                    etApellidos.getText().toString().isEmpty() ||
                    etDNI.getText().toString().isEmpty() ||
                    etEmail.getText().toString().isEmpty() ||
                    etDomicilio.getText().toString().isEmpty() ||
                    etCP.getText().toString().isEmpty() ||
                    etFechaNacimiento.getText().toString().isEmpty() ||
                    etTarjeta.getText().toString().isEmpty() ||
                    etUsuario.getText().toString().isEmpty() ||
                    etContrasenya.getText().toString().isEmpty() ||
                    crearCuenta.getText().toString().isEmpty()) {

                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                finish();
            }
        } );



        crearCuenta.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {

                        @Override
                        public void doInBackground() {

                            usuarios = Connector.getConector().getAsList(Usuario.class, "usuarios");


                            /*
                            u = new Usuario(dni, usuario, contrasenya, nombre, apellidos, email, domicilio, cp, fechaNacimiento, tarjetaCredito);
                            u = Model.getInstance(getApplicationContext()).insertUsuario(u);

                             */
                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            String nombre = etNombre.getText().toString();
                            String apellidos = etApellidos.getText().toString();
                            String dni = etDNI.getText().toString();
                            String email = etEmail.getText().toString();
                            String domicilio = etDomicilio.getText().toString();
                            String cp = etCP.getText().toString();
                            String fechaNacimiento = etFechaNacimiento.getText().toString();
                            String tarjetaCredito = etTarjeta.getText().toString();
                            String usuario = etUsuario.getText().toString();
                            String contrasenya = etContrasenya.getText().toString();

                        }
                    });
                }
        );





    }

}
