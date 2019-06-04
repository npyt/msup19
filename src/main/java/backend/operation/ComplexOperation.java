package backend.operation;

import backend.model.ComplexNumber;

public interface ComplexOperation {

    ComplexNumber operate(ComplexNumber z1, ComplexNumber z2);
    String getName();
    char getOperatorChar();

    String getFirstOperandName();
    String getSecondOperandName();
}
