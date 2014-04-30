package Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ivan
 */
public class RC4 {

    private int[] text;
    private int[] key;
    private BufferedReader reader;

    public RC4(File text, File key) throws IOException {
        this.key = toArray(key);
        this.text = toArray(text);
        
    }

    public int[] toArray(File f) throws FileNotFoundException, IOException {
        reader = new BufferedReader(new FileReader(f));
        String key = reader.readLine();
        int[] arr = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            arr[i] = (int) key.charAt(i);
        }
        return arr;
    }

    public int[] KeyStream(int[] key) {
        int[] S = new int[256];
        for (int i = 0; i < 256; i++) {
            S[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {

            j = (j + S[i] + key[i % key.length]) % 256;

            int temp = S[i];
            S[i] = S[j];
            S[j] = temp;

        }
        return S;
    }
    /*
    
     */

    public int[] encryption(int[] message, int[] S) {
        int i = 0;
        int j = 0;

        for (int k = 0; k < message.length; k++) {
            i = (i + 1) % 256;
            j = (j + S[i]) % 256;
            int temp = S[i];
            S[i] = S[j];
            S[j] = temp;
            int l = (S[i] + S[j]) % 256;
            message[k] = (message[k] ^ S[l]);
        }
        return message;
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String key = in.next();
//        String plaintext = in.next();
//        int [] arr = new int [key.length()];
//        for(int i = 0; i<key.length(); i++ ){  
//            arr[i] = (int) key.charAt(i);
//        }
//        int [] arr2 = KeyStream(arr);
//        int [] arr3 = new int [plaintext.length()];
//        for(int i = 0; i< plaintext.length(); i++){
//            arr3[i] = (int)plaintext.charAt(i);
//        }
//        int [] message = encryption(arr3,arr2);
//        for(int i = 0; i<message.length;i++){
//            System.out.print(message[i]+" ");
//        }
//    }
}
