package StructuralDesignPatterns;

interface Image{
    public void display();
}

class RealImage implements Image{
    private String fileName;
    public RealImage(String fileName){
        this.fileName=fileName;
        loadFileFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying loaded file");
    }

    private void loadFileFromDisk(String fileName){
        System.out.println("Loading "+fileName+" Disk");
    }
}


class ProxyImage implements Image{
    Image image;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName=fileName;
    }
    @Override
    public void display() {
        if (image==null){
            image=new RealImage(fileName);
        }
        image.display();
    }
}
public class ProxyPattern2 {
    public static void main(String[] args) {
        Image image = new ProxyImage("TestImage");
        // Loaded from Disk
        image.display();
        // Not Loaded from Disk
        image.display();
    }
}
