package example.android.com.proyecto_navidad;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetalleActivity extends AppCompatActivity {
    TextView tvNombre,tvIngredientes,tvPreparacion;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().hide();
        String nombre=getIntent().getStringExtra("nombre");
        tvNombre= (TextView) findViewById(R.id.tvNombre);
        tvIngredientes = (TextView) findViewById(R.id.tvIngredientes);
        tvPreparacion = (TextView) findViewById(R.id.tvPreparacion);
        im= (ImageView) findViewById(R.id.im);
        tvNombre.setText(nombre);
        try{
            File file = Environment.getExternalStorageDirectory();
            File f = new File(file.getAbsolutePath(),"/Recetario/"+"recetas.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String linea;
            while((linea = br.readLine())!=null){
                String[] array=linea.split(";");
                if(array[0].equals(nombre)){
                    tvIngredientes.setText(array[1]);
                    tvPreparacion.setText(array[2]);
                    Uri path = Uri.parse(String.valueOf(array[3]));
                    im.setImageURI(path);
                }
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
