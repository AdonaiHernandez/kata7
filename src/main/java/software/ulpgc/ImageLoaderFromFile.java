package software.ulpgc;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Set;

public class ImageLoaderFromFile implements ImageLoader{

    private final File[] images;
    private final Set<String> extensions = new HashSet<>();

    public ImageLoaderFromFile(File folder){
        extensions.add(".jpg");
        extensions.add(".png");
        extensions.add(".jpeg");

        this.images = folder.listFiles(getImagesAtFolder());
    }

    private FilenameFilter getImagesAtFolder() {
        return (dir, name) -> extensions.stream().anyMatch(name::endsWith);
    }

    private Image imageAtIndex(int i){
        return new Image() {
            @Override
            public String name() {
                return images[i].getAbsolutePath();
            }

            @Override
            public Image nextImage() {
                if (images.length-1 == i){
                    return imageAtIndex(0);
                }

                return imageAtIndex(i+1);
            }

            @Override
            public Image prevImage() {
                if (i == 0){
                    return imageAtIndex(images.length-1);
                }
                return imageAtIndex(i-1);
            }
        };
    }

    @Override
    public Image load() {
        return imageAtIndex(0);
    }
}
