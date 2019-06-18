package backend.operation;

public abstract class ParameterReference {
    protected String name;
    public ParameterReference(String parameterName) {
        this.name = parameterName;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public abstract String toString();
}
