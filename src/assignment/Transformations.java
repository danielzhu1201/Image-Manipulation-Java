package assignment;

/**
 *
 * CS314H Programming Assignment 1 - Java image processing
 * 
 * Included is the Invert effect from the assignment.  Use this as an
 * example when writing the rest of your transformations.  For
 * convenience, you should place all of your transformations in this file.
 *
 * You can compile everything that is needed with
 * javac -d bin src/assignment/*.java
 *
 * You can run the program with
 * java -cp bin assignment.JIP
 *
 * Please note that the above commands assume that you are in the prog1
 * directory.
 */


import java.util.ArrayList;


class Invert extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = ~pixels[y][x];
            }
        }
        return pixels;
    }
}

/**
 * @author Zhaosong Zhu
 * This class removes all red shades from the image.
 */
class NoRed extends ImageEffect{
	


	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels [y][x]= makePixel(0, getGreen(pixels[y][x]), getBlue(pixels[y][x]));
            }
        }

		return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * This class removes all green shades from the image
 */
class NoGreen extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels [y][x]= makePixel(getRed(pixels[y][x]), 0, getBlue(pixels[y][x]));
            }
        }

		return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * This class removes all red shades from the image
 */
class NoBlue extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels [y][x]= makePixel(getRed(pixels[y][x]), getGreen(pixels[y][x]), 0);
            }
        }

		return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * Preserve any red shades in the image, but remove all green and blue
 */
class RedOnly extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels [y][x]= makePixel(getRed(pixels[y][x]), 0, 0);
            }
        }

		return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * This class allows you to create better pictures with the optimized RedOnly method
 */
class OptimizedRedOnly extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	if(getRed(pixels[y][x])>=250 && getGreen(pixels[y][x])>=250 && getBlue(pixels[y][x])>=250)
            		System.out.println("Pixel Omitted.");
            	else
            		pixels [y][x]= makePixel(getRed(pixels[y][x]), 0, 0);
            }
        }

		return pixels;
	}
	
}



class GreenOnly extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels [y][x]= makePixel(0, getGreen(pixels[y][x]), 0);
            }
        }

		return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * This class allows you to create better pictures with the optimized GreenOnly method
 */

class OptimizedGreenOnly extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	if(getRed(pixels[y][x])>=250 && getGreen(pixels[y][x])>=250 && getBlue(pixels[y][x])>=250)
            		System.out.println("Pixel Omitted.");
            	else
            		pixels [y][x]= makePixel(0, getGreen(pixels[y][x]), 0);
            }
        }

		return pixels;
	}
	
}

class BlueOnly extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels [y][x]= makePixel(0, 0, getBlue(pixels[y][x]));
            }
        }

		return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * This class allows you to create better pictures with the optimized BlueOnly method
 */

class OptimizedBlueOnly extends ImageEffect{
	

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	if(getRed(pixels[y][x])>=250 && getGreen(pixels[y][x])>=250 && getBlue(pixels[y][x])>=250)
            		System.out.println("Pixel Omitted.");
            	else
            		pixels [y][x]= makePixel(0, 0, getBlue(pixels[y][x]));
            }
        }

		return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * Turn a color image into a black and white image.
 */
class BlackAndWhite extends ImageEffect{

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels [y][x]= makePixel((getRed(pixels[y][x])+ getBlue(pixels[y][x])+ getBlue(pixels[y][x]))/3,(getRed(pixels[y][x])+ getBlue(pixels[y][x])+ getBlue(pixels[y][x]))/3,(getRed(pixels[y][x])+ getBlue(pixels[y][x])+ getBlue(pixels[y][x]))/3);
            }
            
            
        }

		return pixels;
	
		
	}	
}


/**
 * @author Zhaosong Zhu
 * Reflect the image around a vertical line down the middle of the original image. If the
 * input image were a picture of your face, the output image would be what you see when you look in the mirror.
 */
