public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

    Roles steamPromocode = new Roles("PromotionCodes", "A new code for Steam has appear");
    UserWithRole dkaii = new  UserWithRole(steamPromocode);

    SteamPromocode newSteamPromocode = new SteamPromocode(steamPromocode);

    newSteamPromocode.update(steamPromocode);




    }
}