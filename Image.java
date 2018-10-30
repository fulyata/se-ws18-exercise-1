import java.io.*;
public class Image {
    public byte[] data;
    private int width;
    private int height;
    
    public Image (int width, int height) {
	this.width = width;
	this.height = height;
	data = new byte[3 * width * height];
    }
    
    public void set(int x, int y, int val) {
	assert (val < 0x1000000); // max color = 0xFFFFFF
	int offset = ((y * width + x) * 3);
	// split the 4 byte integer into its rgb parts using
	// bit masking (&) and bit shifting (>>)
	data[offset]     = (byte)((val & 0xFF0000) >> 16);
	data[offset + 1] = (byte)((val & 0xFF00) >> 8);
	data[offset + 2] = (byte)(val & 0xFF);
    }
    
    public void write(String filename) throws IOException {
	FileOutputStream outputStream = new FileOutputStream(filename);
	String header = String.format("P6 %d %d %d\n", width, height, 255);
	outputStream.write(header.getBytes());
	for (int i = 0; i < data.length; i++) {
	    outputStream.write(data[i]);
	}
	outputStream.close();
    }
}
