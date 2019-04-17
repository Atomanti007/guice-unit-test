import com.google.inject.AbstractModule;
import service.TestService;
import service.impl.TestServiceImpl;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TestService.class).to(TestServiceImpl.class);
    }
}
