package trabalho.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-10-28T18:59:44.740-0300")
@StaticMetamodel(Projeto.class)
public class Projeto_ {
	public static volatile SingularAttribute<Projeto, Long> id;
	public static volatile SingularAttribute<Projeto, String> nome;
	public static volatile SingularAttribute<Projeto, String> descricao;
	public static volatile SingularAttribute<Projeto, Pessoa> pessoa;
}
