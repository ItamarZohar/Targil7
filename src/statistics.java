public class statistics implements VisitorFile{

       //For a Txt file the number of words is calculated.
    @Override
    public void visit(TxtFileDetails a){    System.out.println("The file " +a.getName() +
            " contains " + a.getWords() + " words.");}
    //For an MP3 file we print the number of bits per second.
    @Override
    public void visit(Mp3FileDetails a){    System.out.println("The bitrate of " + a.getName() +
            " is " + Math.round((double) a.getSize() / a.getLengthSec() * 1000000d) / 1000000d  + " bytes per second.");}
    @Override
    //For a pptx file is considered the average size of a slide
    public void visit(PptxFileDetails a){  System.out.println("The average slide size in Presentation " + a.getName() +
            " is " + String.format("%.6f", a.getSize() / a.getSlides()) + ".");}
    @Override //For an html file the number of rows is considered
    public void visit(HtmlFileDetails a){  System.out.println("The file " + a.getName() +
            " contains " + a.getLines() + " lines.");}
    @Override
    public void visit(DocxFileDetails a){ System.out.println("The file " + a.getName() + " has an average of "
            + String.format("%.6f", a.getWords() / a.getPages()) +
            " words per page.");}
    @Override //For an ipg file we print the average of the bits per pixel (will be calculated as a division of the number of bits divided by the number of pixels)
    public void visit(JpgFileDetails a){   System.out.println("The picture " + a.getName() + " has an average of " +
            Math.round((double) a.getSize() / (a.getWidth() *
                    a.getHeight()) * 1000000d) / 1000000d   + " bits per pixel.");}
    @Override //For a folder - consider the number of files in it - including a deep search. That is, we go into all the levels of recruiting and recalculate the number of files that appear there.
    public void visit(DirectoryDetails a) {    int myCount = 0;
        System.out.println("Directory " + a.getName() +
                " has " + mySumFunc(a, myCount) + " files.");
    }
 //This is a function that actually performs the recursion and counts in depth how many files exist in the folder
private int mySumFunc(DirectoryDetails directoryDetails, int sum)
        {
        for (FileDetails f : directoryDetails.theSons) {
        if(f instanceof DirectoryDetails)
        {
        sum = mySumFunc((DirectoryDetails) f,sum);
        }
        else
        {
        sum++;
        }
        }
        return sum;
        }
}


