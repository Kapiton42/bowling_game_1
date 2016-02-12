package bowling.Entities;


public class Roll {

    public int Knocked;
    public int PosInFrame;

    public Roll(int Knocked) {
        this.Knocked = Knocked;
    }

    public static Roll createRoll(int Knocked) {
        return new Roll(Knocked);
    }

    public Roll setPosition(int Pos) {
        PosInFrame = Pos;
        return this;
    }

    @Override
    public String toString() {
        return "Roll{" + Knocked +'}';
    }
}
