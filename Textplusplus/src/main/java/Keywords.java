import java.util.Arrays;

public class Keywords {
    private  String[] keywordsC = {"auto", "break", "case", "char", "const", "continue", "default", "do", "double", "else",
            "enum", "extern", "float", "for", "goto", "if", "int", "long", "register", "return", "short", "signed",
            "sizeof", "static", "struct", "switch", "typedef", "union", "unsigned", "void", "volatile", "while"};


    private  String[] keywordsJava = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof",
            "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

    public Keywords(){
        this.keywordsC=keywordsC;
        this.keywordsJava=keywordsJava;
    }

    public String[] getKeywordsC() {
        return keywordsC;
    }


    public String[] getKeywordsJava() {
        return keywordsJava;
    }

    @Override
    public String toString() {
        return "Keywords{" +
                "keywordsC=" + Arrays.toString(keywordsC) +
                ", keywordsJava=" + Arrays.toString(keywordsJava) +
                '}';
    }
}
