package com.douglasborba.bollyfilmes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FilmeDetalheFragment extends Fragment {

    private ItemFilme itemFilme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            itemFilme = (ItemFilme) getArguments().getSerializable(MainActivity.KEY_FILME);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_filme_detalhe, container, false);

        if(itemFilme == null){
            return view;
        }

        TextView titulo = view.findViewById(R.id.item_titulo);
        titulo.setText(itemFilme.getTitulo());

        TextView data = view.findViewById(R.id.item_data);
        data.setText(itemFilme.getDataLancamento());

        TextView descricao = view.findViewById(R.id.item_descricao);
        descricao.setText(itemFilme.getDescricao());

        RatingBar avaliacao = view.findViewById(R.id.item_avaliacao);
        avaliacao.setRating(itemFilme.getAvaliacao());

        ImageView capa = view.findViewById(R.id.item_capa);
        new DownloadImageTask(capa).execute(itemFilme.getCapaPath());

        return view;
    }

}
