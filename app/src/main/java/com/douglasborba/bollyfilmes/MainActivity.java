package com.douglasborba.bollyfilmes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.list_filmes);

        ArrayList<ItemFilme> arrayList = new ArrayList<>();
        arrayList.add(new ItemFilme("Homem aranha 1", "Super herói", "76/01/2020", 3));
        arrayList.add(new ItemFilme("Homem aranha 2", "Super herói", "76/01/2020", 3.5f));
        arrayList.add(new ItemFilme("Homem aranha 3", "Super herói", "76/01/2020", 4));
        arrayList.add(new ItemFilme("Homem aranha 4", "Super herói", "76/01/2020", 1));
        arrayList.add(new ItemFilme("Homem aranha 5", "Super herói", "76/01/2020", 4.5f));

        FilmesAdapter adapter = new FilmesAdapter(this, arrayList);
        lista.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_atualizar:
                Toast.makeText(this, "Atualizando", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
