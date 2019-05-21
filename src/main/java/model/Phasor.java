package model;

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

    public Phasor(double frecuencia, double fase, double amplitud, TrigFun funcion) {
        this.frecuencia = frecuencia;
        this.fase = fase;
        this.amplitud = amplitud;
        this.funcion = funcion;
    }

    void toSIN() {
        if (this.funcion == TrigFun.COS) {
            this.fase -= (Math.PI / 2);
            this.funcion = TrigFun.SIN;
        }
    }

    void toCOS() {
        if (this.funcion == TrigFun.SIN) {
            this.fase += (Math.PI / 2);
            this.funcion = TrigFun.COS;
        }
    }

    PolarComplex toPolar() {
        return new PolarComplex(amplitud, fase);
    }

    Phasor add(Phasor otroFasor) {
        this.toSIN();
        otroFasor.toSIN();

        //los paso a polares y lo sumo
        PolarComplex sumaDePolares = this.toPolar()
                .add(otroFasor.toPolar())
                .toPolar();

        return new Phasor(this.frecuencia, sumaDePolares.getArgument(), sumaDePolares.getModulus(), TrigFun.SIN);
    }


// f(t) = A.sen(w t + faseInicial)
// w = 2 pi frecuencia


}
