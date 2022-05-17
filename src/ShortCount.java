public class ShortCount implements VisitorFile{
//The visit function in each will be to print his name as required
    @Override
    public void visit(TxtFileDetails a){System.out.println(a.getName());}
    @Override
    public void visit(Mp3FileDetails a){System.out.println(a.getName());}
    @Override
    public void visit(PptxFileDetails a){System.out.println(a.getName());}
    @Override
    public void visit(HtmlFileDetails a){System.out.println(a.getName());}
    @Override
    public void visit(DocxFileDetails a){System.out.println(a.getName());}
    @Override
    public void visit(JpgFileDetails a){System.out.println(a.getName());}

}
