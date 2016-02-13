package bowling.Entities;


public class Roll {

    public int Knocked;

    private Roll(int Knocked) {
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
