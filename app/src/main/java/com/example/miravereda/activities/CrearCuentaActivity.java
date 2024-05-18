package com.example.miravereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miravereda.activities.model.Usuario;
import com.example.miravereda.base.BaseActivity;
import com.example.miravereda.base.CallInterface;

import es.ieslavereda.miravereda.R;

public class CrearCuentaActivity extends BaseActivity {

    private EditText nombre;
    private EditText apellidos;
    private EditText DNI;
    private EditText email;
    private EditText domicilio;
    private EditText CP;
    private EditText fechaNacimiento;
    private EditText tarjeta;
    private EditText usuario;
    private EditText contrasenya;
    private Button crearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        nombre = findViewById(R.id.etNombre);
        apellidos = findViewById(R.id.etApellidos);
        DNI = findViewById(R.id.etDNI);
        email = findViewById(R.id.etEmail);
        domicilio = findViewById(R.id.etDomicilio);
        CP = findViewById(R.id.etCodigoPostal);
        fechaNacimiento = findViewById(R.id.etDate);
        tarjeta = findViewById(R.id.etTarjetaCredito);
        usuario = findViewById(R.id.etUsuario);
        contrasenya = findViewById(R.id.etContrasenya);
        crearCuenta = findViewById(R.id.bttnCrear);

        crearCuenta.setOnClickListener(view -> {

            if (nombre.getText().toString().isEmpty() ||
                    apellidos.getText().toString().isEmpty() ||
                    DNI.getText().toString().isEmpty() ||
                    email.getText().toString().isEmpty() ||
                    domicilio.getText().toString().isEmpty() ||
                    CP.getText().toString().isEmpty() ||
                    fechaNacimiento.getText().toString().isEmpty() ||
                    tarjeta.getText().toString().isEmpty() ||
                    usuario.getText().toString().isEmpty() ||
                    contrasenya.getText().toString().isEmpty() ||
                    crearCuenta.getText().toString().isEmpty()) {

                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                finish();
            }
        } );


        /*
        crearCuenta.setOnClickListener(
                v -> {
                    showProgress();
                    executeCall(new CallInterface() {

                        Usuario u;

                        @Override
                        public void doInBackground() {
                            String nombre = tietNombre.getText().toString();
                            String apellidos = tietApellidos.getText().toString();
                            Oficio oficio = (Oficio) spinnerOficio.getSelectedItem();

                            u = new Usuario(nombre, apellidos, oficio.getIdOficio());
                            u = Model.getInstance(getApplicationContext()).insertUsuario(u);

                        }

                        @Override
                        public void doInUI() {
                            hideProgress();
                            if (u != null) {
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                setResult(RESULT_OK);
                                finish();

                            } else
                                Toast.makeText(getApplicationContext(), "Algo ha ido mal. Revisa los campos", Toast.LENGTH_LONG).show();
                        }
                    });
                }
        );

         */



    }

}
