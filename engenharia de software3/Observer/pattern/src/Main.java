public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        Roles promotionsCodes = new Roles("PromotionCodes", "A new code for Steam has appear");
        UserAllowMention dkaii = new UserAllowMention(promotionsCodes);
        promotionsCodes.addObserver(dkaii);
        promotionsCodes.setMessage("A new code for Steam has appear. WoW promocode 20%: JDSHKJSNDNVUHDS08");





    }
}