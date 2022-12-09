package User;

public class PremiumUserEntity extends IUserEntity {
    String creditCard;
    PremiumUserEntity() {
        isPrem=true;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
