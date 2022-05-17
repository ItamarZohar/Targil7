public  abstract class TheDec implements Hamburger{
     Hamburger i;
    public TheDec(Hamburger j){i=j;}

    @Override
    public String serve() {
       return i.serve();
    }
}
