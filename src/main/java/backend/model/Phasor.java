package backend.model;

public class Phasor {

    /*
    Para el cálculo de suma o resta de Fasores se deberán ingresar dos funciones
    y para cada función sinusoidal su amplitud, frecuencia y fase.
    Se deberá mostrar en pantalla el resultado de la suma de ambas funciones.
    Para facilitar el ingreso de datos se aconseja realizar una consulta al usuario
    por etapas, preguntando si la función es un seno o un coseno,
    luego su frecuencia, su fase y por último su amplitud.
    */
    public enum TrigFun {
        SIN, COS
    }

    ;

    private double frecuencia;
	private double fase;
    private double amplitud;
    private TrigFun funcion;

    public Phasor(double amplitud, TrigFun funcion, double frecuencia, double fase) {
        this.frecuencia = frecuencia;
        this.fase = fase;
        this.amplitud = amplitud;
        this.funcion = funcion;
    }

    void toSIN() {
        if (this.funcion == TrigFun.COS) {
            this.fase = (Math.PI / 2.0) - this.fase;
            this.funcion = TrigFun.SIN;
        }
    }

    void toCOS() {
        if (this.funcion == TrigFun.SIN) {
            this.fase =  (Math.PI / 2.0) - this.fase;
            this.funcion = TrigFun.COS;
        }
    }

    PolarComplex toPolar() {
        return new PolarComplex(amplitud, fase);
    }

    RectangularComplex toRectangular() {
        return this.toPolar().toRectangular(); //xd
    }


    public Phasor add(Phasor otroFasor) throws PhasorOperationException {
    	if (this.frecuencia != otroFasor.frecuencia) {
    		throw new PhasorOperationException("Los dos fasores deben tener la misma frecuencia para sumarlos");
    	}

    	if (this.funcion != otroFasor.funcion) {
    		this.toCOS();
    		otroFasor.toCOS();
    	}


        //los paso a binomica y sumamos
        ComplexNumber sumaDeBinomicos =
        		this.toRectangular()
        		.add(otroFasor.toRectangular());

        //lo paso a exponencial
         PolarComplex polar = sumaDeBinomicos.toPolar();

        return new Phasor(polar.getModulus(), TrigFun.SIN, this.frecuencia, polar.getArgument());
    }

    Boolean equals(Phasor otroFasor) {
    	this.toSIN();
    	otroFasor.toSIN();

    	return this.amplitud == otroFasor.amplitud &&
    			this.fase == otroFasor.fase &&
    			this.frecuencia == otroFasor.frecuencia;
    }

    public String toString() {
    	String signo = "+";
    	if(this.fase<0) {signo = "";}
        return String.valueOf(this.amplitud) +
        		String.valueOf(this.funcion) +
        		"("+ this.frecuencia+"t"+signo+this.fase+")";
    }


    //Getters y Setters

    public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}

	public double getFase() {
		return fase;
	}

	public void setFase(double fase) {
		this.fase = fase;
	}

	public double getAmplitud() {
		return amplitud;
	}

	public void setAmplitud(double amplitud) {
		this.amplitud = amplitud;
	}

	public TrigFun getFuncion() {
		return funcion;
	}

	public void setFuncion(TrigFun funcion) {
		this.funcion = funcion;
	}



// f(t) = A.sen(w t + faseInicial)
// w = 2 pi frecuencia


}
