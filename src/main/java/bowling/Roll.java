package bowling;


public class Roll {

    public int Knocked;

    public Roll(int Knocked) {
        this.Knocked = Knocked;
    }

    public static Roll createRoll(int Knocked) {
        return new Roll(Knocked);
    }

    @Override
    public String toString() {
        return "Roll{" + Knocked +'}';
    }
}
