package ar.edu.ort.tp1.parcial2.clases;

public class Titere extends Juguete{

	private static final String MSG_TAMANIO_INVALIDO = "Tamanio de titere invalido.";
	private static final String MSG_TITERE ="El titere cuesta %.2f tiene un tamanio de %d cm es de la marca %s y tiene un id %d\n";
	private static final int TAM_MIN = 30;
	private static final int TAM_MAX = 70;
	private int tamanio;
	
	public Titere(int id, String marca, int tamanio, float precio) {
		super(id, marca, precio);
		setTamanio(tamanio);
	}

	private void setTamanio(int tamanio) {
		if(tamanio < TAM_MIN || tamanio > TAM_MAX) {
			throw new RuntimeException(MSG_TAMANIO_INVALIDO);
		}
		this.tamanio = tamanio;
	}

	@Override
	public void mostrar() {
		System.out.printf(MSG_TITERE, getPrecio(), this.tamanio, getMarca(), getId());
	}

	@Override
	public int getIdx() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	
}
