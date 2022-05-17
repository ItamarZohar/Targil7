public class HamburgerToppingFactory {
    public Hamburger GetTopping(String toppingType, Hamburger hamburger) {
        if (toppingType == null) {
            return null;
        }
        if (toppingType.equalsIgnoreCase("ch")) {
            return new DecHamburgerWithFries(hamburger);

        } else if (toppingType.equalsIgnoreCase("or")) {
            return new DecHamburgerWithOnionRings(hamburger);

        } else if (toppingType.equalsIgnoreCase("sa")) {
            return new DecHamburgerWithSalad(hamburger);

        } else if (toppingType.equalsIgnoreCase("fe")) {
            return new DecHamburgerWithEggYolk(hamburger);
        }
        else
            return null;
    }
}
