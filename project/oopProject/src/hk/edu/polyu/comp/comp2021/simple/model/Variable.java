package hk.edu.polyu.comp.comp2021.simple.model;

/**
 * @param <T> a generic type for variable storage
 */
public class Variable<T> {
    private T value;

    /**
     * @param value the value of the variable
     */
    Variable(T value){
        this.value = value;
    }

    /**
     * @return get the value of the variable
     */
    public T getvalue() {
        return this.value;
    }

}
