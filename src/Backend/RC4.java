package Backend;

import java.io.File;

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
    
    private File text;
    private File key;
    public RC4(File text,File key){
        this.text = text;
        this.key = key;
    }
    public static int[] KeyStream(int[] key) {
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

    public static int[] encryption(int[] message, int[] S) {
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
