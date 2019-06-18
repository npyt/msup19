package backend.form;

import backend.model.ComplexNumber;
import backend.operation.ParameterReference;
import backend.operation.RootsParameterReference;

import java.util.ArrayList;
import java.util.List;

public class RootsRectangularComplexForm implements Form {

    @Override
    public Form getOpposite() {
        return new RootsPolarComplexForm();
    }

    @Override
    public String parse(ParameterReference resultParameterReference) {
        List<ComplexNumber> roots = ((RootsParameterReference) resultParameterReference).getRoots();
        List<ComplexNumber> newRoots = new ArrayList<>();
        for(ComplexNumber root : roots) {
            newRoots.add(root.toRectangular());

        }

        ((RootsParameterReference) resultParameterReference).setRoots(newRoots);
        return resultParameterReference.toString();
    }
}