class VerticalReflect extends ImageEffect{

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {

		int [][] verticalPixels = new int [pixels.length][pixels[0].length];
		
		int width = pixels[0].length;
        int height = pixels.length;
        
		for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	verticalPixels[y][x] = pixels [y][width-1-x];
            }
		}
		
		return verticalPixels;
	}
	
}



/**
 * @author Zhaosong Zhu
 * Reflect the image around a horizontal line across the middle of the original image. If
 * the input image were a picture of your face, the output image would be an upside-down picture of your face
 */
class HorizontalReflect extends ImageEffect{

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {

		int [][] verticalPixels = new int [pixels.length][pixels[0].length];
		
		int width = pixels[0].length;
        int height = pixels.length;
        
        for (int y = 0; y < height; y++) {
        	for (int x = 0; x < width; x++){
            	verticalPixels[y][x] = pixels [height-1-y][x];
            }
		}
		
		return verticalPixels;
	}
	
}



/**
 * @author Zhaosong Zhu
 * Reduce the number of colors used in the image from millions to eight, with a personalized threshold.
 */
class Threshold extends ImageEffect{
	
	public Threshold()
	{
		super();
        params = new ArrayList<ImageEffectParam>();
        params.add(new ImageEffectParam("Threshold","Enter a number between 0 to 255 for color threshold.",127, 0, 255));
	}

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		
		int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	pixels[y][x] = makePixel(changeColor(getRed(pixels[y][x])), changeColor(getGreen(pixels[y][x])), changeColor(getBlue(pixels[y][x])));
            }
        }
		
		return pixels;
	}
	
	public int changeColor (int pixel)
	{
		int threshold = params.get(0).getValue();
		if (pixel<threshold)
			return 0;
		else 
			return 255;
	}

}

/**
 * @author Zhaosong Zhu
 * Create an image that is twice as high and twice as wide as your original picture.
 */
class Grow extends ImageEffect {

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;
		int [][] grow = new int[height*2][width*2];

		
		 for (int x = 0; x < width*2; x++) {
	            for (int y = 0; y < height*2; y++) {
	            	grow[y][x] = pixels[y/2][x/2];
	            }
		 }
		
		
		return grow;
	}
	
	
}

/**
 * @author Zhaosong Zhu
 * Create an image that is half as high and half as wide as your original picture.
 */
class Shrink extends ImageEffect {

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		
		int width = pixels[0].length;
        int height = pixels.length;

        int [][] shrink = new int [height/2][width/2];
        
