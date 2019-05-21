package util;

import model.ComplexNumber;
import model.PolarComplex;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.math3.util.ArithmeticUtils.gcd;

public final class SecondaryOperations {

    /**
     * Dado un índice, devuelve sus raíces primitivas de la unidad.
     *
     * @param index - índice natural.
     */
    public static List<ComplexNumber> primitiveRoots(int index) {
        ComplexNumber numberOne = new PolarComplex(1, 0);
        List<ComplexNumber> unityRoots = numberOne.roots(index);

        List<ComplexNumber> primitiveRoots = new ArrayList<ComplexNumber>();

        for (int k = 0; k < index; k++) {
            if (gcd(k, index) == 1) {
                ComplexNumber primitiveRoot = unityRoots.get(k);
                primitiveRoots.add(primitiveRoot);
            }
        }

        return primitiveRoots;
    }
}
