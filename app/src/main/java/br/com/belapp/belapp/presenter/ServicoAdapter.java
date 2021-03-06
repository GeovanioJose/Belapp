package br.com.belapp.belapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

import br.com.belapp.belapp.R;
import br.com.belapp.belapp.model.Servico;

public class ServicoAdapter extends RecyclerView.Adapter<ServicoAdapter.ViewHolder> {

    private ArrayList<Servico> testes;
    ItemClicked activity;

    public ServicoAdapter(Context context, ArrayList<Servico> list){
        testes = list;
        activity = (ItemClicked) context;
    }

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvServico, tvPreco, tvDuracao;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvServico = itemView.findViewById(R.id.tvServico);
            tvPreco = itemView.findViewById(R.id.tvPreco);
            tvDuracao = itemView.findViewById(R.id.tvDuracao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(testes.indexOf((Servico) v.getTag()));
                }
            });
        }
    }


    @NonNull
    @Override
    public ServicoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_servico,viewGroup,false);
        return new ServicoAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoAdapter.ViewHolder viewHolder, int i) {
        DecimalFormat df2 = new DecimalFormat(".##");
        viewHolder.itemView.setTag(testes.get(i));

        viewHolder.tvServico.setText(testes.get(i).getmNome());

        viewHolder.tvPreco.setText(String.format(Locale.getDefault(),"R$ %s", df2.format(testes.get(i).getmPreco())));
        int horas = testes.get(i).getmDuracao()/60;
        int minutos = testes.get(i).getmDuracao()%60;

        if(horas == 0) {
            viewHolder.tvDuracao.setText(String.format(Locale.getDefault(), "Duração: %d min", minutos));
        }
        else if(minutos == 0){
            viewHolder.tvDuracao.setText(String.format(Locale.getDefault(), "Duração: %d hora(s)", horas));
        }
        else{
            viewHolder.tvDuracao.setText(String.format(Locale.getDefault(), "Duração: %d hora(s) e %d min", horas, minutos));
        }


    }

    @Override
    public int getItemCount() {
        return testes.size();
    }
}
