package util;

import model.ComplexNumber;
import model.PolarComplex;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.math3.util.ArithmeticUtils.gcd;

public final class ComplexUtils {

    /**
     * Dado un índice, devuelve sus raíces primitivas de la unidad.
     *
     * @param index - índice natural.
     * @throws IllegalArgumentException si el índice es inválido.
     */
    public static List<ComplexNumber> primitiveRoots(int index) {
        if(index <= 0) {
            throw new IllegalArgumentException("Índice inválido: " + index);
        }

        ComplexNumber numberOne = new PolarComplex(1, 0);
        List<ComplexNumber> unityRoots = numberOne.roots(index);

        List<ComplexNumber> primitiveRoots = new ArrayList<ComplexNumber>();

        for (int k = 1; k < index; k++) {
            if (gcd(k, index) == 1) {
                ComplexNumber primitiveRoot = unityRoots.get(k);
                primitiveRoots.add(primitiveRoot);
            }
        }

        return primitiveRoots;
    }
}
