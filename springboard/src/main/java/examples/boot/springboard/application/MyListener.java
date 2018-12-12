package examples.boot.springboard.application;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class MyListener
        implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent
                                               applicationStartedEvent) {
        System.out.println("------ my application start -----");
    }
}
