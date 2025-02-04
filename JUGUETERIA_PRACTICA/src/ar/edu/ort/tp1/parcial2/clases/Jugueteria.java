package ar.edu.ort.tp1.parcial2.clases;

public class Jugueteria implements ContenedorInteligente<Juguete, Integer> {

	private static final int ALTO_ESTANTERIA = 6;
	private static final int ANCHO_ESTANTERIA = 3;
	private static final int PROFUNDIDAD_ESTANTERIA = 4;
	private Estante[][] estanteria;
	private ListaDeJuguetesPorId juguetesGuardados;
	private float totalVentas; 
	
	public Jugueteria() {
		inicializarEstanteria();
		this.juguetesGuardados = new ListaDeJuguetesPorId();
		this.totalVentas = 0;
	}

	private void inicializarEstanteria() {
		this.estanteria = new Estante[ALTO_ESTANTERIA][ANCHO_ESTANTERIA];
		for (int i = 0; i < estanteria.length; i++) {
			for (int j = 0; j < estanteria[i].length; j++) {
				estanteria[i][j] = new Estante(PROFUNDIDAD_ESTANTERIA);
			}
			
		}
	}
	
	

	public void mostrarVentas() {
		System.out.println("El total de ventas fue de "+totalVentas);
		System.out.println("--------------------------------------------");
		
	}

	@Override
	public void guardar(Juguete juguete) {
		int idxJuguete = juguete.getIdx();
		int i = 0;
		Estante estanteActual;
		boolean hayLugar = false;
		while(i < ALTO_ESTANTERIA && !hayLugar) {
			estanteActual = estanteria[i][idxJuguete];
			hayLugar = estanteActual.hayLugar();
			if(hayLugar) {
			juguetesGuardados.add(juguete);
			estanteActual.guardar(juguete);
			} else {
				i++;
			}
		}
		if(!hayLugar) {
			throw new RuntimeException("Error depositando "+juguete.getClass().getSimpleName()+" No se pudo depositar el juguete");
		}
		
	}

	public boolean existeJuguete(int idJuguete) {
		return juguetesGuardados.exists(idJuguete);
	}
	@Override
	public Juguete recuperarPorId(Integer idJuguete) {
		Juguete jugueteBuscado = juguetesGuardados.removeByKey(idJuguete);
		if(jugueteBuscado != null) {
		sacarJugueteDeEstanteria(jugueteBuscado);
			totalVentas += jugueteBuscado.getPrecio();
		} 
		return jugueteBuscado;
		
	}

	private Juguete sacarJugueteDeEstanteria(Juguete juguete) {
		Juguete jugueteBuscado = null;
		if(juguete != null) {
			int idxJuguete = juguete.getIdx();
			int i = 0;
			while( i < ALTO_ESTANTERIA && jugueteBuscado == null) {
				jugueteBuscado = estanteria[i][idxJuguete].recuperarPorId(juguete.getId());
				if(jugueteBuscado == null) {
					i++;
				}
			}
		}
		
		return jugueteBuscado;
	}

	
}
