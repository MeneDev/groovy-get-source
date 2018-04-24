@SaveSource
class RunMe {
    public static void main(String[] args) {
        def annotation = RunMe.getAnnotation(SourceCode)
        println annotation.source
    }
}
