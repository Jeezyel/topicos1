package br.unitins.model;

public enum TipoPagamento {
    PIX(1,"Pix"), BOLETO(2,"Boleto"), CARTAO_CREDITO(3,"Cartão_Credito");

    private int id;
    private String label;

    private TipoPagamento(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoPagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(TipoPagamento tipoPagamento : TipoPagamento.values()) {
            if (id.equals(tipoPagamento.getId()))
                return tipoPagamento;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
