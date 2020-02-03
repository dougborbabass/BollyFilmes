package com.douglasborba.bollyfilmes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lista = view.findViewById(R.id.list_filmes);

        final ArrayList<ItemFilme> arrayList = new ArrayList<>();
        arrayList.add(new ItemFilme("Homem aranha 1", "Super herói", "76/01/2020", 3));
        arrayList.add(new ItemFilme("Homem aranha 2", "Super herói", "76/01/2020", 3.5f));
        arrayList.add(new ItemFilme("Homem aranha 3", "Super herói", "76/01/2020", 4));
        arrayList.add(new ItemFilme("Homem aranha 4", "Super herói", "76/01/2020", 1));
        arrayList.add(new ItemFilme("Homem aranha 5", "Super herói", "76/01/2020", 4.5f));

        FilmesAdapter adapter = new FilmesAdapter(getContext(), arrayList);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ItemFilme itemFilme = arrayList.get(i);
                callback callback = (MainFragment.callback) getActivity();
                assert callback != null;
                callback.onItemSelected(itemFilme);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_atualizar:
                Toast.makeText(getContext(), "Atualizando...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public interface callback {
        void onItemSelected(ItemFilme itemFilme);
    }

}
