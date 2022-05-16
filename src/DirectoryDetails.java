import java.util.ArrayList;

// TODO: Implement Composite (change this file).
public class DirectoryDetails extends FileDetails {
     ArrayList<FileDetails> theSons; //We'll use ArrayList for the sons


    public DirectoryDetails(String path, String name){
        super(path,name);
        theSons=new ArrayList<>();
    }
    public void addFile(FileDetails fileDetails){
        theSons.add(fileDetails);
    }

    public void accept (VisitorFile a)
    {
        //As we have learned - we will go over the boys and activate the accept function for each one
        for (FileDetails i : theSons)
        {
          i.accept(a);
        }
    }
}