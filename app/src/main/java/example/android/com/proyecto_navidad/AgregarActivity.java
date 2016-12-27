package example.android.com.proyecto_navidad;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AgregarActivity extends AppCompatActivity {
    private String APP_DIRECTORY = "recetas/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "recetas/";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";
    private final int SELECT_PICTURE = 200;
    public Uri path;
    public EditText etNombre,etIngredientes,etPreparacion;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
        finish();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        getSupportActionBar().hide();
        Button btim = (Button) findViewById(R.id.btim);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etIngredientes = (EditText) findViewById(R.id.etIngredientes);
        etPreparacion = (EditText) findViewById(R.id.etPreparacion);
        btim.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Elegir de la Galeria","Cancelar"};
                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(AgregarActivity.this);
                builder.setTitle("Elige una opcion: ");
                builder.setItems(options, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int seleccion) {
                        if (options[seleccion] == "Elegir de la Galeria"){
                            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            startActivityForResult(intent.createChooser(intent,"Selecciona una opcion"),SELECT_PICTURE);
                        }
                        else{
                            if(options[seleccion] == "Cancelar"){
                                dialog.dismiss();
                            }
                        }
                    }
                });
                builder.show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);
        switch (requestcode){
            case SELECT_PICTURE:
                if(resultcode == RESULT_OK){
                    path = data.getData();
                }
                break;
        }
    }
    public void mas(View view){
        if ((!etNombre.getText().toString().equals(""))&&(!etIngredientes.getText().toString().equals(""))&&(!etPreparacion.getText().toString().equals(""))) {
            boolean sdDisponible = false;
            boolean sdAccesoEscritura = false;
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)){
                sdDisponible = true;
                sdAccesoEscritura = true;
            }else {
                if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                    sdDisponible = true;
                    sdAccesoEscritura = false;
                } else {
                    sdDisponible = false;
                    sdAccesoEscritura = false;
                }
            }
            if (sdDisponible && sdAccesoEscritura) {
                try {
                    File dir = new File(Environment.getExternalStorageDirectory()+"/Recetario/");
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    File file = new File(dir, "recetas.txt");
                    try {
                        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file,true));
                        Uri uri = Uri.parse(String.valueOf(path));
                        osw.write(etNombre.getText().toString()+";"+etIngredientes.getText().toString()+";"+etPreparacion.getText().toString()+";"+uri+"\n");
                        osw.close();
                        Toast.makeText(getApplicationContext(), "Receta Agregada", Toast.LENGTH_SHORT).show();
                        finish();
                    }catch (Exception e) {
                        System.out.println("Error: "+e.getMessage());
                    }

                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            } else {
                System.out.println("No se puede escribir en su memoria");
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "Debe ingresar datos para guardar",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
