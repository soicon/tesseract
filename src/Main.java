
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {

    public static void main(String[] args) {
        try {
            gaussianBLur();
//            ITesseract instance = new Tesseract();
//            instance.setLanguage("vie");
//            try
//            {
//                String imgText = instance.doOCR(new File("test.jpg"));
//                System.out.println(imgText);
//            }
//            catch (TesseractException e)
//            {
//                e.getMessage();
//
//            }
        }catch (Exception ex){

        }

    }

    public  static void initOpenCV(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
    }

    public static void gaussianBLur( ) {

        try {
            System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

            Mat source = Imgcodecs.imread("test.jpg",
                    Imgcodecs.IMREAD_COLOR);

            Mat destination = new Mat(source.rows(),source.cols(),Imgproc.CV_8);
            Imgproc.GaussianBlur(source, destination,new Size(45,45), 0);
            Imgproc.adaptiveThreshold(source, source, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
                    Imgproc.THRESH_BINARY_INV, 75,10);
            Imgcodecs.imwrite("Gaussian45.jpg", destination);

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
