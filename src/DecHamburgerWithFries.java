public class DecHamburgerWithFries extends TheDec{
    public DecHamburgerWithFries(Hamburger i){super(i);}

    @Override
    public String serve() {
        return super.serve() + " with chips";
    }
}
