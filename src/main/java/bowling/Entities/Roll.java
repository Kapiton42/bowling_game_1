package bowling.Entities;


public class Roll {
/*возможно, есть смысл сделать эту переменную приватной*/
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
