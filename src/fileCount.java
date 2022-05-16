public class fileCount implements VisitorFile{
    int count=0;
    public int getCount(){return count;};
    //We will start each visit function so that each visit will add one
    @Override
    public void visit(TxtFileDetails a){count++;}
    @Override
    public void visit(Mp3FileDetails a){count++;}
    @Override
    public void visit(PptxFileDetails a){count++;}
    @Override
    public void visit(HtmlFileDetails a){count++;}
    @Override
    public void visit(DocxFileDetails a){count++;}
    @Override
    public void visit(JpgFileDetails a){count++;}

}
