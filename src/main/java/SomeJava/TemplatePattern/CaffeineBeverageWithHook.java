package SomeJava.TemplatePattern;

public abstract class CaffeineBeverageWithHook {
    public final void prepare() {
        boilWater();
        brew();
        pourIntoCup();
        if (customerWantsCondiments())
            addCondiments();
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourIntoCup() {
        System.out.println("Pouring into cup");
    }

    abstract void brew();

    abstract void addCondiments();

    boolean customerWantsCondiments() {
        return true;
    }
}
