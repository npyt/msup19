package backend.operation;

import backend.model.ComplexNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RootsParameterReference extends ParameterReference {

    private List<ComplexNumber> roots = new ArrayList<>();

    public RootsParameterReference(String parameterName) {
        super(parameterName);
    }

    public void setRoots(List<ComplexNumber> roots) {
        this.roots = roots;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        Iterator iterator = this.roots.iterator();
        while(iterator.hasNext()) {
            ComplexNumber root = (ComplexNumber) iterator.next();
            builder.append(root.toString());
            if(iterator.hasNext()) {
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public List<ComplexNumber> getRoots() {
        return roots;
    }
}
