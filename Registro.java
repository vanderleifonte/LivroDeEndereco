public class Registro implements Serializable {
    
    public Registro() {
    }

    /**
     * Armazena o valor da propriedade nome.
     */
    private String nome;

    /**
     * Getter para a propriedade nome.
     * @return Value of property nome.
     */
    public String getNome() {

        return this.nome;
    }

    /**
     * Setter para a propriedade nome.
     * @param nome Novo valor da propriedade nome.
     */
    public void setNome(String nome) {

        this.nome = nome;
    }

    /**
     * Armazena o valor da propriedade telefone.
     */
    private String telefone;

    /**
     * Getter para a propriedade telefone.
     * @return Value of property telefone.
     */
    public String getTelefone() {

        return this.telefone;
    }

    /**
     * Setter para a propriedade telefone.
     * @param telefone Novo valor da propriedade telefone.
     */
    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }

    /**
     * Armazena o valor da propriedade endereco.
     */
    private String endereco;

    /**
     * Getter para a propriedade endereco.
     * @return Value of property endereco.
     */
    public String getEndereco() {

        return this.endereco;
    }

    /**
     * Setter para a propriedade endereco.
     * @param endereco Novo valor da propriedade endereco.
     */
    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }
    
}
