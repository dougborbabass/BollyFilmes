package com.douglasborba.bollyfilmes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FilmesAdapter extends ArrayAdapter<ItemFilme> {

    private static final int VIEW_TYPE_DESTAQUE = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    public FilmesAdapter(Context context, ArrayList<ItemFilme> filmes) {
        super(context, 0, filmes);
    }

    public static class itemFilmeHolder {
        TextView titulo;
        TextView desc;
        TextView dataLancamento;
        RatingBar avaliacao;
        ImageView poster;

        public itemFilmeHolder (View view){
            titulo = view.findViewById(R.id.item_titulo);
            desc = view.findViewById(R.id.item_descricao);
            dataLancamento = view.findViewById(R.id.item_data);
            avaliacao = view.findViewById(R.id.item_avaliacao);
            poster = view.findViewById(R.id.item_poster);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int viewType = getItemViewType(position);
        ItemFilme filme = getItem(position);
        View itemView = convertView;

        switch (viewType) {
            case VIEW_TYPE_DESTAQUE: {
                itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_filme_destaque, parent, false);

                TextView desc = itemView.findViewById(R.id.item_desc_poster);
                desc.setText(filme.getDescricao());

                RatingBar avaliacao = itemView.findViewById(R.id.item_avaliacao);
                avaliacao.setRating(filme.getAvaliacao());

                break;
            }
            case VIEW_TYPE_ITEM: {
                itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_filme, parent, false);

                itemFilmeHolder holder;

                if(itemView.getTag() == null)
                {
                    holder = new itemFilmeHolder(itemView);
                    itemView.setTag(holder);
                } else{
                    holder = (itemFilmeHolder) itemView.getTag();
                }
                
                holder.titulo.setText(filme.getTitulo());
                holder.desc.setText(filme.getDescricao());
                holder.dataLancamento.setText(filme.getDataLancamento());
                holder.avaliacao.setRating(filme.getAvaliacao());

                break;
            }
        }

        return itemView;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0 ? VIEW_TYPE_DESTAQUE : VIEW_TYPE_ITEM);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
