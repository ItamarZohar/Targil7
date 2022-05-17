public class DecHamburgerWithSalad extends TheDec{
    public DecHamburgerWithSalad(Hamburger i){super(i);}

    @Override
    public String serve() {
        return super.serve() + " with salad";
    }
}
