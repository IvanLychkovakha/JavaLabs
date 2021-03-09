package Task1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Function {
    private double a;
    private double b;
    private String sourceFileF = "C:\\Users\\Ivan\\IdeaProjects\\ЛАБ№4ООП\\src\\Task1\\FX";
    private String sourceFileG = "C:\\Users\\Ivan\\IdeaProjects\\ЛАБ№4ООП\\src\\Task1\\GX";
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void genSourceF(String expression, int number) {
        try (PrintWriter out = new PrintWriter(sourceFileF + number + ".java")) {
            out.println("package Task1;");
            out.println("public class FX" + number +" {");
            out.println("    public static double transform(double x) {");
            out.println("        return " + expression + ";");
            out.println("    }");
            out.println("}");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void genSourceG(String expression, int number) {
        try (PrintWriter out = new PrintWriter(sourceFileG + number + ".java")) {
            out.println("package Task1;");
            out.println("public class GX" + number +" {");
            out.println("    public static double transform(double x) {");
            out.println("        return " + expression + ";");
            out.println("    }");
            out.println("}");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean compileF(int number) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        return compiler.run(null, null, null, sourceFileF + number + ".java") == 0;
    }

    public boolean compileG(int number) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        return compiler.run(null, null, null, sourceFileG + number + ".java") == 0;
    }
}
