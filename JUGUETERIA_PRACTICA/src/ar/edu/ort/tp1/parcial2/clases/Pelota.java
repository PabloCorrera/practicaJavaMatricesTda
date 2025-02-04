package ar.edu.ort.tp1.parcial2.clases;

public class Pelota extends Juguete{
	
	private static final String LA_SUPERFICIE_NO_PUEDE_SER_NULA = "La superficie no puede ser nula";
	private static final String MSG_PELOTA = "La pelota cuesta %.2f pesos, es del tipo %s ademas es de la marca %s y tiene un id %d\n";
	private TipoDePelota tipoPelota;
	
	public Pelota(int id, String marca, TipoDePelota tipoPelota, float precio) {
		super(id, marca, precio);
		setTipoPelota(tipoPelota);
	}

	private void setTipoPelota(TipoDePelota tipoPelota) {
		if(tipoPelota == null) {
			throw new RuntimeException(LA_SUPERFICIE_NO_PUEDE_SER_NULA);
		}
		this.tipoPelota = tipoPelota;
	}

	@Override
	public void mostrar() {
		System.out.printf(MSG_PELOTA, getPrecio(), this.tipoPelota, getMarca(), getId());
	}

	@Override
	public int getIdx() {
		return 2;
	}
	
	
	

}
