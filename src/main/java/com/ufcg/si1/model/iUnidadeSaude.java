package com.ufcg.si1.model;

import java.util.List;

public interface iUnidadeSaude {

    public void addQueixa(long id);

    public String getDescricao();

    public void setDescricao(String descricao);

    public List<Especialidade> getEspecialidades();

    public void adicionarEspecialidade(Especialidade esp);

    public int getCodigo();

    public void setCodigo(int cod);
}
