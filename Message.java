package com.company;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.String;
import java.io.IOException;
public class Message {
    private String message;
    private String path;
    public Message(String outputStream, String filePath){
        message = outputStream;
        path = filePath;
    }
    public void writeFile(){
        File file = null;
        FileOutputStream fos = null;
        try {
            file = new File(path);
            fos = new FileOutputStream(file);
            byte[] b = message.getBytes();
            for (int i = 0; i < b.length; i++) {
                fos.write((char) (b[i]));
            }
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally{
            if (fos != null){
                try {
                    fos.close();
                }
                catch(IOException error){
                    System.err.println("IOException: " + error.getMessage());
                }
            }
            else{
                System.out.println("ERROR: file did not open");
            }
        }
    }

}
