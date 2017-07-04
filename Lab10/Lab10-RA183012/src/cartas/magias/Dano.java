package cartas.magias;

import java.io.IOException;
import java.util.UUID;

import InterfacesLaMa.ILaMaSeriazable;
import cartas.*;
import io.Escritor;

public class Dano extends Magia implements ILaMaSeriazable{

    private int dano;

    public Dano(){}

    public Dano(String nome, int custoMana, int dano) {
        this(UUID.randomUUID(), nome, custoMana, dano);
    }

    public Dano(UUID id, String nome, int custoMana, int dano) {
        super(id, nome, custoMana);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    @Override
    public void usar(Carta alvo) {
        Lacaio lacaio = (Lacaio) alvo;
		int novoValor = lacaio.getVidaAtual() - this.getDano();
		novoValor = (novoValor > 0) ? novoValor : 0;
		lacaio.setVidaAtual(novoValor);
    }

    @Override
    public void escreveArquivo(Escritor escritor) throws IOException {
        escritor.escreveDelimObj("Dano");
        escritor.escreveAtributo("id", getId().toString());
        escritor.escreveAtributo("nome", getNome());
        escritor.escreveAtributo("custoMana", (new Integer(getCustoMana())).toString());
        escritor.escreveAtributo("dano", (new Integer(getDano())).toString());
        escritor.escreveDelimObj("Dano");
        escritor.finalizar();
    }
}
