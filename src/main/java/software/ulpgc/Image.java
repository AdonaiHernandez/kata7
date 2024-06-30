package software.ulpgc;

public interface Image {
    String name();
    Image nextImage();
    Image prevImage();
}
