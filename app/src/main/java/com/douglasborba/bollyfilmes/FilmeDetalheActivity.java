package com.douglasborba.bollyfilmes;

import androidx.appcompat.app.AppCompatActivity;

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

        TextView titulo = findViewById(R.id.item_titulo);
        titulo.setText(itemFilme.getTitulo());

        TextView data = findViewById(R.id.item_data);
        data.setText(itemFilme.getDataLancamento());

        TextView descricao = findViewById(R.id.item_descricao);
        descricao.setText(itemFilme.getDescricao());

        RatingBar avaliacao = findViewById(R.id.item_avaliacao);
        avaliacao.setRating(itemFilme.getAvaliacao());

        Button btn_trailer = findViewById(R.id.item_btn_trailer);
    }
}
