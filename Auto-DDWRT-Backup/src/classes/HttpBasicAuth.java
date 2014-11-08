package classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

public class HttpBasicAuth { 

    public boolean getBackupFile(String sourceURL, String HTTPuser, String HTTPpassword, String filePath, String fileName, String fileExt, String fileDate) throws IOException{

    	FileOutputStream fout = null;
    	boolean success = false;
        
            URL url = new URL (sourceURL);
            
            String encoding = Base64.encodeBase64String(StringUtils.getBytesUtf8(HTTPuser+":"+HTTPpassword));
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            
            //generate output file
            fout = new FileOutputStream(filePath+fileName+fileDate+fileExt);

            final byte data[] = new byte[1024];
            int count;
            while ((count = content.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
            
            if (fout != null) {
                fout.close();
                success = true;
            }
            
            return success;
            
    }//end getBackupFile()

}//end class