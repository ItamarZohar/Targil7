public class statistics implements VisitorFile{


      private int CForMp3(double n) {
          if (n > 1) {
              double n1 = n;
              while (n1 > 1) {
                  n1--;
              }
              if (n1 > 0.5) {
                  return (int) (n - n1);
              } else {
                  return (int) (n + n1);
              }
          }else if(n<1){if(n>0.5)return 1; else return 0;}
          else return 1;
      }








       //For a Txt file the number of words is calculated.
    @Override
    public void visit(TxtFileDetails a){    System.out.println("The file " +a.getName() +
            " contains " + a.getWords() + " words.");}
    //For an MP3 file we print the number of bits per second.
    @Override
    public void visit(Mp3FileDetails a){
          int ev =CForMp3(Math.round((double) a.getSize() / a.getLengthSec() * 1000000d) / 1000000d);

          System.out.println("The bitrate of " + a.getName() +
            " is " + ev  + " bytes per second.");}
    @Override
    //For a pptx file is considered the average size of a slide
    public void visit(PptxFileDetails a){
        float ev = a.getSize() / a.getSlides();
        System.out.println("The average slide size in Presentation " + a.getName() +
            " is " + a.getSize() / a.getSlides()+ ".");}
    @Override //For an html file the number of rows is considered
    public void visit(HtmlFileDetails a){  System.out.println("The file " + a.getName() +
            " contains " + a.getLines() + " lines.");}
    @Override
    public void visit(DocxFileDetails a){ System.out.println("The file " + a.getName() + " has an average of "
            + a.getWords() / a.getPages() +
            " words per page.");}
    @Override //For an ipg file we print the average of the bits per pixel (will be calculated as a division of the number of bits divided by the number of pixels)
    public void visit(JpgFileDetails a){

     int ev = CForMp3(Math.round((double) a.getSize() / (a.getWidth() *
             a.getHeight()) * 1000000d) / 1000000d);


        System.out.println("The picture " + a.getName() + " has an average of " +
            ev  + " bytesh per pixel.");}
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


