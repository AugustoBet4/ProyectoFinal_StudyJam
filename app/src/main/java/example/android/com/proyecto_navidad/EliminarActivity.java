package example.android.com.proyecto_navidad;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EliminarActivity extends AppCompatActivity {
    private EditText tf1;

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
        setContentView(R.layout.activity_eliminar);
        getSupportActionBar().hide();
        tf1 = (EditText) findViewById(R.id.tf1);
    }
    public void elimi(View view){
        int i=0;
        try{
            File file = Environment.getExternalStorageDirectory();
            File f = new File(file.getAbsolutePath(),"/Recetario/"+"recetas.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String linea;


            File dir = new File(Environment.getExternalStorageDirectory()+"/Recetario/");
            File file2 = new File(dir, "recetas2.txt");
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file2,true));

            while((linea = br.readLine())!=null){
                String[] array=linea.split(";");
                if(array[0].equals(tf1.getText().toString())){
                    i=1;
                }
                else{
                    osw.write(linea+"\n");
                }
            }
            br.close();
            osw.flush();
            osw.close();
            if(i==0){
                Toast.makeText(getApplicationContext(), "No se encontro la receta", Toast.LENGTH_LONG).show();
                tf1.setText("");
            }
            else{
                Toast noti = Toast.makeText(this,"Receta eliminada",Toast.LENGTH_LONG);
                noti.show();

                File dir2 = new File(Environment.getExternalStorageDirectory()+"/Recetario/");
                File file3 = new File(dir2, "recetas.txt");
                file3.delete();

                File file4 = Environment.getExternalStorageDirectory();
                File f2 = new File(file4.getAbsolutePath(),"/Recetario/"+"recetas2.txt");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
                String linea2;

                File dir3 = new File(Environment.getExternalStorageDirectory()+"/Recetario/");
                File file5 = new File(dir3, "recetas.txt");
                OutputStreamWriter osw3 = new OutputStreamWriter(new FileOutputStream(file5,true));
                linea2=br2.readLine();
                while (linea2 != null) {
                    osw3.write(linea2+"\n");
                    linea2=br2.readLine();
                }
                osw3.flush();
                osw3.close();
                br2.close();
                finish();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
