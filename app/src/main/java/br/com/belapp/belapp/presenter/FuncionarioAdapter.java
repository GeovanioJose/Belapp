package br.com.belapp.belapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.belapp.belapp.R;
import br.com.belapp.belapp.model.Profissional;
import br.com.belapp.belapp.model.Teste;

public class FuncionarioAdapter extends RecyclerView.Adapter<FuncionarioAdapter.ViewHolder> {

    private ArrayList<Profissional> profissionais;
    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public FuncionarioAdapter (Context context, ArrayList<Profissional> list){
        profissionais = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivProfissional;
        TextView tvNome;
        TextView tvPreco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProfissional = itemView.findViewById(R.id.ivProfissional);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvPreco = itemView.findViewById(R.id.tvPreco);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(profissionais.indexOf((Profissional) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public FuncionarioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_profisisonal,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FuncionarioAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(profissionais.get(i));

        for (int j = 0; j < ApplicationClass.servicos.size(); j++){
            if (ApplicationClass.servicos.get(j).getProfissionais().getmId().equals(profissionais.get(i).getmId())){
                viewHolder.tvPreco.setText("R$ "+ApplicationClass.servicos.get(j).getPreco());
            }
        }
        viewHolder.tvNome.setText("Nome: "+profissionais.get(i).getNome());
        viewHolder.ivProfissional.setImageResource(R.drawable.profissional_teste);
    }

    @Override
    public int getItemCount() {
        return profissionais.size();
    }
}