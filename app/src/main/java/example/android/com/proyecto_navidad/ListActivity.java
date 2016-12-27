package example.android.com.proyecto_navidad;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ListView list;
    private ArrayList<String> arrayListti;
    private ArrayList <String> arrayListim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        try{
            list = (ListView) findViewById(R.id.list);
            arrayListti = new ArrayList<String>();
            arrayListim = new ArrayList<String>();
            File file = Environment.getExternalStorageDirectory();
            File f = new File(file.getAbsolutePath(),"/Recetario/"+"recetas.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String linea;
            while((linea = br.readLine())!=null){
                String[] array=linea.split(";");
                arrayListti.add(array[0].toString());
                arrayListim.add(array[3].toString());
            }
            br.close();
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext(), "Debe ingresar recetas primero", Toast.LENGTH_SHORT).show();
            finish();
            e.printStackTrace();
        }
        LenguajeListAdapter adapter=new LenguajeListAdapter(this,arrayListti,arrayListim);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem= arrayListti.get(+position);
                Bundle i=new Bundle();
                i.putString("nombre",Slecteditem);
                Intent intent=new Intent(ListActivity.this, DetalleActivity.class);
                intent.putExtras(i);
                startActivity( intent );
            }
        });
        list.setAdapter(adapter);
    }
}