        if (height%2!=0)
        {
        	for (int x = 0; x < width-1; x=x+2) {
                for (int y = 0; y < height-2; y=y+2) {
                	int red = (getRed(pixels[y][x])+getRed(pixels[y+1][x])+getRed(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int green = (getGreen(pixels[y][x])+getGreen(pixels[y+1][x])+getGreen(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int blue = (getBlue(pixels[y][x])+getBlue(pixels[y+1][x])+getBlue(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	shrink [y/2][x/2]= makePixel(red, green, blue);
                }
            }
        }
        else if (width%2!=0) {
        	for (int x = 0; x < width-2; x=x+2) {
                for (int y = 0; y < height-1; y=y+2) {
                	System.out.println(y);
                	System.out.println(y+1);
                	int red = (getRed(pixels[y][x])+getRed(pixels[y+1][x])+getRed(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int green = (getGreen(pixels[y][x])+getGreen(pixels[y+1][x])+getGreen(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int blue = (getBlue(pixels[y][x])+getBlue(pixels[y+1][x])+getBlue(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	shrink [y/2][x/2]= makePixel(red, green, blue);
                }
            }
		}
        
        else{
        for (int x = 0; x < width-1; x=x+2) {
            for (int y = 0; y < height-1; y=y+2) {
            	int red = (getRed(pixels[y][x])+getRed(pixels[y+1][x])+getRed(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
            	int green = (getGreen(pixels[y][x])+getGreen(pixels[y+1][x])+getGreen(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
            	int blue = (getBlue(pixels[y][x])+getBlue(pixels[y+1][x])+getBlue(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
            	shrink [y/2][x/2]= makePixel(red, green, blue);
            }
        }
        }
        return shrink;
	}
	
}

/**
 * @author Zhaosong Zhu
 * Replace each pixel with the average pixel value of a small neighborhood of 2*2
 */
class Smooth extends ImageEffect{

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {
		int width = pixels[0].length;
        int height = pixels.length;
        
        if (height%2!=0)
        {
        	for (int x = 0; x < width-1; x=x+2) {
                for (int y = 0; y < height-2; y=y+2) {
                	int red = (getRed(pixels[y][x])+getRed(pixels[y+1][x])+getRed(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int green = (getGreen(pixels[y][x])+getGreen(pixels[y+1][x])+getGreen(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int blue = (getBlue(pixels[y][x])+getBlue(pixels[y+1][x])+getBlue(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	pixels [y][x]= makePixel(red, green, blue);
                	pixels [y+1][x+1]= makePixel(red, green, blue);
                	pixels [y][x+1]= makePixel(red, green, blue);
                	pixels [y+1][x]= makePixel(red, green, blue);
                	
                }
            }
        }
        else if (width%2!=0) {
        	for (int x = 0; x < width-2; x=x+2) {
                for (int y = 0; y < height-1; y=y+2) {
                	System.out.println(y);
                	System.out.println(y+1);
                	int red = (getRed(pixels[y][x])+getRed(pixels[y+1][x])+getRed(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int green = (getGreen(pixels[y][x])+getGreen(pixels[y+1][x])+getGreen(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	int blue = (getBlue(pixels[y][x])+getBlue(pixels[y+1][x])+getBlue(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
                	pixels [y][x]= makePixel(red, green, blue);
                	pixels [y+1][x+1]= makePixel(red, green, blue);
                	pixels [y][x+1]= makePixel(red, green, blue);
                	pixels [y+1][x]= makePixel(red, green, blue);
                }
            }
		}
        
        else{
        for (int x = 0; x < width-1; x=x+2) {
            for (int y = 0; y < height-1; y=y+2) {
            	int red = (getRed(pixels[y][x])+getRed(pixels[y+1][x])+getRed(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
            	int green = (getGreen(pixels[y][x])+getGreen(pixels[y+1][x])+getGreen(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
            	int blue = (getBlue(pixels[y][x])+getBlue(pixels[y+1][x])+getBlue(pixels[y][x+1])+getRed(pixels[y+1][x+1]))/4;
            	pixels [y][x]= makePixel(red, green, blue);
            	pixels [y+1][x+1]= makePixel(red, green, blue);
            	pixels [y][x+1]= makePixel(red, green, blue);
            	pixels [y+1][x]= makePixel(red, green, blue);
            }
        }
        }
        return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 * Replace each pixel with the maximum pixel value of a small neighborhood of 2*2
 */
class Dilate extends ImageEffect {

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {

		int width = pixels[0].length;
        int height = pixels.length;
        
        if (height%2!=0)
        {
        	for (int x = 0; x < width-1; x=x+2) {
                for (int y = 0; y < height-2; y=y+2) {
                	int red = Math.max(Math.max(getRed(pixels[y][x]),getRed(pixels[y+1][x])),Math.max(getRed(pixels[y][x+1]),getRed(pixels[y+1][x+1])));
                	int blue = Math.max(Math.max(getBlue(pixels[y][x]),getBlue(pixels[y+1][x])),Math.max(getBlue(pixels[y][x+1]),getBlue(pixels[y+1][x+1])));
                	int green = Math.max(Math.max(getGreen(pixels[y][x]),getGreen(pixels[y+1][x])),Math.max(getGreen(pixels[y][x+1]),getGreen(pixels[y+1][x+1])));
                	pixels [y][x]= makePixel(red, green, blue);
                	pixels [y+1][x+1]= makePixel(red, green, blue);
                	pixels [y][x+1]= makePixel(red, green, blue);
                	pixels [y+1][x]= makePixel(red, green, blue);
                	
                }
            }
        }
        else if (width%2!=0) {
        	for (int x = 0; x < width-2; x=x+2) {
                for (int y = 0; y < height-1; y=y+2) {
                	int red = Math.max(Math.max(getRed(pixels[y][x]),getRed(pixels[y+1][x])),Math.max(getRed(pixels[y][x+1]),getRed(pixels[y+1][x+1])));
                	int blue = Math.max(Math.max(getBlue(pixels[y][x]),getBlue(pixels[y+1][x])),Math.max(getBlue(pixels[y][x+1]),getBlue(pixels[y+1][x+1])));
                	int green = Math.max(Math.max(getGreen(pixels[y][x]),getGreen(pixels[y+1][x])),Math.max(getGreen(pixels[y][x+1]),getGreen(pixels[y+1][x+1])));
                	pixels [y][x]= makePixel(red, green, blue);
                	pixels [y+1][x+1]= makePixel(red, green, blue);
                	pixels [y][x+1]= makePixel(red, green, blue);
                	pixels [y+1][x]= makePixel(red, green, blue);
                }
            }
		}
        
        else{
        for (int x = 0; x < width-1; x=x+2) {
            for (int y = 0; y < height-1; y=y+2) {
            	int red = Math.max(Math.max(getRed(pixels[y][x]),getRed(pixels[y+1][x])),Math.max(getRed(pixels[y][x+1]),getRed(pixels[y+1][x+1])));
            	int blue = Math.max(Math.max(getBlue(pixels[y][x]),getBlue(pixels[y+1][x])),Math.max(getBlue(pixels[y][x+1]),getBlue(pixels[y+1][x+1])));
            	int green = Math.max(Math.max(getGreen(pixels[y][x]),getGreen(pixels[y+1][x])),Math.max(getGreen(pixels[y][x+1]),getGreen(pixels[y+1][x+1])));
            	pixels [y][x]= makePixel(red, green, blue);
            	pixels [y+1][x+1]= makePixel(red, green, blue);
            	pixels [y][x+1]= makePixel(red, green, blue);
            	pixels [y+1][x]= makePixel(red, green, blue);
            }
        }
        }
        return pixels;
	}
	
}


/**
 * @author Zhaosong Zhu
 * Replace each pixel with the minimum pixel value of a small neighborhood.
 */
class Erode extends ImageEffect {

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {

		int width = pixels[0].length;
        int height = pixels.length;
        
        if (height%2!=0)
        {
        	for (int x = 0; x < width-1; x=x+2) {
                for (int y = 0; y < height-2; y=y+2) {
                	int red = Math.min(Math.min(getRed(pixels[y][x]),getRed(pixels[y+1][x])),Math.min(getRed(pixels[y][x+1]),getRed(pixels[y+1][x+1])));
                	int blue = Math.min(Math.min(getBlue(pixels[y][x]),getBlue(pixels[y+1][x])),Math.min(getBlue(pixels[y][x+1]),getBlue(pixels[y+1][x+1])));
                	int green = Math.min(Math.min(getGreen(pixels[y][x]),getGreen(pixels[y+1][x])),Math.min(getGreen(pixels[y][x+1]),getGreen(pixels[y+1][x+1])));
                	pixels [y][x]= makePixel(red, green, blue);
                	pixels [y+1][x+1]= makePixel(red, green, blue);
                	pixels [y][x+1]= makePixel(red, green, blue);
                	pixels [y+1][x]= makePixel(red, green, blue);
                	
                }
            }
        }
        else if (width%2!=0) {
        	for (int x = 0; x < width-2; x=x+2) {
                for (int y = 0; y < height-1; y=y+2) {
                	int red = Math.min(Math.min(getRed(pixels[y][x]),getRed(pixels[y+1][x])),Math.min(getRed(pixels[y][x+1]),getRed(pixels[y+1][x+1])));
                	int blue = Math.min(Math.min(getBlue(pixels[y][x]),getBlue(pixels[y+1][x])),Math.min(getBlue(pixels[y][x+1]),getBlue(pixels[y+1][x+1])));
                	int green = Math.min(Math.min(getGreen(pixels[y][x]),getGreen(pixels[y+1][x])),Math.min(getGreen(pixels[y][x+1]),getGreen(pixels[y+1][x+1])));
                	pixels [y][x]= makePixel(red, green, blue);
                	pixels [y+1][x+1]= makePixel(red, green, blue);
                	pixels [y][x+1]= makePixel(red, green, blue);
                	pixels [y+1][x]= makePixel(red, green, blue);
                }
            }
		}
        
        else{
        for (int x = 0; x < width-1; x=x+2) {
            for (int y = 0; y < height-1; y=y+2) {
            	int red = Math.min(Math.min(getRed(pixels[y][x]),getRed(pixels[y+1][x])),Math.min(getRed(pixels[y][x+1]),getRed(pixels[y+1][x+1])));
            	int blue = Math.min(Math.min(getBlue(pixels[y][x]),getBlue(pixels[y+1][x])),Math.min(getBlue(pixels[y][x+1]),getBlue(pixels[y+1][x+1])));
            	int green = Math.min(Math.min(getGreen(pixels[y][x]),getGreen(pixels[y+1][x])),Math.min(getGreen(pixels[y][x+1]),getGreen(pixels[y+1][x+1])));
            	pixels [y][x]= makePixel(red, green, blue);
            	pixels [y+1][x+1]= makePixel(red, green, blue);
            	pixels [y][x+1]= makePixel(red, green, blue);
            	pixels [y+1][x]= makePixel(red, green, blue);
            }
        }
        }
        for(int [] c:pixels)
        	System.out.println(c);
        return pixels;
	}
	
}

/**
 * @author Zhaosong Zhu
 *  Creates a picture of red, green, and blue only filter.
 */
class Filter extends ImageEffect {

	@Override
	public int[][] apply(int[][] pixels, ArrayList<ImageEffectParam> params) {

		int heightIndex = pixels.length-1;
		int [][] part1 = new int [heightIndex/3+1][pixels[0].length];
		int [][] part2 = new int [heightIndex/3+1][pixels[0].length];
		int [][] part3 = new int [pixels.length-2*part1.length][pixels[0].length];
		System.out.println(part1.length+" "+part2.length+" "+part3.length);
		int count =0;
				
				
		for (int y=0; y< part1.length;y++)
			part1[y]= pixels[y];
		for (int y=part1.length; y<part1.length*2; y++)
			{ 
			 part2[count]= pixels[y];
			 count++;
			}
		count=0;
		for (int y= part1.length*2;y<pixels.length;y++)
		{
			part3[count] = pixels[y];
			count++;
		}
		

		ImageEffect red = new NoRed();
		ImageEffect green = new NoGreen();
		ImageEffect blue = new NoBlue();
		
		part1 = red.apply(part1, params);
		part2 = green.apply(part2, params);
		part3 = blue.apply(part3, params);
		
		for (int y=0; y< part1.length;y++)
			pixels[y] = part1[y];
		
		count=0;
		
		for (int y=part1.length; y<part1.length*2; y++)
			{ 
			pixels[y] = part2[count];
			 count++;
			}
		
		count=0;
		for (int y= part1.length*2;y<pixels.length-1;y++)
		{
			pixels[y] = part3[count];
			count++;
		}
		
		
		return pixels;
	}
	
}
