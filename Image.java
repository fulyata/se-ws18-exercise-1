public class Image {
    private int width;
    private int height;
    // byte array
    public byte[] data;

    //constructor
    public Image(int width, int height) {
	this.width =  width;
	this.height = height;
	data = new byte[(width * height) * 3 ];
    }

    public void set(int x, int y, int val) {
	
    }
}
