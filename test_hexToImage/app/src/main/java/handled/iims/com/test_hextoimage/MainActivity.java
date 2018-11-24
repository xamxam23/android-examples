package handled.iims.com.test_hextoimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.common.io.BaseEncoding;

import org.apache.commons.io.HexDump;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        byte[] bytes = toByte(readData());
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        ImageView imageView = findViewById(R.id.imageView);

        imageView.setImageBitmap(bitmap);
    }

    private String readData() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+"/bmp.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String content = bufferedReader.readLine();
            Log.d("x-e", "content " + content.length());
            bufferedReader.close();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("x-e", e.toString());
        }
        return null;
    }

    static byte[] toByte_(String s){
        return new BigInteger("00A0BF", 16).toByteArray();
    }

    static byte[] toByte(String s){
        Decoder
    }
    public static byte[] toByte__(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}