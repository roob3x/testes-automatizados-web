package utils;
import com.sun.javafx.util.Utils;
import io.cucumber.plugin.event.PickleStepTestStep;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.Driver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot extends Utils{

    static Log Logger = (Log) LogFactory.getLog(Screenshot.class);
    private static String path;
    private static SimpleDateFormat timestampEvidencia;
    public static SimpleDateFormat timeStampPasta;

    private static PickleStepTestStep currentStep;

    public static void takeScreenShot(){
        String stepName = "";
        String nomePasta = "fotos";
        try{
            stepName = currentStep.getStepText();
        }
        catch (NullPointerException ignored){
            Logger.warn("nome do step nao encontrado");
        }
        String nomePrint = "Evidencia";
        Date date = new Date();
        File scrFile = (File)((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(scrFile, new File(path + ""  + "/" + nomePasta + "/"
                    + "_" + timeStampPasta.format(date) + "/" + nomePrint + "_" + stepName + " "
                    + timestampEvidencia.format(date)+ ".png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    static {
        path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "relatorios"
                + File.separator + "screenshot" + File.separator;
        timestampEvidencia = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        timeStampPasta = new SimpleDateFormat("yyMMdd");
    }
}
