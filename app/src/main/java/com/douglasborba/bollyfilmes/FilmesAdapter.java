package com.douglasborba.bollyfilmes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FilmesAdapter extends ArrayAdapter <ItemFilme> {

    public FilmesAdapter (Context context, ArrayList<ItemFilme> filmes){
        super(context, 0, filmes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_filme, parent, false);
        }

        ItemFilme filme = getItem(position);

        TextView titulo = itemView.findViewById(R.id.item_titulo);
        titulo.setText(filme.getTitulo());

        TextView desc = itemView.findViewById(R.id.item_descricao);
        desc.setText(filme.getDescricao());

        TextView dataLancamento = itemView.findViewById(R.id.item_data);
        dataLancamento.setText(filme.getDataLancamento());

        RatingBar avaliacao = itemView.findViewById(R.id.item_avaliacao);
        avaliacao.setRating(filme.getAvaliacao());

        return itemView;
    }
}
