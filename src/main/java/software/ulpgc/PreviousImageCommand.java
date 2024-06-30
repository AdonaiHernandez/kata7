package software.ulpgc;

public class PreviousImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    protected PreviousImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().prevImage());
    }

}
