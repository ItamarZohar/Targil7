public class DecHamburgerWithOnionRings extends TheDec{
  public DecHamburgerWithOnionRings(Hamburger i){super(i);}

    @Override
    public String serve() {
        return super.serve() + " with onion rings";
    }
}
