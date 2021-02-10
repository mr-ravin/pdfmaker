package ravin.developer.pdfmaker;
import androidx.appcompat.app.AppCompatActivity;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.PDPageContentStream;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.os.Environment;
import java.io.File;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    String filename=null;
    String endfilename=null;
    PDDocument document = new PDDocument();
    PDPageContentStream contentStream;
    PDImageXObject alphaXimage;
    PDPage page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        endfilename=new Date().toString();
        PDFBoxResourceLoader.init(getApplicationContext());
        RealPathUtil obj = new RealPathUtil();
        try {
            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && null != data) {
                if(data.getClipData() != null){
                    int count = data.getClipData().getItemCount();
                    for (int i=0; i<count; i++){
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        imageEncoded=obj.getRealPath(this,imageUri);
                        page = new PDPage(PDRectangle.A4);
                        document.addPage(page);
                        contentStream = new PDPageContentStream(document, page);
                        alphaXimage = PDImageXObject.createFromFile(imageEncoded, document);
                        contentStream.drawImage(alphaXimage, 5,5,PDRectangle.A4.getWidth()-10, PDRectangle.A4.getHeight()-10);
                        contentStream.close();
                    }
                }
                else if(data.getData() != null){
                    Uri imgUri = data.getData();
                    imageEncoded=obj.getRealPath(this,imgUri);
                    page = new PDPage(PDRectangle.A4);
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    alphaXimage = PDImageXObject.createFromFile(imageEncoded, document);
                    contentStream.drawImage(alphaXimage, 5,5,PDRectangle.A4.getWidth()-10, PDRectangle.A4.getHeight()-10);
                    contentStream.close();
                }
                filename=Environment.getExternalStorageDirectory()+"/"+endfilename+".pdf";
                document.save(new File(filename));
                document.close();
                Toast.makeText(this, "Completed, "+filename, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error, "+e, Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}