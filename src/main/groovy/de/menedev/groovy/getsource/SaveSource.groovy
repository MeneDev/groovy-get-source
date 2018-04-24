package de.menedev.groovy.getsource

import org.codehaus.groovy.transform.GroovyASTTransformationClass

    import java.lang.annotation.ElementType
    import java.lang.annotation.Retention
    import java.lang.annotation.RetentionPolicy
    import java.lang.annotation.Target

@Target([ElementType.TYPE])
@Retention(RetentionPolicy.CLASS)
@GroovyASTTransformationClass(classes = [SaveSourceASTTransformation])
public @interface SaveSource {}