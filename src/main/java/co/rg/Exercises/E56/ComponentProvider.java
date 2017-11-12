package co.rg.Exercises.E56;

import co.rg.random.generation.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class ComponentProvider {

    NumberGenerator lifetimeGenerator;

    public ComponentProvider(NumberGenerator lifetimeGenerator) {
        this.lifetimeGenerator = lifetimeGenerator;
    }

    public Component getNewComponent() throws ComponentProviderException {

        if (!lifetimeGenerator.hasNextValue())
            throw new ComponentProviderException( "There are no more components in stock" );
        return new Component( lifetimeGenerator.nextValue() );
    }

    public List<Component> getNewComponents(int quantity) throws ComponentProviderException{
        List<Component> components = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            components.add(getNewComponent());
        }
        return components;
    }
}
