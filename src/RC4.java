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

    public int[] KeyStream(int[] key) {
        int[] S = new int[256];
        for (int i = 0; i < 256; i++) {
            S[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
          
          j = (j + S[i]+key[i % key.length]) % 256;
          
          int temp = S[i];
          S[i] = S[j];
          S[j] = temp;
          
        }
        return S;
    }

    public static void main(String[] args) {

    }
}
