package de.menedev.groovy.getsource

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Retention(RetentionPolicy.RUNTIME)
@interface SourceCode {
    String value()
}