package br.unitins.model;

public enum Tamanho {

    P(1,"P"), M(2,"M"), G(3,"G"), GG(4,"GG");

    private int id;
    private String label;

    private Tamanho(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Tamanho valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(Tamanho tamanho : Tamanho.values()) {
            if (id.equals(tamanho.getId()))
                return tamanho;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
    
}
