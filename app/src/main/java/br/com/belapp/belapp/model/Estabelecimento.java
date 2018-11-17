package br.com.belapp.belapp.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Estabelecimento {

    //Aqui atributos e metodos da classe
    String mEId;
    String mNome;
    String mTelefone;
    String mDescricao;
    String mMediaAvaliacoes; //campo derivado
    String mGaleria;
    Endereco mEndereco;
    ArrayList<Servico> mServicos;
    ArrayList<Agenda> mAgenda;
    ArrayList<Promocoes> mPromocoes;
    ArrayList<Profissional> mProfissionais;
    ArrayList<String> mAvaliacoes;
    private DatabaseReference mDataBase;

    public Estabelecimento(String mEId, String mNome, String mTelefone, Endereco mEndereco, ArrayList<Servico> mServicos, ArrayList<Profissional> mProfissionais) {
        this.mEId = mEId;
        this.mNome = mNome;
        this.mTelefone = mTelefone;
        this.mEndereco = mEndereco;
        this.mServicos = mServicos;
        this.mProfissionais = mProfissionais;
    }

    public void addEstabelecimento2(String mEId, String mNome, String mTelefone, Endereco mEndereco,
                                    ArrayList<Servico> mServicos, ArrayList<Profissional> mProfissionais) {

        Estabelecimento estabelecimento = new Estabelecimento(mEId, mNome, mTelefone, mEndereco,
                mServicos, mProfissionais);

        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("estabelecimentos").push().setValue(estabelecimento);
    }

    public Estabelecimento(String mEId, String mNome, String mTelefone, String mDescricao, String mMediaAvaliacoes,
                           String mGaleria, Endereco mEndereco, ArrayList<Servico> mServicos, ArrayList<Agenda> mAgenda,
                           ArrayList<Promocoes> mPromocoes, ArrayList<Profissional> mProfissionais, ArrayList<String> mAvaliacoes) {
        this.mEId = mEId;
        this.mNome = mNome;
        this.mTelefone = mTelefone;
        this.mDescricao = mDescricao;
        this.mMediaAvaliacoes = mMediaAvaliacoes;
        this.mGaleria = mGaleria;
        this.mEndereco = mEndereco;
        this.mServicos = mServicos;
        this.mAgenda = mAgenda;
        this.mPromocoes = mPromocoes;
        this.mProfissionais = mProfissionais;
        this.mAvaliacoes = mAvaliacoes;
    }

    public void addEstabelecimento(String eid, String nome, String telefone, String descricao, String mediaAvaliacoes,
                                   String galeria, Endereco endereco, ArrayList<Servico> servicos_arl, ArrayList<Agenda> agenda_arl,
                                   ArrayList<Promocoes> promocoes_arl, ArrayList<Profissional> profissionais_arl, ArrayList<String> avaliacoes_arl) {

        Estabelecimento estabelecimento = new Estabelecimento(eid, nome, telefone, descricao, mediaAvaliacoes,
                galeria, endereco, servicos_arl, agenda_arl, promocoes_arl, profissionais_arl, avaliacoes_arl);

        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("estabelecimentos").push().setValue(estabelecimento);
    }

    public String getmEId() {
        return mEId;
    }

    public void setmEId(String mEId) {
        this.mEId = mEId;
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmTelefone() {
        return mTelefone;
    }

    public void setmTelefone(String mTelefone) {
        this.mTelefone = mTelefone;
    }

    public String getmDescricao() {
        return mDescricao;
    }

    public void setmDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }

    public String getmMediaAvaliacoes() {
        return mMediaAvaliacoes;
    }

    public void setmMediaAvaliacoes(String mMediaAvaliacoes) {
        this.mMediaAvaliacoes = mMediaAvaliacoes;
    }

    public String getmGaleria() {
        return mGaleria;
    }

    public void setmGaleria(String mGaleria) {
        this.mGaleria = mGaleria;
    }

    public Endereco getmEndereco() {
        return mEndereco;
    }

    public void setmEndereco(Endereco mEndereco) {
        this.mEndereco = mEndereco;
    }

    public ArrayList<Servico> getmServicos() {
        return mServicos;
    }

    public void setmServicos(ArrayList<Servico> mServicos) {
        this.mServicos = mServicos;
    }

    public ArrayList<Agenda> getmAgenda() {
        return mAgenda;
    }

    public void setmAgenda(ArrayList<Agenda> mAgenda) {
        this.mAgenda = mAgenda;
    }

    public ArrayList<Promocoes> getmPromocoes() {
        return mPromocoes;
    }

    public void setmPromocoes(ArrayList<Promocoes> mPromocoes) {
        this.mPromocoes = mPromocoes;
    }

    public ArrayList<Profissional> getmProfissionais() {
        return mProfissionais;
    }

    public void setmProfissionais(ArrayList<Profissional> mProfissionais) {
        this.mProfissionais = mProfissionais;
    }

    public ArrayList<String> getmAvaliacoes() {
        return mAvaliacoes;
    }

    public void setmAvaliacoes(ArrayList<String> mAvaliacoes) {
        this.mAvaliacoes = mAvaliacoes;
    }

    public void setmDataBase(DatabaseReference mDataBase) {
        this.mDataBase = mDataBase;
    }
}
