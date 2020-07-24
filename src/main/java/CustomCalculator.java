public class CustomCalculator {
    public int added(int valueNum1, int valueNum2){
        //Refactor -> Rename
        //이 메소드가 참조되는 모든 곳의 이름을 모두 바꿔줌
        return valueNum1 + valueNum2;
    }

    public int subtract(int valueNum1, int valueNum2){
        return valueNum1 - valueNum2;
    }

    public int multiply(int valueNum1, int valueNum2){
        return valueNum1 * valueNum2;
    }

    public int divide(int valueNum1, int valueNum2){
        return valueNum1 / valueNum2;
    }
}
