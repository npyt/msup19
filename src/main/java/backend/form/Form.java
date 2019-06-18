package backend.form;


import backend.operation.ParameterReference;

public interface Form {
    Form getOpposite();

    String parse(ParameterReference resultParameterReference);
}
