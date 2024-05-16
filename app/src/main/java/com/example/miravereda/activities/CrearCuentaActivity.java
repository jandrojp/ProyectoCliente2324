package com.example.miravereda.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import es.ieslavereda.miravereda.R;

public class CrearCuentaActivity extends AppCompatActivity {

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

        crearCuenta.setOnClickListener(view -> finish());
    }

}
