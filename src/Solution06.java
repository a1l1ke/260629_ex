public class Solution06 {
    public static void main(String[] args) {
        runOld();
    }

    static void runOld() {
        CustomPrinter printer = new CustomPrinter() {
            @Override
            public void print(String msg) {
                System.out.println("익명 클래스에서 %s".formatted(msg));
            }
        };
        printer.print("Hello");
    }
}

@FunctionalInterface // implements하지 않아도 해당 메서드에 대한 구현을 익명함수로 직접해도 인스턴화 가능
interface CustomPrinter {
    void print(String msg);
}