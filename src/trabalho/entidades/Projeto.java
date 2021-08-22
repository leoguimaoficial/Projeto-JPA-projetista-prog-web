package trabalho.entidades;

import javax.persistence.*;

@Entity
@Table(name = "tb_projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
private String nome;
    
    @Column(nullable = false)
private String descricao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Projeto(String nome, String descricao, Pessoa pessoa) {
        this.nome = nome;
        this.descricao = descricao;
        this.pessoa = pessoa;
    }

    public Projeto() {
    }

    public Projeto(long id, String nome, String descricao, Pessoa pessoa) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.pessoa = pessoa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projeto)) return false;

        Projeto projeto = (Projeto) o;

        return getId() == projeto.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
