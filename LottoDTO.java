public class LottoDTO {
    // Field
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    int num6;

    // Constructor
    LottoDTO(){}

    LottoDTO(int num1, int num2, int num3, int num4, int num5, int num6){
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
    }

    @Override
    public String toString(){
        return "선택한 로또 번호 : [" + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + ", " + num6 + "] ";
    }
}
