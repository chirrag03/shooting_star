package configs;

import java.util.concurrent.CompletableFuture;
import javax.inject.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.Logger;
import play.inject.ApplicationLifecycle;

@Singleton
public class Global {

    private static ApplicationContext ctx;
    private final ApplicationLifecycle appLifecycle;

    @Inject
    public Global(ApplicationLifecycle appLifecycle) {
        ctx = new AnnotationConfigApplicationContext(DataConfig.class, AppConfig.class);

        this.appLifecycle = appLifecycle;

        Logger.info("Global demo: Starting application");

        // When the application starts, register a stop hook with the
        // ApplicationLifecycle object. The code inside the stop hook will
        // be run when the application stops.
        appLifecycle.addStopHook(() -> {
            Logger.info("ApplicationTimer demo: Stopping application at ");
            return CompletableFuture.completedFuture(null);
        });
    }

    public static <A> A getBean(Class<A> clazz) {
        return ctx.getBean(clazz);
    }

}
