package backend.operation;

public class NaturalParameterReference extends ParameterReference {

    private int value = 1;

    public NaturalParameterReference(String parameterName) {
        super(parameterName);
    }

    public boolean update(int input) {
        if(input < 0) {
            return false;
        }

        this.setValue(input);
        return true;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    public void setValue(int input) {
        this.value = input;
    }

    public String getLabelName() {
        return this.name.substring(0, 1).toUpperCase() + this.name.substring(1) + ":";
    }
}
