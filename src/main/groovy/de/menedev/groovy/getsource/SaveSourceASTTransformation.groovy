package de.menedev.groovy.getsource

import groovy.transform.CompileStatic
    import org.codehaus.groovy.ast.ASTNode
    import org.codehaus.groovy.ast.AnnotationNode
    import org.codehaus.groovy.ast.ClassNode
    import org.codehaus.groovy.ast.expr.ConstantExpression
    import org.codehaus.groovy.control.CompilePhase
    import org.codehaus.groovy.control.SourceUnit
    import org.codehaus.groovy.transform.ASTTransformation
    import org.codehaus.groovy.transform.GroovyASTTransformation

@CompileStatic
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class SaveSourceASTTransformation implements ASTTransformation {

    @Override
    void visit(ASTNode[] nodes, SourceUnit sourceUnit) {
        if (nodes.length < 2) {
            return
        }
        if (!(nodes[0] instanceof AnnotationNode)) {
            return
        }
        if (!(nodes[1] instanceof ClassNode)) {
            return
        }
        def classNode = nodes[1] as ClassNode

        def annotationNode = new AnnotationNode(new ClassNode(SourceCode))
        def sourceCode = sourceUnit.source.reader.text
        annotationNode.addMember("value", new ConstantExpression(sourceCode))
        classNode.addAnnotation(annotationNode)
    }
}
