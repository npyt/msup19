package backend.form;

import backend.model.ComplexNumber;
import backend.operation.ParameterReference;
import backend.operation.RootsParameterReference;

import java.util.ArrayList;
import java.util.List;

public class RootsPolarComplexForm implements Form {
    @Override
    public Form getOpposite() {
        return new RootsRectangularComplexForm();
    }

    @Override
    public String parse(ParameterReference resultParameterReference) {
        List<ComplexNumber> roots = ((RootsParameterReference) resultParameterReference).getRoots();
        List<ComplexNumber> newRoots = new ArrayList<>();
        for(ComplexNumber root : roots) {
            newRoots.add(root.toPolar());

        }

        ((RootsParameterReference) resultParameterReference).setRoots(newRoots);
        return resultParameterReference.toString();
    }
}
