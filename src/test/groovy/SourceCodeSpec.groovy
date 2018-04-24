import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import spock.lang.Specification

class SourceCodeSpec extends Specification {

    def "non-empty Generator can create objects when @CompileStatic"() {
        given:
        def script = """
    @SaveSource
    class AClass {

        def getCode() {
            def annotation = this.class.annotations
            SourceCode sourceCode = this.class.getAnnotation(SourceCode)
            return sourceCode.value()
        }
    }

    new AClass().getCode()
        """
        GroovyShell shell = createShell()

        when:
        Script s = shell.parse(script)

        def res = s.run()
        then:
        res == script
    }

    private GroovyShell createShell() {
        def configuration = new CompilerConfiguration()
        def importCustomizer = new ImportCustomizer()
        importCustomizer.addImports(SaveSource.canonicalName)
        importCustomizer.addImports(SourceCode.canonicalName)

        configuration.addCompilationCustomizers(importCustomizer)
        def shell = new GroovyShell(new Binding(), configuration)
        shell
    }
}
