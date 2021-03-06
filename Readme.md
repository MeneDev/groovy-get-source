# Groovy Get-Source

[![CircleCI](https://circleci.com/gh/MeneDev/groovy-get-source/tree/master.svg?style=svg)](https://circleci.com/gh/MeneDev/groovy-get-source/tree/master)

This is a small AST transformation that allows you to get the source code of a Class at run-time.

## Example

```groovy
@SaveSource
class AClass {

    def getCode() {
        SourceCode sourceCode = this.class.getAnnotation(SourceCode)
        return sourceCode.value()
    }
}
```

## Usage
You can add a dependency to you build via jitpack.

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compile 'com.github.MeneDev:groovy-get-source:96746d39f3'
}
```

## Notes
This was created as an answer to the question [Source code of current file in Groovy
](https://stackoverflow.com/questions/49997140/source-code-of-current-file-in-groovy) on Stackoverflow.