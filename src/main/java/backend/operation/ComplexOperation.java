package backend.operation;

import backend.form.Form;
import backend.model.PhasorOperationException;

public abstract class ComplexOperation {

    Form form;

    public ComplexOperation(Form form) {
        this.form = form;
    }

    public void toggleForm() {
        this.form = this.form.getOpposite();
    }

    public abstract ParameterReference getFirstParameterReference();
    public abstract ParameterReference getSecondParameterReference();
    public abstract ParameterReference getResultParameterReference();

    public String getResultString() {
        try {
            return this.form.parse(this.getResultParameterReference());
        } catch (NullPointerException e) {
            return "";
        }
    }

    public abstract void operate() throws PhasorOperationException;

    public abstract String getName();
    public abstract char getOperatorChar();

    public String getFirstOperandName() {
        return this.getFirstParameterReference().getName();
    }
    public String getSecondOperandName() {
        return this.getSecondParameterReference().getName();
    }
}
