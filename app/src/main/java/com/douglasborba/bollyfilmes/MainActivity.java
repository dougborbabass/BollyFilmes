package com.douglasborba.bollyfilmes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainFragment.callback{

    public static final String KEY_FILME = "FILME";

    private boolean isTablet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_filme_detalhe) != null){
            if(savedInstanceState == null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_filme_detalhe, new FilmeDetalheFragment())
                        .commit();
            }

            isTablet = true;
        } else {
            isTablet = false;
        }
    }

    @Override
    public void onItemSelected(ItemFilme itemFilme) {
        if(isTablet){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            FilmeDetalheFragment filmeDetalheFragment = new FilmeDetalheFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_FILME, itemFilme);
            filmeDetalheFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.fragment_filme_detalhe, filmeDetalheFragment);
            fragmentTransaction.commit();

        } else{
            Intent intent = new Intent(this, FilmeDetalheActivity.class);
            intent.putExtra(KEY_FILME, itemFilme);
            startActivity(intent);
        }
    }
}
