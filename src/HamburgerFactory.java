
public class HamburgerFactory {

    public static Hamburger createHamburger(String code){

        if (code == null) {
            throw new RuntimeException("wrong Hamburger");
        }
        if (code.equalsIgnoreCase("cl")) {
                return new ClassicHamburger();

        } else if (code.equalsIgnoreCase("sp")) {
            return new SpicyHamburger();

        } else if (code.equalsIgnoreCase("la")) {
            return new LambHamburger();

        } else if (code.equalsIgnoreCase("hla")) {
            return new HomemadeHamburger();
        }
        else
            throw new RuntimeException("wrong Hamburger");
    }
    }


