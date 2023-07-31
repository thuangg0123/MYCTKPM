/*
*  created date: Jul 17, 2023
*  author: cgm
*/
package tuan7;

//MOdel - Entity
public class TempConverter extends Publisher {

    //fields
    private double cel;
    private double fah;

    //constructor
    public TempConverter(){}

    /**
     * @param cel
     * @param fah
     */
    public TempConverter(double cel, double fah) {
        this.cel = cel;
        this.fah = fah;
    }

    //methods
    public double c2f(){
        double fah;
        fah = 1.8 * (this.cel + 32);
        this.fah = fah;
        //THONG BAO DEN THANH VIEN DA DANG KY
        notifySubscribers();
        return fah;
    }

    public double f2c(){
        double cel;
        cel = 0.556 * (this.fah -32);
        this.cel  = cel;
        notifySubscribers();
        return cel;
    }

    /**
     * @param cel the cel to set
     */
    public void setCel(double cel) {
        this.cel = cel;
    }

    /**
     * @param fah the fah to set
     */
    public void setFah(double fah) {
        this.fah = fah;
    }

    public double getCel() {
        return cel;
    }

    public double getFah() {
        return fah;
    }
    
}
