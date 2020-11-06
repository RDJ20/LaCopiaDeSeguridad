package com.example.cartera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mdata;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList,Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context = context;
        this.mdata= itemList;
    }

    @Override
    public int getItemCount(){return mdata.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // aqui le decimos de donde viene el archivo XML donde va a inflar las ondas
        View view= mInflater.inflate(R.layout.recyclerviewcustomizada, null);
        return new  ListAdapter.ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mdata.get(position));
    }

    public void setitems(List<ListElement> items){ mdata= items; }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Categoria, Fecha, hora;

        ViewHolder(View itemview){
            super(itemview);
            Categoria=itemview.findViewById(R.id.categoria);
            Fecha=itemview.findViewById(R.id.fecha);
            hora=itemview.findViewById(R.id.hora);
        }

        void bindData(final ListElement item){
            Categoria.setText(item.getCategoria());
            Fecha.setText(item.getFecha());
            hora.setText(item.getHora());
        }
    }


}
