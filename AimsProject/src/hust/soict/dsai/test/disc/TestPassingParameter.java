package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
    	//No wrapper
    	System.out.println("Swap normally: ");
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        
        //Wrapper
        changeTitle(jungleDVD, "Jungle"); //swap the title back
        System.out.println("Swap correctly: ");
        
        ObjectWrapper jungleDVDWrapper = new ObjectWrapper(jungleDVD);
        ObjectWrapper cinderellaDVDWrapper = new ObjectWrapper(cinderellaDVD);
        
        swap(jungleDVDWrapper, cinderellaDVDWrapper);
        System.out.println("jungle dvd title: " + ((DigitalVideoDisc) jungleDVDWrapper.object).getTitle());
        System.out.println("cinderella dvd title: " + ((DigitalVideoDisc) cinderellaDVDWrapper.object).getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    //swap() that correctly swaps objects
    public static void swap(ObjectWrapper o1, ObjectWrapper o2) {
    	Object temp = o1.object;
        o1.object = o2.object;
        o2.object = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}