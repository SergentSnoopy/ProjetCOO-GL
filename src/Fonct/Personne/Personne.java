package Fonct.Personne;

public abstract class Personne {
    private String cardNumber;

    public Personne() {

    }

    public Personne(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
