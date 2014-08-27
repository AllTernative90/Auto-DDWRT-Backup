package classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

//	http://stackoverflow.com/questions/469695/decode-base64-data-in-java
//	http://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
public class HttpBasicAuth {

    public void getBackupFile(String sourceURL, String HTTPuser, String HTTPpassword, String filePath, String fileName, String fileExt, String fileDate) throws IOException{

    	FileOutputStream fout = null;
        
        try {
            URL url = new URL (sourceURL);
            
            String encoding = Base64.encodeBase64String(StringUtils.getBytesUtf8(HTTPuser+":"+HTTPpassword));
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            
//            generate output file
            fout = new FileOutputStream(filePath+fileName+fileDate+fileExt);

            final byte data[] = new byte[1024];
            int count;
            while ((count = content.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }finally {
	            if (fout != null) {
	                fout.close();
	            }
	        }
            
    }

}