public class sizeCalculator implements VisitorFile{
    int count;
    public int getCount(){return count;}

    @Override
    public void visit(TxtFileDetails a){count+=a.getSize();}
    @Override
    public void visit(Mp3FileDetails a){count+=a.getSize();}
    @Override
    public void visit(PptxFileDetails a){count+=a.getSize();}
    @Override
    public void visit(HtmlFileDetails a){count+=a.getSize();}
    @Override
    public void visit(DocxFileDetails a){count+=a.getSize();}
    @Override
    public void visit(JpgFileDetails a){count+=a.getSize();}
    @Override
    public void visit(DirectoryDetails directoryDetails) {

    }
}
