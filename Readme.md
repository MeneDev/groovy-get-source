# Groovy Get-Source

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

## Notes
This was created as an answer to the question [Source code of current file in Groovy
](https://stackoverflow.com/questions/49997140/source-code-of-current-file-in-groovy) on Stackoverflow.