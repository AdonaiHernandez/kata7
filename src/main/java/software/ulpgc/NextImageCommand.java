package software.ulpgc;

public class NextImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    protected NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().nextImage());
    }
}
