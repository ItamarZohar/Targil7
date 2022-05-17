public class DecHamburgerWithEggYolk extends TheDec {
    public DecHamburgerWithEggYolk(Hamburger i){super(i);}

    @Override
    public String serve() {
        return super.serve() + " with fried egg";
    }
}
