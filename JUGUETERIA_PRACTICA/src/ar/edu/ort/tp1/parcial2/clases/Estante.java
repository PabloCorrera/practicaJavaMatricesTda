package ar.edu.ort.tp1.parcial2.clases;

public class Estante implements ContenedorInteligente<Juguete, Integer> {
	
	private PilaDeJuguetes pilaJuguetes;
	private int profundidadEstanteria;
	private int capacidadActual;
	
	public Estante(int profundidadEstanteria) {
		this.pilaJuguetes = new PilaDeJuguetes();
		this.profundidadEstanteria = profundidadEstanteria;
	}

	public boolean hayLugar() {
		return capacidadActual < profundidadEstanteria;
	}

	@Override
	public void guardar(Juguete juguete) {
		if(!hayLugar()) {
			throw new RuntimeException("No hay capacidad suficiente para guardar este juguete");
		} else {
			pilaJuguetes.push(juguete);
			capacidadActual++;
		}
	}

	@Override
	public Juguete recuperarPorId(Integer id) {
		PilaDeJuguetes pilaAux = new PilaDeJuguetes();
		Juguete jugueteActual;
		Juguete jugueteBuscado = null;
		while(!pilaJuguetes.isEmpty()) {
			jugueteActual = pilaJuguetes.pop();
			pilaAux.push(jugueteActual);
			if(jugueteActual.getId() == id) {
				jugueteBuscado = jugueteActual;
			}
		}
		while(!pilaAux.isEmpty()) {
			pilaJuguetes.push(pilaAux.pop());
		}
		return jugueteBuscado;
	}

	
}
