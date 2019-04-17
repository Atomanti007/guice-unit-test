import adapter.TestAdapter;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Main {

    @Inject
    private TestAdapter testAdapter;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        Main main = injector.getInstance(Main.class);

        System.out.println(main.testAdapter.get());
    }
}
