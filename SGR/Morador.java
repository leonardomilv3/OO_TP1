<<<<<<< Updated upstream:SGR/Morador.java
package SGR;

public class Morador {
    private String nome;
    private String email;
    private float rendimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }
}
=======
package SGR;

public class Morador {
    private String nome;
    private String email;
    private float rendimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRendimento() {
        return this.rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }
}
>>>>>>> Stashed changes:Morador.java
