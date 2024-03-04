// Mind the dust; Not enough time to finish
// Was attempting to make a sort of animated sprite effect
// Needed to work properly
public class Parameters {
    private int noFrames;
    public int getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(int framerate){
        frameRate = framerate;
    }
    public int getNoFrames(){
        return noFrames;
    }
    public void setNoFrames(int numFrames)
    {
        noFrames = numFrames;
    }
    private int frameRate;
    public int[] coordinates;
}
