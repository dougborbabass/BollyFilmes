package com.douglasborba.bollyfilmes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FilmeDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detalhe);

        Intent intent = getIntent();
        ItemFilme itemFilme = (ItemFilme) intent.getSerializableExtra(MainActivity.KEY_FILME);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FilmeDetalheFragment filmeDetalheFragment = new FilmeDetalheFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.KEY_FILME, itemFilme);
        filmeDetalheFragment.setArguments(bundle);

        fragmentTransaction.commit();

    }
}
