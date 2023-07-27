public class GenericExample<T extends String, V extends String>{
    private T generic;
    private V generic2;

    public GenericExample(T generic, V generic2) {
        this.generic = generic;
        this.generic2 = generic2;
    }
    public void showType() {
        System.out.println(generic.getClass().getName().toString());
        // We can't use for example .substring()
        // since <T> can be anything.
    }
    public T getGeneric() {
        return generic;
    }

    public void showMoreLength(){
        if ( this.generic.length()> this.generic2.length()){

        }else{

        }
    }

}
