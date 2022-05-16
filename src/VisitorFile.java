public interface VisitorFile {

    //We will create a visit function for each one
    void visit(DocxFileDetails a);
    void visit(Mp3FileDetails a);
    void visit(TxtFileDetails a);
    void visit(PptxFileDetails a);
    void visit(HtmlFileDetails a);
    void visit(JpgFileDetails a);
}
