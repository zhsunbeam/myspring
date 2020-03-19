package net.tomgo.customer.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxConditional implements Condition {
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean bool = conditionContext.getEnvironment().getProperty("os.name").contains("Linux");
        return bool;
    }
}
